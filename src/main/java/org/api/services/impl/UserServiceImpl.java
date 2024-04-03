package org.api.services.impl;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;

import org.api.annotation.LogExecutionTime;
import org.api.bean.ResultBean;
import org.api.bean.jpa.UserLoginEntity;
import org.api.repository.user.UserLoginRepository;
import org.api.services.UserService;
import org.api.utils.ApiValidateException;
import org.api.utils.ConstantColumns;
import org.api.utils.Constants;
import org.api.utils.DataUtil;
import org.api.utils.ItemNameUtils;
import org.api.utils.MailUtil;
import org.api.utils.MessageUtils;
import org.api.utils.ValidateData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.JsonObject;

/**
 * [OVERVIEW] UserController.
 *
 * @author: (TanDX)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2022/07/01      (TanDX)            Create new
*/
@LogExecutionTime
@Service
@Transactional(rollbackFor = { ApiValidateException.class, Exception.class })
public class UserServiceImpl implements UserService {
    /** The Constant log. */
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    /** The Constant FILE_JSON_VALIDATE. */
    public static final String FILE_JSON_VALIDATE = "user.json";

    /** The Constant ALIAS. */
    public static final String ALIAS = "User";

    @Autowired
    private UserLoginRepository UserLoginRepo;

    /** The Constant FILE_NAME_CSV. */
    public static final String FILE_NAME_CSV = "顧客一覧";

    /** The Constant CURRENCY. */
    public static final String CURRENCY = "¥";

    /** The Constant NO. */
    public static final String NO = "可";

    /** The Constant YES. */
    public static final String YES = "不可";

    /** The Constant LOCK. */
    public static final String LOCK = "ロック";

    /** The Constant UNLOCK. */
    public static final String UNLOCK = "アンロック";

    /** The Constant COMMON_ID. */
    public static final Integer COMMON_ID = 6;

    /** The Constant API_REGIS_PARTNERS. */
    public static final String API_REGIS_PARTNERS = "/api/common/regis-partners";

    /** The Constant API_REGIS_PARTNERS. */
    public static final String API_PARTNERS = "/api/common/partners/";

    @Autowired
    public MailUtil mailUtil;

    /** The email sender. */
    public static JavaMailSender emailSender;

    /** The uri. */
    @Value("${api.uri}")
    private String uri;

    /** The auth name. */
    @Value("${api.authorization.name}")
    private String authName;

    /** The auth type. */
    @Value("${api.authorization.type}")
    private String authType;

    /** The content type name. */
    @Value("${api.content.type.name}")
    private String contentTypeName;

    /** The content type value. */
    @Value("${api.content.type.value}")
    private String contentTypeValue;

    /**
     * Creates the user.
     *
     * @author (TanDX)
     * @param json
     * @return the result bean
     * @throws ApiValidateException
     * @throws Exception
     */

    @Override
    public ResultBean createUser(String json) throws ApiValidateException, Exception {
        UserLoginEntity userLoginEntity = new UserLoginEntity();

        // Get object json
        JsonObject jsonObject = DataUtil.getJsonObject(json);
        ValidateData.validate(FILE_JSON_VALIDATE, jsonObject, false);

        this.convertJsonToEntity(jsonObject, userLoginEntity);

//        if (!userLoginDao.checkMailDuplicate(userLoginEntity.getMail())) {
//            return new ResultBean(Constants.ID_BKE00041, Constants.STATUS_BAD_REQUEST, MessageUtils.getMessage(Constants.ID_BKE00041));
//        }
        UserLoginRepo.save(userLoginEntity);
        return new ResultBean(userLoginEntity, Constants.STATUS_201, Constants.MESSAGE_OK);
    }

    /**
     * Gets the user by id.
     *
     * @author (TanDX)
     * @param id
     * @return the user by id
     * @throws ApiValidateException
     */
    @Override
    public ResultBean getUserById(Integer id) throws ApiValidateException {
        Map<String, Object> map = new HashMap<String, Object>();
        Optional<UserLoginEntity> userOptional = UserLoginRepo.findOneById(id);

        if (userOptional.isPresent()) {
            map.put(ConstantColumns.USER, userOptional.get());
            return new ResultBean(map, Constants.STATUS_OK, Constants.MESSAGE_OK);
        } else {
            throw new ApiValidateException(Constants.ID_BKE00019, ConstantColumns.USER_ID,
                    MessageUtils.getMessage(Constants.ID_BKE00019, null, ItemNameUtils.getItemName(ConstantColumns.USER_ID, ALIAS)));
        }
    }

    /**
     * Update user.
     *
     * @author (TanDX)
     * @param json
     * @return the result bean
     * @throws Exception
     */
    @Override
    public ResultBean updateUser(String json) throws Exception {
        JsonObject jsonObject = DataUtil.getJsonObject(json);
        // check user id
        if (DataUtil.isNull(jsonObject, ConstantColumns.USER_ID)) {
            throw new ApiValidateException(Constants.ID_BKE00004, ConstantColumns.USER_ID,
                    MessageUtils.getMessage(Constants.ID_BKE00004, new Object[] { ItemNameUtils.getItemName(ConstantColumns.USER_ID, ALIAS) }));
        }

        Integer userId = DataUtil.getJsonInteger(jsonObject, ConstantColumns.USER_ID);

        Optional<UserLoginEntity> userLoginEntity = UserLoginRepo.findOneById(userId);
        if (!userLoginEntity.isPresent()) {
            throw new ApiValidateException(Constants.ID_BKE00019, ConstantColumns.USER_ID,
                    MessageUtils.getMessage(Constants.ID_BKE00019, null, ItemNameUtils.getItemName(ConstantColumns.USER_ID, ALIAS)));
        }
        UserLoginEntity loginEntity = userLoginEntity.get();
        loginEntity.setAddress("TEET");
        // update user info
        this.convertJsonToEntity(jsonObject, loginEntity);
        return new ResultBean(Constants.STATUS_OK, Constants.MESSAGE_OK);
    }

    /**
     * Gets the users.
     *
     * @author (TanDX)
     * @param userName
     * @param userId
     * @param page
     * @param size
     * @return the users
     * @throws ApiValidateException
     */
    @Override
    public Page<UserLoginEntity> getUsers(Pageable pageRequest, String keyWord)
            throws Exception {
        Page<UserLoginEntity> response = UserLoginRepo.findUserLogin(keyWord, pageRequest);
        return new PageImpl<>(response.getContent(), response.getPageable(), response.getTotalElements());
    }

    /**
     * Creates the user info CSV.
     *
     * @author (TanDX)
     * @param httpServletResponse
     * @param keyWord
     * @param header
     * @throws ApiValidateException
     * @throws Exception
     */
    @Override
    public void createUserInfoCSV(HttpServletResponse httpServletResponse, String keyWord, String[] header)
            throws ApiValidateException, Exception {
//        ResultBean result = this.getUsers(null,null,keyWord, null, null);
//        if (result != null && result.getData() != null) {
//            UserPageResponse response = (UserPageResponse) result.getData();
//            if (response.getResults() != null && !response.getResults().isEmpty()) {
//                List<UserLoginResponse> data = response.getResults();
//                for (UserLoginResponse res : data) {
//                    if (res.getGender().equals("1")) {
//                        res.setGender("男性");
//                    } else if (res.getGender().equals("2")) {
//                        res.setGender("一般ユーザー");
//                    } else {
//                        res.setGender("その他");
//                    }
//                    if (res.getRole().equals("ADMIN")) {
//                        res.setRole("管理者");
//                    } else {
//                        res.setRole("一般ユーザー");
//                    }
//                }
//                List<String[]> csvData = null;
//                csvData = data.stream().map(value -> {
//                    return new String[] { Objects.isNull(value.getUserId()) ? "" : value.getUserId().toString(), Objects.isNull(value.getUserName()) ? "" : value.getUserName(), Objects.isNull(value.getRole()) ? "" : value.getRole(),
//                            Objects.isNull(value.getMail()) ? "" : value.getMail(), Objects.isNull(value.getBirthDay()) ? "" : value.getBirthDay(),
//                            Objects.isNull(value.getGender()) ? "" : value.getGender(), Objects.isNull(value.getPhone()) ? "" : value.getPhone(),
//                            Objects.isNull(value.getAddress()) ? "" : value.getAddress(),
//                            };
//                }).collect(Collectors.toCollection(LinkedList::new));
//                String fileName = ALIAS + Constants.UNDERSCORE + DataUtil.getDateTime() + Constants.DOT + Constants.CSV;
//                DataUtil.createFileCSV(httpServletResponse, fileName, header, csvData);
//            } else {
//                throw new ApiValidateException(Constants.ID_BKE00070, ConstantColumns.USER,
//                        MessageUtils.getMessage(Constants.ID_BKE00070, new Object[] { ItemNameUtils.getItemName(ConstantColumns.USER, ALIAS) }));
//            }
//        } else {
//            throw new ApiValidateException(Constants.ID_BKE00070, ConstantColumns.USER,
//                    MessageUtils.getMessage(Constants.ID_BKE00070, new Object[] { ItemNameUtils.getItemName(ConstantColumns.USER, ALIAS) }));
//        }
    }


    /**
     * Gets the user info entity.
     *
     * @author (TanDX)
     * @param json
     * @param entity
     * @return the user info entity
     * @throws ApiValidateException
     */
    private void convertJsonToEntity(JsonObject json, UserLoginEntity entity) throws ApiValidateException {
        if (DataUtil.hasMember(json, ConstantColumns.USER_NAME)) {
            entity.setUserName(DataUtil.getJsonString(json, ConstantColumns.USER_NAME));
        }
        if (DataUtil.hasMember(json, ConstantColumns.COMPANY_ID)) {
            entity.setCompanyId(DataUtil.getJsonInteger(json, ConstantColumns.COMPANY_ID));
        }
        if (DataUtil.hasMember(json, ConstantColumns.MAIL)) {
            entity.setMail(DataUtil.getJsonString(json, ConstantColumns.MAIL));
        }
        if (DataUtil.hasMember(json, ConstantColumns.BIRTH_DAY)) {
            entity.setBirthDay(DataUtil.getJsonString(json, ConstantColumns.BIRTH_DAY));
        }
        if (DataUtil.hasMember(json, ConstantColumns.GENDER)) {
            entity.setGender(DataUtil.getJsonString(json, ConstantColumns.GENDER));
        }
        if (DataUtil.hasMember(json, ConstantColumns.PHONE)) {
            entity.setPhone(DataUtil.getJsonString(json, ConstantColumns.PHONE));
        }
        if (DataUtil.hasMember(json, ConstantColumns.ADDRESS)) {
            entity.setAddress(DataUtil.getJsonString(json, ConstantColumns.ADDRESS));
        }
        if (DataUtil.hasMember(json, ConstantColumns.FREE_ITEM1)) {
            entity.setFreeItem1(DataUtil.getJsonString(json, ConstantColumns.FREE_ITEM1));
        }
        if (DataUtil.hasMember(json, ConstantColumns.FREE_ITEM2)) {
            entity.setFreeItem2(DataUtil.getJsonString(json, ConstantColumns.FREE_ITEM2));
        }
        if (DataUtil.hasMember(json, ConstantColumns.FREE_ITEM3)) {
            entity.setFreeItem3(DataUtil.getJsonString(json, ConstantColumns.FREE_ITEM3));
        }
    }

    /**
     * Get header.
     *
     * @param jwt
     * @return the header
     * @author: (TanDX)
     */
    private HttpHeaders getHeader(String jwt) {
        HttpHeaders header = new HttpHeaders();
        header.add(authName, authType + " " + jwt);
        header.add(contentTypeName, contentTypeValue);
        header.setAcceptCharset(Arrays.asList(Charset.forName("UTF-8")));
        return header;
    }

    /**
     * Send mail to user.
     * @author (TanDX)
     * @param mailsTo
     * @param body
     * @throws MessagingException
     */
    public void sendMailToUser(String mailsTo, String body) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper;
        helper = new MimeMessageHelper(message, true, Constants.ENCODEDING_UFT8);
        helper.setFrom(MailUtil.getItemMail(Constants.KEY_MAIL_FROM));
        helper.setSubject(MailUtil.getItemMail(Constants.KEY_MAIL_CREATE_USER_SUBJECT));
        helper.setTo(mailsTo);
        message.setContent(body, Constants.MAIL_CONTENT_TYPE);
        emailSender.send(message);
    }

    /**
    *
    * @author (TanDX)
    *
    * @param id
    * @param urlRedirect
    * @return the string
    */
    @Override
    public ResultBean sendMail(Integer id, String urlRedirect) throws ApiValidateException, Exception {
        // Send mail to user
        Optional<UserLoginEntity> optional = UserLoginRepo.findOneById(id);
        if (!optional.isPresent()) {
            throw new ApiValidateException(Constants.ID_BKE00019, ConstantColumns.USER_ID,
                    MessageUtils.getMessage(Constants.ID_BKE00019, null, ItemNameUtils.getItemName(ConstantColumns.USER_ID, ALIAS)));
        }
        UserLoginEntity userLoginEntity = optional.get();
        String userId = String.format("%06d", id);
        String password = DataUtil.genPassword();
        //userLoginEntity.setPassword(passwordEncode.encode(password));
        UserLoginRepo.save(userLoginEntity);
        mailUtil.sendMailToUser(userLoginEntity.getMail(), MailUtil.settingContentMailUserInforLogin(userLoginEntity.getUserName(), userId, password, urlRedirect));
        return new ResultBean(Constants.STATUS_OK, Constants.MESSAGE_OK);
    }

    @Override
    public UserLoginEntity findByUsername(String userName) {
        UserLoginEntity user = new UserLoginEntity();
        user = UserLoginRepo.findOneByUserName(userName);
        if (Objects.nonNull(user)) {
            return user;
        }

        return user;
    }
}

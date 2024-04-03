/////////////////////////////////////////////////////////////////////////////
//
// © 2022 API. All right reserved.
//
/////////////////////////////////////////////////////////////////////////////

package org.api.utils;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.api.bean.jpa.UserLoginEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * [OVERVIEW] MailUtil.
 *
 * @author: (TanDX)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2022/07/01     (TanDX)       Create new
*/
@Service
public class MailUtil {

	/** The Constant logger. */
    private static final Logger log = LoggerFactory.getLogger(MailUtil.class);

	/** The email sender. */
    @Autowired
    public JavaMailSender emailSender;

    private static ResourceBundle rsItemMail;

    /*
     * Get resource and set bundle locate default
     */
    public static String getItemMail(String key, Object... param) {

        // Load all message from message.properties
        if (rsItemMail == null) {
            rsItemMail = ResourceBundle.getBundle(Constants.PROPERTIE_ITEM_MAIL);
        }
        String message;
        try {
            // Get message from rsMessages
            message = rsItemMail.getString(key);

            if (DataUtil.isEmpty(message)) {
                message = key;
            }
            if (param != null && param.length > 0) {
                message = MessageFormat.format(message, param);
            }
        } catch (MissingResourceException e) {
            message = key;
        }
        // return content
        return message;
    }

    /**
     * Send mail to user.
     * @author (TanDX)
     * @param mailsTo the mails to
     * @param body the body
     * @throws MessagingException the messaging exception
     */
    public void sendMailToUser(String mailsTo, String body) throws MessagingException {
        log.info("### sendMailToUser() START ###");
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper;
        helper = new MimeMessageHelper(message, true, Constants.ENCODEDING_UFT8);
        helper.setFrom(MailUtil.getItemMail(Constants.KEY_MAIL_FROM));
        helper.setSubject(MailUtil.getItemMail(Constants.KEY_MAIL_CREATE_USER_SUBJECT));
        helper.setTo(mailsTo);
        message.setContent(body, Constants.MAIL_CONTENT_TYPE);
        emailSender.send(message);
        log.info("### sendMailToUser() END ###");
    }

    /**
     * Setting content mail user infor lofin.
     * @author (TanDX)
     * @param username
     * @param userId
     * @param password
     * @param urlRedirect
     * @return the string
     */
    public static String settingContentMailUserInforLogin(String username, String userId, String password, String urlRedirect) {
        String body = MailUtil.getItemMail(Constants.KEY_MAIL_CREATE_USER_BODY);
        return body.replace('{' + Constants.KEY_MAIL_USER_TO + '}', username)
                .replace('{' + Constants.KEY_MAIL_USER_WELLCOME + '}', MailUtil.getItemMail(Constants.KEY_MAIL_USER_WELLCOME))
                .replace('{' + Constants.KEY_MAIL_USER_FROM + '}', MailUtil.getItemMail(Constants.KEY_MAIL_USER_FROM))
                .replace('{' + Constants.KEY_MAIL_USER_THANKS_START + '}', MailUtil.getItemMail(Constants.KEY_MAIL_USER_THANKS_START))
                .replace('{' + Constants.KEY_MAIL_USER_CONTENT + '}', MailUtil.getItemMail(Constants.KEY_MAIL_USER_CONTENT))
                .replace('{' + Constants.KEY_MAIL_USER_ID_TITLE + '}', MailUtil.getItemMail(Constants.KEY_MAIL_USER_ID_TITLE))
                .replace('{' + ConstantColumns.USER_ID + '}', userId)
                .replace('{' + Constants.KEY_MAIL_PASSWORD_TITLE + '}', MailUtil.getItemMail(Constants.KEY_MAIL_PASSWORD_TITLE))
                .replace('{' + ConstantColumns.PASSWORD + '}', password)
                .replace('{' + Constants.KEY_MAIL_URL_LOGIN + '}', MailUtil.getItemMail(Constants.KEY_MAIL_URL_LOGIN))
                .replace('{' + Constants.KEY_MAIL_URL + '}', urlRedirect)
                .replace('{' + Constants.KEY_MAIL_FOOTER + '}', MailUtil.getItemMail(Constants.KEY_MAIL_FOOTER))
                .replace('{' + Constants.KEY_MAIL_USER_THANKS_END + '}', MailUtil.getItemMail(Constants.KEY_MAIL_USER_THANKS_END));
    }

    /**
     *
     * @author (TanDX)
     *
     * @param username
     * @param userIdFormat
     * @param password
     * @param urlRedirect
     * @param UserInfoEntity
     * @return the string
     */
    public static String settingContentMailEndUserInfoLogin(String username, Integer userId, String password, String urlRedirect, UserLoginEntity entity) {
        String body = MailUtil.getItemMail(Constants.KEY_MAIL_CREATE_END_USER_BODY);
        return body.replace('{' + Constants.KEY_MAIL_USER_TO + '}', username).replace('{' + Constants.KEY_DELEGATE + '}', entity.getUserName())
                .replace('{' + ConstantColumns.USER_ID + '}', String.valueOf(userId)).replace('{' + ConstantColumns.PASSWORD + '}', password)
                .replace('{' + Constants.KEY_MAIL_URL + '}', urlRedirect).replace('{' + Constants.KEY_DELEGATE_TEL + '}', entity.getPhone())
                .replace('{' + Constants.KEY_DELEGATE_MAIL + '}', entity.getMail());
    }
}

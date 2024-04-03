/////////////////////////////////////////////////////////////////////////////
//
// © 2022 API. All right reserved.
//
/////////////////////////////////////////////////////////////////////////////

package org.api.services;

import javax.servlet.http.HttpServletResponse;

import org.api.bean.ResultBean;
import org.api.bean.jpa.UserLoginEntity;
import org.api.utils.ApiValidateException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [OVERVIEW] userInfoService.
 *
 * @author: (TanDX)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2022/07/01    (TanDX)       Create new
*/

public interface UserService {

    /**
     * create user.
     *
     * @author (TanDX)
     * @param json
     * @return ResultBean
     */
    public ResultBean createUser(String json) throws ApiValidateException, Exception;

    /**
     * get user by id.
     *
     * @author (TanDX)
     * @param id
     * @return ResultBean
     * @throws ApiValidateException
     * @throws Exception
     */
    public ResultBean getUserById(Integer id) throws ApiValidateException;

    /**
     * update user.
     *
     * @author (TanDX)
     * @param json
     * @return ResultBean
     * @throws ApiValidateException
     * @throws Exception
     */
    public ResultBean updateUser(String json) throws ApiValidateException, Exception;

    /**
     * get list users.
     *
     * @author (TanDX)
     * @param sort
     * @param column
     * @param keyWord
     * @param page
     * @param size
     * @return the users
     * @throws ApiValidateException
     * @throws Exception
     */
    public Page<UserLoginEntity> getUsers(Pageable pageable, String keyWord)
            throws Exception;

    /**
     * download csv user.
     *
     * @author (TanDX)
     * @param httpServletResponse
     * @param keyWord
     * @param header
     * @throws ApiValidateException
     * @throws Exception
     */
    public void createUserInfoCSV(HttpServletResponse httpServletResponse, String keyWord, String[] header)
            throws ApiValidateException, Exception;

    /**
     * SendMail
     *
     * @author (TanDX)
     * @param id
     * @return ResultBean
     * @throws ApiValidateException
     * @throws Exception
     */
    public ResultBean sendMail(Integer id, String urlRedirect) throws ApiValidateException, Exception;

    /**
     * SendMail
     *
     * @author (TanDX)
     * @param userName
     * @return ResultBean)
     * @throws ApiValidateException
     * @throws Exception
     */
    public UserLoginEntity findByUsername(String userName);
}

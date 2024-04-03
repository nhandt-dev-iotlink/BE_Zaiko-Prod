/////////////////////////////////////////////////////////////////////////////
//
// © 2022 API. All right reserved.
//
/////////////////////////////////////////////////////////////////////////////

package org.api.services;

import javax.servlet.http.HttpServletRequest;

import org.api.bean.ResultBean;
import org.api.utils.ApiValidateException;

/**
 * [OVERVIEW] CommonService.
 *
 * @author:  (TanDX)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2022/07/01      (TanDX)       Create new
*/
public interface CommonService {

    /**
     * Get Setting Maintenance.
     *
     * @param url_redirect
     * @param request
     * @return the auth guard
     * @throws Exception 
     */
    public ResultBean getAuthGuard(String url_redirect, HttpServletRequest request) throws Exception;

    /**
     * Check lock user.
     *
     * @author (TanDX)
     * Check lock user.
     * @param request
     * @return the result bean
     * @throws ApiValidateException the api validate exception
     */
    public ResultBean checkLockuser(HttpServletRequest request) throws ApiValidateException;

    /**
     * Gets the yard fowarder.
     *
     *@author (TanDX)
     * @param request
     * @return the yard fowarder
     * @throws ApiValidateException the api validate exception
     */
    public ResultBean getYardFowarder(HttpServletRequest request) throws ApiValidateException;



    /**
     * Gets the user profile.
     * @author (TanDX)
     * @return the user profile
     * @throws ApiValidateException the api validate exception
     */
    public ResultBean getUserProfile() throws ApiValidateException;

    /**
     * Gets data dialog common
     *
     *@author (TanDX)
     *@param sql
     *@return the array data
     */
	ResultBean getDataDialogCommon(String json);

	/**
     * GetInfoByZipCode
     *
     *@author (TanDX)
     *@param Integer
     *@return the array data
     */
	ResultBean getInfoByZipCode(Integer zipCode) throws ApiValidateException;
}

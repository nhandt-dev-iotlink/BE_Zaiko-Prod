/////////////////////////////////////////////////////////////////////////////
//
// © 2022 Oauth. All right reserved.
//
/////////////////////////////////////////////////////////////////////////////

package org.api.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * [OVERVIEW] Cookie Util.
 *
 * @author: (TANDX)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2022/07/01      (TANDX)       Create new
*/
@Component
public class CookieUtil {

    /** The domain. */
    @Value("#{'${jc.jc_domain}'}")
    private String jcDomain;

    /** The secure. */
    @Value("#{'${jc.jc_secure}'}")
    private Boolean jcSecure;

    /**
     * Creates the access token cookie.
     * @author (TANDX)
     * Create access token in cookie
     * @param response the response
     * @param token the token
     * @param duration the duration
     */
    public void createAccessTokenCookie(HttpServletResponse response, String token, Integer duration) {
        Cookie cookie = new Cookie(Constants.SESSION, token);
        cookie.setHttpOnly(true);
        cookie.setSecure(jcSecure);
        cookie.setPath("/");
        cookie.setDomain(jcDomain);
        cookie.setMaxAge(duration);
        response.addCookie(cookie);
    }

    /**
     * Delete access token cookie.
     * @author (TANDX)
     * Delete access token in Cookie
     * @param response the response
     */
    public void deleteAccessTokenCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie(Constants.SESSION, "");
        cookie.setHttpOnly(true);
        cookie.setSecure(jcSecure);
        cookie.setPath("/");
        cookie.setDomain(jcDomain);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}

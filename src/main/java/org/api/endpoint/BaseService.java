/////////////////////////////////////////////////////////////////////////////
//
// © 2022 API. All right reserved.
//
/////////////////////////////////////////////////////////////////////////////

package org.api.endpoint;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;

/**
 * [OVERVIEW] JC base service.
 *
 * @author: (TanDX)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2022/07/01      (TanDX)       Create new
*/
public abstract class BaseService {

    @Value("${api.uri}")
    private String uri;

    @Value("${api.authorization.name}")
    private String authName;

    @Value("${api.authorization.type}")
    private String authType;

    @Value("${api.content.type.name}")
    private String contentTypeName;

    @Value("${api.content.type.value}")
    private String contentTypeValue;

    /**
     * Get header
     * @author: (TanDX)
     * @param jwt
     * @return
     */
    protected HttpHeaders getHeader(String jwt) {
        HttpHeaders header = new HttpHeaders();
        header.add(authName, authType + " " + jwt);
        header.add(contentTypeName, contentTypeValue);
        header.setAcceptCharset(Arrays.asList(Charset.forName("UTF-8")));
        return header;
    }
}

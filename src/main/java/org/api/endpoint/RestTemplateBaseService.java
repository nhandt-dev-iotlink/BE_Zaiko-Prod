/////////////////////////////////////////////////////////////////////////////
//
// © 2022 API. All right reserved.
//
/////////////////////////////////////////////////////////////////////////////

package org.api.endpoint;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * [OVERVIEW] Rest template base service.
 *
 * @author: (TanDX)
 * @version: 1.0
 * @param <T>
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2020/08/01      (TanDX)       Create new
*/
@Service
public class RestTemplateBaseService<T> {

    @Autowired
    private RestTemplate restTemplate;

    /**
    *
    * @author: (TanDX)
    * @param <T>
    * @param url
    * @param httpMethod
    * @param httpHeader
    * @param body
    * @return
    * @throws URISyntaxException
    */
    @SuppressWarnings({"hiding" })
    public <T> ResponseEntity<T> callRestTemplate(String url, HttpMethod httpMethod, HttpHeaders httpHeader, String body, Class<T> generic)
            throws URISyntaxException {
        URI uri = new URI(url);
        httpHeader.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(body, httpHeader);
        return restTemplate.exchange(uri, httpMethod, request, generic);
    }

}

/////////////////////////////////////////////////////////////////////////////
//
// © 2022 API. All right reserved.
//
/////////////////////////////////////////////////////////////////////////////

package org.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * [OVERVIEW] ApiApplication.
 *
 * @author: (TanDX)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2020/01/03      (TanDX)     Create new
*/
@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ApiApplication.class, args);
    }
}

/////////////////////////////////////////////////////////////////////////////
//
// © 2020 COMMON
//
/////////////////////////////////////////////////////////////////////////////

package org.api.config.exceptionhandler;

import org.api.bean.ResultBean;
import org.api.utils.ApiValidateException;
import org.api.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * [OVERVIEW] Rest Exception Handler.
 *
 * @author: (VIMASH)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2022/12/28      (VIMASH)           Create new
*/
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ResultBean> handleException(Exception ex) {
        log.error(ex.getMessage(), ex);
        ResultBean resultBean = new ResultBean(Constants.STATUS_SYSTEM_ERROR, Constants.MESSAGE_SYSTEM_ERROR);
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ApiValidateException.class)
    protected ResponseEntity<ResultBean> handleApiValidateException(ApiValidateException ex) {
        log.error(ex.getMessage(), ex);
        ResultBean resultBean = new ResultBean(ex.getCode(), ex.getField(), ex.getMessage());
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.BAD_REQUEST);
    }
}

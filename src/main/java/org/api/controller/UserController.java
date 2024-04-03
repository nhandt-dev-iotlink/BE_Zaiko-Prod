package org.api.controller;

import org.api.annotation.LogExecutionTime;
import org.api.bean.ResultBean;
import org.api.bean.jpa.UserLoginEntity;
import org.api.services.UserService;
import org.api.utils.ApiValidateException;
import org.api.utils.PageableConstrants;
import org.api.utils.PaginationUtils;
import org.api.utils.Paging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * [OVERVIEW] UserController.
 *
 * @author: (TanDX)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2022/07/15      (TanDX)        Create new
*/

@LogExecutionTime
@RestController
public class UserController {
    /** The Constant log. */
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    /** The info service. */
    @Autowired
    private UserService userService;

    /**
     * Add the user info.
     *
     * @author (TanDX)
     * @param json
     * @return the response entity
     */
    @PostMapping(value = "/api/user", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ResultBean> addUser(@RequestBody String json) throws Exception, ApiValidateException {
        ResultBean resultBean = null;
        resultBean = userService.createUser(json);
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.CREATED);
    }

    /**
     * Gets the user info.
     *
     * @author (TanDX)
     * @param id
     * @return the user info
     */
    @GetMapping(value = "/api/user/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ResultBean> getUserById(@PathVariable Integer id) throws Exception {
        ResultBean resultBean = null;
        resultBean = userService.getUserById(id);
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
    }

    /**
     * Update user info.
     *
     * @author (TanDX)
     * @param json
     * @return the response entity
     */
    @PutMapping(value = "/api/user", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ResultBean> updateUser(@RequestBody String json) throws Exception, ApiValidateException {
        ResultBean resultBean = null;
        resultBean = userService.updateUser(json);
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
    }

    /**
     * Gets the users.
     *
     * @author (TanDX)
     * @param keyWord
     * @param page
     * @param size
     * @return the users
     */
    @SuppressWarnings("unchecked")
    @GetMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Paging<UserLoginEntity>> getUser(@PageableDefault(size = PageableConstrants.DEFAULT_SIZE, page = PageableConstrants.DEFAULT_PAGE) Pageable pageable, String keyWord, Integer page, Integer size) throws Exception {
        Page<UserLoginEntity> pages = userService.getUsers(pageable, keyWord);

        HttpHeaders headers = PaginationUtils
                .generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), pages);
        return new ResponseEntity<>(PaginationUtils.generatePage(pages), headers, HttpStatus.OK);
    }
}

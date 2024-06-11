package org.api.controller;

import org.api.bean.ResultBean;
import org.api.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping(value = "")
    public ResponseEntity<ResultBean> getAll() throws Exception {
        ResultBean resultBean = null;
        resultBean = courseService.getAll();
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
    }
    @GetMapping(value = "/by-route")
    public ResponseEntity<ResultBean> getByIdRoute(@RequestParam(value = "code") String code) throws Exception {
        ResultBean resultBean = null;
        resultBean = courseService.getByRoute(code);
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
    }
}

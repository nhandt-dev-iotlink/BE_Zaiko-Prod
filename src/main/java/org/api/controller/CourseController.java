package org.api.controller;


import org.api.annotation.LogExecutionTime;
import org.api.bean.ResultBean;
import org.api.bean.reponse.dto.CourseDTO;
import org.api.services.CourseService;
import org.api.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@LogExecutionTime
@RestController
public class CourseController {
    @Autowired
    CourseService courseService;

    private static final Logger log = LoggerFactory.getLogger(CourseController.class);


    @GetMapping(value = "/api/course", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultBean> getCourse() {

        try {
            List<CourseDTO> course = courseService.getAll();
            ResultBean successResult = new ResultBean(course, Constants.STATUS_OK, Constants.MESSAGE_OK);
            return new ResponseEntity<ResultBean>(successResult, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

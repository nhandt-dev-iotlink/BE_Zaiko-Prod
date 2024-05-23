package org.api.controller;

import lombok.RequiredArgsConstructor;
import org.api.bean.dto.CourseDto;
import org.api.bean.dto.RouteDto;
import org.api.services.ICourseService;
import org.api.services.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CourseController {
    @Autowired
    private ICourseService courseService;
    @GetMapping("/get-all")
    public ResponseEntity<List<CourseDto>> getSearchList() {
        List<CourseDto> courseList = courseService.getAll();
        if (courseList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(courseList , HttpStatus.OK);
    }
}

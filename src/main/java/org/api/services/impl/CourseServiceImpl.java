package org.api.services.impl;

import org.api.bean.dto.CourseDto;
import org.api.bean.dto.RouteDto;
import org.api.repository.ICourseRepository;
import org.api.repository.IRouteRepository;
import org.api.services.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private ICourseRepository courseRepository;

    @Override
    public List<CourseDto> getAll() {
        return courseRepository.getAll();
    }
}

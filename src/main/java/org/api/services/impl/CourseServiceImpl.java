package org.api.services.impl;



import org.api.bean.jpa.CourseEntity;
import org.api.bean.mapper.CourseMapper;
import org.api.bean.reponse.dto.CourseDTO;
import org.api.repository.course.CourseRepository;
import org.api.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseMapper courseMapper;


    @Override
    public List<CourseDTO> getAll() {
        List<CourseEntity> entities = courseRepository.findAll();
        if (entities.isEmpty()) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(entity -> courseMapper.courseToCourseDto(entity))
                .collect(Collectors.toList());
    }


}

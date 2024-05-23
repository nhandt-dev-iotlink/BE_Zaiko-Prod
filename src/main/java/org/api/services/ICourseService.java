package org.api.services;

import org.api.bean.dto.CourseDto;

import java.util.List;

public interface ICourseService {
    List<CourseDto> getAll();
}

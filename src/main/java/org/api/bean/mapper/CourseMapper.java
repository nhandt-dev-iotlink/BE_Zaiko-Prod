package org.api.bean.mapper;

import org.api.bean.jpa.CourseEntity;
import org.api.bean.reponse.dto.CourseDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDTO courseToCourseDto(CourseEntity course);
    CourseEntity courseDtoToCourse(CourseDTO courseDTO);
}

package org.api.mapper;

import org.api.bean.jpa.CourseEntity;
import org.api.dto.CourseDto;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDto toDto (CourseEntity entity);
    CourseEntity toEntity(CourseDto dto);
    List<CourseDto> map(List<CourseEntity>list);
}

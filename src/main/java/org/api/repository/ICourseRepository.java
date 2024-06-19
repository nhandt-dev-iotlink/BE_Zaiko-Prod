package org.api.repository;

import org.api.bean.dto.CourseDto;
import org.api.bean.jpa.CustomerEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICourseRepository extends BaseRepository<CustomerEntity,Integer>{
    @Query(value = " SELECT DISTINCT " +
            "course_code as courseCode, " +
            "course_name as courseName " +
            "FROM m_course  " +
            "WHERE del_flg = 0 " +
            "order by courseCode ASC  ", nativeQuery = true)
    List<CourseDto> getAll();
}

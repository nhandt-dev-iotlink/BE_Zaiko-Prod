package org.api.repository.course;

import io.lettuce.core.dynamic.annotation.Param;
import org.api.bean.jpa.CourseEntity;
import org.api.bean.jpa.CourseEntityId;
import org.api.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends BaseRepository<CourseEntity, CourseEntityId> {
    @Query(nativeQuery = true, value = "SELECT *  FROM m_course as c WHERE c.del_flg='0'")
    List<CourseEntity> getAll();
    @Query(nativeQuery = true, value = "SELECT *  FROM m_course as c WHERE c.del_flg='0' AND c.route_code = :code")
    List<CourseEntity> getByRoute(@Param(value = "code") String code);
}

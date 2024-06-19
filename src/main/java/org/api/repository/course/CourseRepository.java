package org.api.repository.course;

import org.api.bean.jpa.CourseEntity;
import org.api.utils.CourseEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity , CourseEntityId> {

    @Query(value = "SELECT * FROM m_course WHERE del_flg = '0' ",nativeQuery = true)
    List<CourseEntity> findAllCourse();

}

package org.api.repository.location;

import io.lettuce.core.dynamic.annotation.Param;
import org.api.bean.jpa.LocationEntity;
import org.api.bean.reponse.dto.LocationEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity , LocationEntityId> {
    @Query(value = "SELECT * FROM m_location where del_flg = '0' ",nativeQuery = true)
    List<LocationEntity> getLocationEntityList();

    @Query(value = "SELECT * FROM m_location WHERE del_flg = '0' AND repository_id = :repositoryId", nativeQuery = true)
    List<LocationEntity> getLocationByRepoId(@Param("repositoryId") Integer repositoryId);

}

package org.api.repository;


import org.api.bean.dto.LocationDto;
import org.api.bean.jpa.CustomerEntity;
import org.api.bean.jpa.LocationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ILocationRepository extends BaseRepository<CustomerEntity, Integer> {
    @Query(value = " SELECT " +
            " location_id as locationId, " +
            " location_code as locationCode " +
            " FROM m_location WHERE del_flg = 0 " +
            " order by locationId asc ", nativeQuery = true)
    List<LocationDto> getAll();

    @Query(value = " SELECT " +
            " location_id as locationId, " +
            " location_code as locationCode " +
            " FROM m_location " +
            " WHERE del_flg = 0 " +
            " AND repository_id = :repositoryId " +
            " order by locationId asc ", nativeQuery = true)
    List<LocationDto> getByRepo(@Param("repositoryId") Integer repositoryId);
}

package org.api.repository.route;

import org.api.bean.jpa.RouteEntity;
import org.api.bean.jpa.RouteEntityId;
import org.api.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends BaseRepository<RouteEntity, RouteEntityId> {
    @Query(nativeQuery = true, value = "SELECT * FROM m_route WHERE del_flg = '0' ORDER BY route_code")
    List<RouteEntity> getAll();
}

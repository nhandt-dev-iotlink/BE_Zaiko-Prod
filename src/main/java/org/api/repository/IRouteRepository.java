package org.api.repository;

import org.api.bean.dto.RouteDto;
import org.api.bean.jpa.CustomerEntity;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRouteRepository extends BaseRepository<CustomerEntity,Integer>{
    @Query(value = " SELECT distinct " +
            "cus.route_code as routeCode, " +
            "rou.route_name as routeName " +
            "FROM m_route rou " +
            "JOIN m_customer cus ON rou.route_code = cus.route_code " +
            "order by routeCode ASC  ", nativeQuery = true)
    List<RouteDto> getAll();
}

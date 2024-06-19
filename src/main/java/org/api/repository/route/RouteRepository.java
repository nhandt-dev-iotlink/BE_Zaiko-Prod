package org.api.repository.route;

import org.api.bean.jpa.RouteEntity;
import org.api.utils.RouteEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, RouteEntityId> {

}

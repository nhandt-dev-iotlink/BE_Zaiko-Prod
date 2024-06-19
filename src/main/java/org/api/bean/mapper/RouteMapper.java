package org.api.bean.mapper;

import org.api.bean.jpa.RouteEntity;
import org.api.bean.reponse.dto.RouteDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface RouteMapper {
    RouteDTO routeToRouteDto(RouteEntity entity);
    RouteEntity routeDtoToRoute(RouteDTO dto);
}

package org.api.mapper;

import org.api.bean.jpa.RouteEntity;
import org.api.dto.RouteDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RouteMapper {
    RouteDto toDto (RouteEntity entity);
    RouteEntity toEntity(RouteDto dto);
    List<RouteDto> map(List<RouteEntity> list);
}

package org.api.mapper;

import org.api.bean.jpa.LocationEntity;
import org.api.dto.LocationDto;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationDto toDto(LocationEntity entity);
    LocationEntity toEntity(LocationDto dto);
    List<LocationDto> map(List<LocationEntity> entityList);
}

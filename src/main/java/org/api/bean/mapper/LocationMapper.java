package org.api.bean.mapper;

import org.api.bean.jpa.LocationEntity;
import org.api.bean.jpa.RepositoryEntity;
import org.api.bean.reponse.dto.LocationDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationDTO locationToLocationDto(LocationEntity location);
}

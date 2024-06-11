package org.api.mapper;

import org.api.bean.jpa.RepositoryEntity;
import org.api.dto.RepositoryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RepositoryMapper {
    RepositoryDto toDto(RepositoryEntity entity);
}

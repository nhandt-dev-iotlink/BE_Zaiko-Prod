package org.api.bean.mapper;

import org.api.bean.jpa.RepositoryEntity;
import org.api.bean.reponse.dto.RepositoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RepositoryMapper {
    RepositoryDTO repositoryToRepositoryDto(RepositoryEntity repository);
}

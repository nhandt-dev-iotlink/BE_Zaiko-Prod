package org.api.bean.mapper;

import org.api.bean.jpa.RepositoryEntity;
import org.api.bean.reponse.dto.RepositoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RepositoryMapper {
    @Mapping(source = "repository_id", target = "repository_id")
    @Mapping(source = "company_id", target = "company_id")
    @Mapping(source = "repositoryCode", target = "repositoryCode")
    @Mapping(source = "repositoryName", target = "repositoryName")
    @Mapping(source = "phone_number1", target = "phone_number1")
    @Mapping(source = "fax_number1", target = "fax_number1")
    @Mapping(source = "post_code1", target = "post_code1")
    @Mapping(source = "address1_1", target = "address1_1")
    @Mapping(source = "address1_2", target = "address1_2")
    @Mapping(source = "address1_3", target = "address1_3")
    @Mapping(source = "address1_4", target = "address1_4")
    @Mapping(source = "phone_number2", target = "phone_number2")
    RepositoryDTO repositoryToRepositoryDto(RepositoryEntity repository);
}

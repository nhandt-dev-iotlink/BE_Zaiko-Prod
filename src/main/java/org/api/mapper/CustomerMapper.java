package org.api.mapper;

import org.api.bean.jpa.CustomerEntity;
import org.api.dto.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto toDto(CustomerEntity entity);
    CustomerEntity toEntity(CustomerDto dto);
}

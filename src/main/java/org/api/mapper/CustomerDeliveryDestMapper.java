package org.api.mapper;

import org.api.bean.jpa.CustomerDeliveryDestEntity;
import org.api.dto.CustomerDeliveryDestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerDeliveryDestMapper {
    CustomerDeliveryDestDto toDto(CustomerDeliveryDestEntity entity);
    CustomerDeliveryDestEntity toEntity(CustomerDeliveryDestDto dto);
}

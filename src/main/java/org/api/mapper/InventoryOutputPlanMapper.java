package org.api.mapper;

import org.api.bean.jpa.InventoryOutputEntity;
import org.api.dto.InventoryOutputPlanDto;
import org.mapstruct.Mapper;
//import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InventoryOutputPlanMapper {
    InventoryOutputEntity toEntity(InventoryOutputPlanDto dto);
    InventoryOutputPlanDto toDto(InventoryOutputEntity entity);
    void update(@MappingTarget InventoryOutputEntity entity, InventoryOutputPlanDto dto);
}

package org.api.mapper;

import org.api.bean.jpa.InventoryPlanOutputDetailEntity;
import org.api.dto.InventoryPlanOutputDetailDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface InventoryPlanOutputDetailMapper {
    InventoryPlanOutputDetailEntity toEntity(InventoryPlanOutputDetailDto dto);
    InventoryPlanOutputDetailDto toDto(InventoryPlanOutputDetailEntity entity);
    void update(@MappingTarget InventoryPlanOutputDetailEntity entity, InventoryPlanOutputDetailDto dto);
}

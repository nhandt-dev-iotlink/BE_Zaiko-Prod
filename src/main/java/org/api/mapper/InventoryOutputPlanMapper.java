package org.api.mapper;

import org.api.bean.jpa.InventoryOutputEntity;
import org.api.dto.InventoryOutputPlanDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryOutputPlanMapper {
    InventoryOutputEntity toEntity(InventoryOutputPlanDto dto);
    InventoryOutputPlanDto toDto(InventoryOutputEntity entity);
}

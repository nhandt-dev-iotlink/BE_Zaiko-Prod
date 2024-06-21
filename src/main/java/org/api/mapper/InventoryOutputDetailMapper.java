package org.api.mapper;

import org.api.bean.jpa.InventoryOutputEntity;
import org.api.dto.InventoryOutputDetailDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface InventoryOutputDetailMapper {
    InventoryOutputEntity toEntity(InventoryOutputDetailDto dto);
    InventoryOutputDetailDto toDto(InventoryOutputEntity entity);
    void update(@MappingTarget InventoryOutputEntity entity, InventoryOutputDetailDto dto);
}

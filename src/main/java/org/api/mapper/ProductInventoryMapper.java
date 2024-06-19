package org.api.mapper;

import org.api.bean.jpa.ProductInventoryEntity;
import org.api.dto.ProductInventoryDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductInventoryMapper {
    ProductInventoryEntity toEntity (ProductInventoryDto dto);
    ProductInventoryDto toDto (ProductInventoryEntity entity);
    List<ProductInventoryDto> map(List<ProductInventoryEntity> listEntity);
}

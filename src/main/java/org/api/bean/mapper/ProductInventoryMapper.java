package org.api.bean.mapper;

import org.api.bean.jpa.ProductInventoryEntity;
import org.api.bean.reponse.dto.ProductInventoryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductInventoryMapper {
    ProductInventoryDTO poductInventoryToProductInventoryDto(ProductInventoryEntity productInventory);
    ProductInventoryEntity productInventoryDtoToProductInventory(ProductInventoryDTO dto);
}
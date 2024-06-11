package org.api.mapper;



import org.api.bean.jpa.ProductEntity;
import org.api.dto.ProductDto;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(ProductEntity entity);
    ProductEntity toEntity(ProductDto dto);
    List<ProductDto> map(List<ProductEntity> entity);
}

package org.api.bean.mapper;

import org.api.bean.jpa.LocationEntity;
import org.api.bean.jpa.ProductEntity;
import org.api.bean.reponse.dto.LocationDTO;
import org.api.bean.reponse.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO productToProductDto(ProductEntity product);
}

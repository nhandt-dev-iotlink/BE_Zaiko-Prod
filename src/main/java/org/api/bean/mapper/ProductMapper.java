package org.api.bean.mapper;

import org.api.bean.jpa.ProductEntity;
import org.api.bean.reponse.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ProductMapper implements Function<ProductEntity, ProductDTO> {

    @Override
    public ProductDTO apply(ProductEntity product) {
        return ProductDTO.builder()
                .productId(product.getProductId())
                .productCode(product.getProductCode())
                .upcCd1(product.getUpcCd1())
                .upcCd2(product.getUpcCd2())
                .name1(product.getName1())
                .standardInfo(product.getStandardInfo())
                .categoryCode1(product.getCategoryCode1())
                .categoryCode2(product.getCategoryCode2())
                .categoryCode3(product.getCategoryCode3())
                .notes(product.getNotes())
                .pieceUnitCode(product.getPieceUnitCode())
                .pieceUnitName(product.getPieceUnitName())
                .leadTime(product.getLeadTime())
                .build();
    }



}

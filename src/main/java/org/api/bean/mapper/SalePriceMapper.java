package org.api.bean.mapper;

import org.api.bean.jpa.SalePriceEntity;
import org.api.bean.reponse.dto.SalePriceDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SalePriceMapper {
    SalePriceDTO SalePriceToSalePriceDto(SalePriceEntity salePrice);
    SalePriceEntity SalePriceDtoToSalePrice(SalePriceDTO salePriceDto);
}

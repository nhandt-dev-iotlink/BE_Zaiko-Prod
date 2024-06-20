package org.api.services.impl;

import org.api.bean.jpa.SalePriceEntity;
import org.api.bean.jpa.SupplierEntity;
import org.api.bean.mapper.SalePriceMapper;
import org.api.bean.reponse.dto.SalePriceDTO;
import org.api.repository.salePrice.SalePriceRepository;
import org.api.services.SalePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalePriceServiceImpl implements SalePriceService {

    @Autowired
    SalePriceRepository salePriceRepository;

    @Autowired
    SalePriceMapper salePriceMapper;

    @Override
    public SalePriceDTO getLatestSalePriceByProductId(Integer productId) {
    SalePriceEntity entities = salePriceRepository.findLatestSalePriceByProductId(productId);
        if (entities == null) {
            return null;
        }
        return  salePriceMapper.SalePriceToSalePriceDto(entities);

    }
}

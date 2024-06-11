package org.api.services.impl;

import org.api.bean.jpa.SalePriceEntity;
import org.api.repository.salePrice.SalePriceRepository;
import org.api.services.SalePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalePriceServiceImpl implements SalePriceService {
    @Autowired
    private SalePriceRepository salePriceRepository;

    @Override
    public SalePriceEntity findOneByProductId(Integer id) throws Exception {
        return salePriceRepository.findOneByProductId(id);
    }
}

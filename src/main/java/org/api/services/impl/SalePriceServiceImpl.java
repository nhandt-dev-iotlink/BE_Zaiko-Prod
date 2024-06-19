package org.api.services.impl;

import org.api.bean.dto.SalePriceDto;
import org.api.repository.ISalePriceRepository;
import org.api.services.ISalePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalePriceServiceImpl implements ISalePriceService {
    @Autowired
    private ISalePriceRepository salePriceRepository;
    @Override
    public SalePriceDto getSalePriceInfo(Integer productId, Integer customerId) {
        return salePriceRepository.getSalePriceInfo(productId,customerId);
    }
}

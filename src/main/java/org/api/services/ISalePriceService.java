package org.api.services;

import org.api.bean.dto.SalePriceDto;

public interface ISalePriceService {

    SalePriceDto getSalePriceInfo(Integer productId, Integer customerId);
}

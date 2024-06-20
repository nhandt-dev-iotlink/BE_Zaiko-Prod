package org.api.services;

import org.api.bean.jpa.SalePriceEntity;
import org.api.bean.reponse.dto.SalePriceDTO;

public interface SalePriceService {
    public  SalePriceDTO getLatestSalePriceByProductId(Integer productId);
}

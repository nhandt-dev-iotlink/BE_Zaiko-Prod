package org.api.services;

import org.api.bean.jpa.SalePriceEntity;

public interface SalePriceService {
    SalePriceEntity findOneByProductId(Integer id) throws Exception;
}

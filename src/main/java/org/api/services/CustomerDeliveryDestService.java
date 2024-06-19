package org.api.services;

import org.api.bean.ResultBean;
import org.api.bean.jpa.CustomerDeliveryDestEntity;
import org.api.dto.CustomerDeliveryDestDto;
import org.api.utils.ApiValidateException;

public interface CustomerDeliveryDestService {
    ResultBean getAll(String deliveryName) throws ApiValidateException;

    ResultBean findDtoByCode(String code) throws Exception;

    CustomerDeliveryDestEntity findOneByCode(String code) throws Exception;
    ResultBean saveEntity(CustomerDeliveryDestDto dto) throws Exception;
}

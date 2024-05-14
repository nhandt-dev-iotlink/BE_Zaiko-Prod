package org.api.services;

import org.api.bean.ResultBean;
import org.api.utils.ApiValidateException;

public interface CustomerDeliveryDestService {
    ResultBean getAll(String deliveryName) throws ApiValidateException;

}

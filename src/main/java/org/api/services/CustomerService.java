package org.api.services;

import org.api.bean.ResultBean;
import org.api.utils.ApiValidateException;

public interface CustomerService {
    ResultBean getAll(String customerName) throws ApiValidateException;
}

package org.api.services;

import org.api.bean.ResultBean;
import org.api.bean.jpa.CustomerEntity;
import org.api.dto.CustomerDto;
import org.api.utils.ApiValidateException;

public interface CustomerService {
    ResultBean getAll(String customerName) throws ApiValidateException;

    ResultBean getAllByCode(String code) throws Exception;

    CustomerEntity findOneCustomerByCode(String code) throws Exception;

    ResultBean saveCustomer(CustomerDto dto) throws Exception;
}

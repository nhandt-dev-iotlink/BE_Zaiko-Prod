package org.api.services;

import org.api.bean.ResultBean;
import org.api.bean.jpa.SupplierEntity;
import org.api.dto.SupplierDto;
import org.api.utils.ApiValidateException;

public interface SupplierService {
    ResultBean getAll(String param) throws ApiValidateException;

    SupplierEntity findByCode(String supplierCode);
}

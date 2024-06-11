package org.api.services;

import org.api.bean.ResultBean;
import org.api.bean.jpa.ProductEntity;
import org.api.utils.ApiValidateException;

public interface ProductService {
    ResultBean getAll(String param) throws ApiValidateException;

    ResultBean findOneById(Integer id) throws Exception;

    ResultBean findOneByCode(String code) throws Exception;

    ProductEntity findOneByCodeReturnEntity(String code) throws Exception;
}

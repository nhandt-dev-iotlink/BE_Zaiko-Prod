package org.api.services;

import org.api.bean.ResultBean;
import org.api.utils.ApiValidateException;

public interface ProductService {
    ResultBean getAll(String param) throws ApiValidateException;
}

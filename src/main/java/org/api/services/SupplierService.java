package org.api.services;

import org.api.bean.ResultBean;

public interface SupplierService {

    ResultBean getAllSupplierForDialog();
    ResultBean searchSupplier(String keyWord);
}

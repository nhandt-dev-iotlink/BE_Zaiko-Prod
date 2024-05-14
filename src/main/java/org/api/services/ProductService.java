package org.api.services;

import org.api.bean.ResultBean;

public interface ProductService {

    ResultBean getProductsDialog();
    ResultBean searchProductsByCodeOrName(String keyWord);
}

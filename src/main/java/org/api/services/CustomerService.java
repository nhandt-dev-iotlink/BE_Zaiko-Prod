package org.api.services;

import org.api.bean.ResultBean;

public interface CustomerService {
    ResultBean getCustomersForDialog();
    ResultBean getSearchCustomersForDialog(String keyWord);
}

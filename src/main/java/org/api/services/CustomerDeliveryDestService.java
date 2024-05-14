package org.api.services;

import org.api.bean.ResultBean;

public interface CustomerDeliveryDestService {
    ResultBean getAllCustomerDeliveryDestDialog();
    ResultBean searchCustomerDeliveryDestDialogByCodeOrName(String keyWord);
}

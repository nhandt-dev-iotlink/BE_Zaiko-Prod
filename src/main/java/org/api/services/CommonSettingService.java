package org.api.services;

import org.api.bean.ResultBean;
import org.api.utils.ApiValidateException;

public interface CommonSettingService {
    ResultBean getAllInventoryProductType()throws ApiValidateException;
}

package org.api.services;

import org.api.bean.ResultBean;

public interface ProductInventoryService {
    ResultBean getAllByProductAndRepository(String keyWord, String productCode, Integer repositoryId) throws Exception;
}

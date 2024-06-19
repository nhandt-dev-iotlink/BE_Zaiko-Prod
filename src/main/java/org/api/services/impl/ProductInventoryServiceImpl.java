package org.api.services.impl;

import org.api.bean.ResultBean;
import org.api.bean.jpa.ProductInventoryEntity;
import org.api.dto.ProductInventoryDto;
import org.api.mapper.ProductInventoryMapper;
import org.api.repository.productInventory.ProductInventoryRepository;
import org.api.services.ProductInventoryService;
import org.api.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductInventoryServiceImpl implements ProductInventoryService {
    @Autowired
    private ProductInventoryRepository productInventoryRepository;
    @Autowired
    private ProductInventoryMapper mapper;

    @Override
    public ResultBean getAllByProductAndRepository(String keyWord, String productCode, Integer repositoryId) throws Exception {
        List<ProductInventoryEntity> productInventoryEntityList = productInventoryRepository.getAllByProductAndRepository(keyWord, productCode, repositoryId);
        List<ProductInventoryDto> productInventoryDtoList = new ArrayList<>();
        if (!productInventoryEntityList.isEmpty()) {
            productInventoryDtoList = mapper.map(productInventoryEntityList);
        }
        return new ResultBean(productInventoryDtoList, Constants.STATUS_OK, Constants.MESSAGE_OK);
    }
}

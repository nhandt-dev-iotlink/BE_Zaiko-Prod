package org.api.services.impl;

import org.api.bean.dto.InventoryProductDto;
import org.api.repository.IInventoryProductRepository;
import org.api.services.IInventoryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryProductServiceImpl implements IInventoryProductService {
    @Autowired
    private IInventoryProductRepository inventoryProductRepository;


    @Override
    public List<InventoryProductDto> getInventoryProduct(Integer repositoryId, String productCode) {
        return inventoryProductRepository.getInventoryProduct(repositoryId,productCode);
    }
}

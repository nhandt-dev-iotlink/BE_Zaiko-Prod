package org.api.services;

import org.api.bean.dto.InventoryProductDto;

import java.util.List;

public interface IInventoryProductService {
    List<InventoryProductDto> getInventoryProduct(Integer repositoryId, String productCode);
}

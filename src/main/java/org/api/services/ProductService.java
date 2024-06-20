package org.api.services;

import org.api.bean.jpa.ProductEntity;
import org.api.bean.reponse.dto.ProductDTO;
import org.api.bean.reponse.dto.ProductInventoryDTO;

import java.util.List;

public interface ProductService {

    public List<ProductDTO> getAllProduct();

    public List<ProductDTO> findProductByKeyword(String param);

    public ProductDTO getProductByCode(String productCode);
    public ProductDTO getProductById(Integer productId);

    public ProductInventoryDTO findProductInventory(Integer productInventoryId);

    public List<ProductInventoryDTO> findProductInventoryKeyword(String param);
}

package org.api.services;

import org.api.bean.reponse.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    public List<ProductDTO> getAllProduct();

    public List<ProductDTO> findProductByKeyword(String param);
}

package org.api.services.impl;


import org.api.bean.dto.ProductDto;

import org.api.repository.IProductRepository;
import org.api.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<ProductDto> getAll(String keyword) {
        return productRepository.getAll(keyword);
    }

    @Override
    public ProductDto getByCode(String productCode) {
        return productRepository.findByCode(productCode);
    }
}

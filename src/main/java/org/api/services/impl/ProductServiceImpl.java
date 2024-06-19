package org.api.services.impl;


import org.api.annotation.LogExecutionTime;
import org.api.bean.jpa.CustomerEntity;
import org.api.bean.jpa.ProductEntity;
import org.api.bean.mapper.ProductMapper;
import org.api.bean.reponse.dto.ProductDTO;
import org.api.repository.product.ProductRepository;
import org.api.services.ProductService;
import org.api.utils.ApiValidateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@LogExecutionTime
@Service
@Transactional(rollbackFor = { ApiValidateException.class, Exception.class })
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;
    @Override
    public List<ProductDTO> getAllProduct() {
        List<ProductEntity> entities = productRepository.findAll();
        if (entities.isEmpty()) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(productMapper)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findProductByKeyword(String param) {
        String keyWord = param.trim();
        List<ProductEntity> entities = productRepository.findProductByKeyword(keyWord);

        if (entities.isEmpty()) {
            return Collections.emptyList();
        }

        return entities.stream().map(productMapper).collect(Collectors.toList());
    }
}

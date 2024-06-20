package org.api.services.impl;


import org.api.annotation.LogExecutionTime;
import org.api.bean.jpa.CustomerEntity;
import org.api.bean.jpa.ProductEntity;
import org.api.bean.jpa.ProductInventoryEntity;
import org.api.bean.mapper.ProductInventoryMapper;
import org.api.bean.mapper.ProductMapper;
import org.api.bean.reponse.dto.ProductDTO;
import org.api.bean.reponse.dto.ProductInventoryDTO;
import org.api.repository.product.ProductInventoryRepository;
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
    ProductInventoryRepository productInventoryRepository;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductInventoryMapper productInventoryMapper;
    @Override
    public List<ProductDTO> getAllProduct() {
        List<ProductEntity> entities = productRepository.findAll();
        if (entities.isEmpty()) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(entity ->productMapper.productToProductDto(entity))
                .collect(Collectors.toList());
    }
    @Override
    public List<ProductDTO> findProductByKeyword(String param) {
        String keyWord = param.trim();
        List<ProductEntity> entities = productRepository.findProductByKeyword(keyWord);
        if (entities.isEmpty()) {
            return Collections.emptyList();
        }
        return entities.stream().map(entity -> productMapper.productToProductDto(entity)).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductByCode(String productCode) {
        ProductEntity product =productRepository.getProductByCode(productCode);
        return productMapper.productToProductDto(product);
    }
    @Override
    public ProductDTO getProductById(Integer productId) {
        ProductEntity product =productRepository.getProductById(productId);
        return productMapper.productToProductDto(product);
    }

    @Override
    public ProductInventoryDTO findProductInventory(Integer productInventoryId) {
        ProductInventoryEntity entity = productInventoryRepository.getProductInventoryById(productInventoryId);
        return productInventoryMapper.poductInventoryToProductInventoryDto(entity);
    }

    @Override
    public List<ProductInventoryDTO> findProductInventoryKeyword(String param) {
        String keyWord = (param == null || param.trim().isEmpty()) ? "" : param.trim();
        List<ProductInventoryEntity> entities = productInventoryRepository.findProductInventoryKeyword(keyWord);

        if (entities.isEmpty()) {
            return Collections.emptyList();
        }

        if (keyWord == null) {
            entities = entities.stream()
                    .filter(entity -> entity.getInventory_id() >= 30 && entity.getInventory_id() <= 42)
                    .collect(Collectors.toList());
        }

        return entities.stream()
                .map(entity -> productInventoryMapper.poductInventoryToProductInventoryDto(entity))
                .collect(Collectors.toList());
    }

}

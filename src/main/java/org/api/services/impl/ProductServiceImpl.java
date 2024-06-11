package org.api.services.impl;

import org.api.bean.ResultBean;
import org.api.bean.jpa.ProductEntity;
import org.api.dto.ProductDto;
import org.api.mapper.ProductMapper;
import org.api.repository.product.ProductRepository;
import org.api.services.ProductService;
import org.api.utils.ApiValidateException;
import org.api.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

//    @Override
//    public ResultBean getAll(String param) throws ApiValidateException {
//        List<ProductDto> productDtoList = productRepository.getAll(param);
//
//        if (!productDtoList.isEmpty()) {
//            return new ResultBean(productDtoList, Constants.STATUS_OK, Constants.MESSAGE_OK);
//        } else {
//            return new ResultBean(new ArrayList<>(), Constants.STATUS_OK, Constants.MESSAGE_OK);
//        }
//    }


    @Override
    public ResultBean getAll(String param) throws ApiValidateException {
        List<ProductEntity> productEntityList = productRepository.getAll(param);
        if (!productEntityList.isEmpty()) {
            List<ProductDto> productDtoList = productMapper.map(productEntityList);
            return new ResultBean(productDtoList, Constants.STATUS_OK, Constants.MESSAGE_OK);
        } else {
            return new ResultBean(new ArrayList<>(), Constants.STATUS_OK, Constants.MESSAGE_OK);
        }
    }

    @Override
    public ResultBean findOneById(Integer id) throws Exception {
        ProductEntity entity = productRepository.findOneById(id);
        if (Objects.nonNull(entity)) {
            ProductDto dto = productMapper.toDto(entity);
            return new ResultBean(dto, Constants.STATUS_OK, Constants.MESSAGE_OK);
        }
        return new ResultBean(new ProductDto(), Constants.STATUS_OK, Constants.MESSAGE_OK);
    }

    @Override
    public ResultBean findOneByCode(String id) throws Exception {
        ProductEntity entity = productRepository.findOneByCode(id);
        if (Objects.nonNull(entity)) {
            ProductDto dto = productMapper.toDto(entity);
            return new ResultBean(dto, Constants.STATUS_OK, Constants.MESSAGE_OK);
        }
        return new ResultBean(Constants.STATUS_NOT_FOUND, Constants.MESSAGE_OK);
    }
    @Override
    public ProductEntity findOneByCodeReturnEntity(String code) throws Exception {
        return productRepository.findOneByCode(code);
    }


//            List<ProductDto> productDtoList = productEntityList.stream().map(
//                    this::mapToDto
//        ).collect(Collectors.toList());
//    private ProductDto mapToDto(ProductEntity product){
//        ProductDto productDto = new ProductDto();
//        productDto.setProductId(product.getProductId());
//        productDto.setProductCode(product.getProductCode());
//        productDto.setName1(product.getName1());
//        return productDto;
//    }
}

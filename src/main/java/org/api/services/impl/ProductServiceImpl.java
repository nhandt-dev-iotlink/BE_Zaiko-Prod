package org.api.services.impl;

import org.api.bean.ResultBean;
import org.api.bean.jpa.ProductEntity;
import org.api.dto.CustomerDto;
import org.api.dto.ProductDto;
import org.api.repository.product.ProductRepository;
import org.api.services.ProductService;
import org.api.utils.ApiValidateException;
import org.api.utils.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;
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
            List<ProductDto> productDtoList = productEntityList.stream().map(
                    this::mapToDto
        ).collect(Collectors.toList());
            return new ResultBean(productDtoList, Constants.STATUS_OK, Constants.MESSAGE_OK);
        } else {
            return new ResultBean(new ArrayList<>(), Constants.STATUS_OK, Constants.MESSAGE_OK);
        }
    }
    private ProductDto mapToDto(ProductEntity product){
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setProductCode(product.getProductCode());
        productDto.setProductName(product.getName1());
        return productDto;
    }
}

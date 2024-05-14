package org.api.services.impl;

import org.api.bean.ResultBean;
import org.api.bean.jpa.ProductEntity;
import org.api.dto.product.response.ProductDialogDTO;
import org.api.repository.product.ProductRepository;
import org.api.services.ProductService;
import org.api.utils.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResultBean getProductsDialog() {
        List<ProductEntity> productEntities = productRepository.findAllProductForDialog();
        return getResultBean(productEntities);
    }

    @Override
    public ResultBean searchProductsByCodeOrName(String keyWord) {
        List<ProductEntity> productEntities = productRepository.findProductForDialogByCodeOrName(keyWord, keyWord);
        return getResultBean(productEntities);
    }

    private ResultBean getResultBean(List<ProductEntity> productEntities) {
        if(!productEntities.isEmpty()){
            List<ProductDialogDTO> productDialogDTOS = productEntities.stream()
                    .map(productEntity -> modelMapper.map(productEntity, ProductDialogDTO.class))
                    .collect(Collectors.toList());
            return new ResultBean(productDialogDTOS, Constants.STATUS_OK, Constants.MESSAGE_OK);
        }
        return new ResultBean(null, Constants.STATUS_NOT_FOUND, "Empty Result");
    }
}

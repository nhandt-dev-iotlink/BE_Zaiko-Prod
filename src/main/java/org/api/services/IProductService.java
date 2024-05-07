package org.api.services;

import org.api.bean.dto.CustomerDto;
import org.api.bean.dto.ProductDto;

import java.util.List;

public interface IProductService {
    List<ProductDto> getAll(String keyword);
}

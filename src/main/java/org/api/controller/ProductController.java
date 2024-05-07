package org.api.controller;

import lombok.RequiredArgsConstructor;

import org.api.bean.dto.ProductDto;
import org.api.services.ICustomerService;
import org.api.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("/get-all")
    public ResponseEntity<List<ProductDto>> getSearchList(@RequestParam(defaultValue = "") String keyWord) {
        List<ProductDto> productList = productService.getAll(keyWord);
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList , HttpStatus.OK);
    }
}

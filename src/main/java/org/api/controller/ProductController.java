package org.api.controller;

import org.api.bean.ResultBean;
import org.api.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ResultBean> getCustomerDialog(@RequestParam(name = "keyWord", required = false) String keyWord
    ) throws Exception {
        ResultBean resultBean = (keyWord.isEmpty()) ?  productService.getProductsDialog() :
                productService.searchProductsByCodeOrName(keyWord);
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
    }
}

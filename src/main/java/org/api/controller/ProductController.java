package org.api.controller;

import org.api.annotation.LogExecutionTime;
import org.api.bean.ResultBean;
import org.api.bean.reponse.dto.CustomerDeliveryDestDTO;
import org.api.bean.reponse.dto.ProductDTO;
import org.api.services.ProductService;
import org.api.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@LogExecutionTime
@RestController
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping(value = "/api/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultBean> getProduct(@RequestParam Map<String,String> params) throws Exception{

        try {
            List<ProductDTO> productDTOS ;
            if (params.get("keyWord") != null && !params.get("keyWord").isEmpty()) {
                productDTOS=productService.findProductByKeyword(params.get("keyWord"));

            }else {
                productDTOS=productService.getAllProduct();
            }

            if (productDTOS==null || productDTOS.isEmpty()){
                List<CustomerDeliveryDestDTO> emptyList= new ArrayList<>();
                ResultBean emptyResult =new ResultBean(emptyList , Constants.STATUS_OK,"No Content");
                return new ResponseEntity<>(emptyResult, HttpStatus.OK);
            }
            ResultBean resultBean = new ResultBean(productDTOS,Constants.STATUS_OK,Constants.STATUS_OK);
            return new ResponseEntity<>(resultBean,HttpStatus.OK);
        }catch (Exception e){
            ResultBean errorResult = new ResultBean(Constants.STATUS_SYSTEM_ERROR, "Error", "An error occurred: " + e.getMessage());
            return new ResponseEntity<>(errorResult, HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }
}

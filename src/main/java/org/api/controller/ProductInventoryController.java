package org.api.controller;


import org.api.annotation.LogExecutionTime;
import org.api.bean.ResultBean;
import org.api.bean.jpa.ProductInventoryEntity;
import org.api.bean.reponse.dto.CustomerDeliveryDestDTO;
import org.api.bean.reponse.dto.LocationDTO;
import org.api.bean.reponse.dto.ProductInventoryDTO;
import org.api.services.ProductService;
import org.api.services.RepositoryService;
import org.api.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@LogExecutionTime
@RestController
public class ProductInventoryController {
    private static final Logger log = LoggerFactory.getLogger(ProductInventoryController.class);

    @Autowired
    private ProductService productService;


    @GetMapping(value = "/api/product-inventory", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultBean> getListProductInventory(@RequestParam Map<String,String> params) {
        try {
            List<ProductInventoryDTO> productInventory = productService.findProductInventoryKeyword(params.get("keyWord"));
            ResultBean successResult = new ResultBean(productInventory, Constants.STATUS_OK, Constants.MESSAGE_OK);
            return new ResponseEntity<ResultBean>(successResult, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/api/product-inventory/{productInventoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultBean> getProductInventory(@PathVariable Integer productInventoryId) {
        try {
            ProductInventoryDTO productInventory = productService.findProductInventory(productInventoryId);

            ResultBean successResult = new ResultBean(productInventory, Constants.STATUS_OK, Constants.MESSAGE_OK);
            return new ResponseEntity<ResultBean>(successResult, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


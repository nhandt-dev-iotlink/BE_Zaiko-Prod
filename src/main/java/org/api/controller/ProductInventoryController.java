package org.api.controller;

import org.api.bean.ResultBean;
import org.api.services.ProductInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ProductInventoryController {
@Autowired
private ProductInventoryService productInventoryService;
    @GetMapping("/product-inventory")
    public ResponseEntity<ResultBean> getAllByProductAndRepository(@RequestParam Map<String, String> param) throws Exception{
        ResultBean resultBean = null;
        resultBean = productInventoryService.getAllByProductAndRepository(param.get("keyWord"), param.get("productCode"), Integer.valueOf(param.get("repositoryId")));
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
    }
}

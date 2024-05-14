package org.api.controller;

import org.api.bean.ResultBean;
import org.api.services.ProductService;
import org.api.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.scanner.Constant;

import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/productCode")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("")
    public ResponseEntity<ResultBean> getAll(@RequestParam Map<String, String> param) throws Exception {
        ResultBean resultBean = null;
        if(param.isEmpty()){
            resultBean = productService.getAll("");
            return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
        }else {
            resultBean = productService.getAll(param.get("keyWord"));
            return new ResponseEntity<ResultBean>(resultBean,HttpStatus.OK);
        }
    }
}

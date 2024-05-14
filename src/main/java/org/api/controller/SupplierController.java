package org.api.controller;

import org.api.bean.ResultBean;
import org.api.services.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ResultBean> getSupplierDialog(@RequestParam(name = "keyWord", required = false) String keyWord
    ) throws Exception {
        ResultBean resultBean = (keyWord.isEmpty()) ?  supplierService.getAllSupplierForDialog() :
                supplierService.searchSupplier(keyWord);
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
    }
}

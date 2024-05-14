package org.api.controller;

import org.api.bean.ResultBean;
import org.api.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping("")
    public ResponseEntity<ResultBean> getAll(@RequestParam Map<String, String> param) throws Exception {
        ResultBean resultBean = null;
        if (param.isEmpty()) {
            resultBean = supplierService.getAll("");
            return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
        } else {
            resultBean = supplierService.getAll(param.get("keyWord"));
            return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
        }
    }
}

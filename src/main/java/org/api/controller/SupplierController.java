package org.api.controller;


import org.api.annotation.LogExecutionTime;
import org.api.bean.ResultBean;
import org.api.bean.jpa.SupplierEntity;
import org.api.bean.reponse.dto.CustomerDTO;
import org.api.bean.reponse.dto.SupplierDTO;
import org.api.services.CustomerService;
import org.api.services.SupplierService;
import org.api.utils.Constants;
import org.api.utils.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@LogExecutionTime
@RestController
public class SupplierController {

    private static final Logger log = LoggerFactory.getLogger(SupplierEntity.class);

    @Autowired
    private SupplierService supplierService;

    @GetMapping(value = "/api/supplier", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultBean> getSuppliers(@RequestParam Map<String, String> params) {
        try {
            List<SupplierDTO> suppliers;

            if (params.get("keyWord") != null && !params.get("keyWord").isEmpty()) {
                suppliers = supplierService.findSuppliersByKeyword(params.get("keyWord"));

            } else {
                suppliers = supplierService.getAllSupplier();
            }
            if (suppliers == null || suppliers.isEmpty()) {
                List<SupplierDTO> emptyList = new ArrayList<>();
                ResultBean emptyResult = new ResultBean(emptyList, Constants.STATUS_NO_CONTENT, Constants.MESSAGE_NO_CONTENT);
                return new ResponseEntity<>(emptyResult, HttpStatus.OK);
            }
            ResultBean successResult = new ResultBean(suppliers,Constants.STATUS_OK, Constants.MESSAGE_OK);
            return new ResponseEntity<>(successResult, HttpStatus.OK);
        } catch (Exception e) {
            ResultBean errorResult = new ResultBean(Constants.STATUS_SYSTEM_ERROR, Constants.MESSAGE_SYSTEM_ERROR);
            return new ResponseEntity<>(errorResult, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}

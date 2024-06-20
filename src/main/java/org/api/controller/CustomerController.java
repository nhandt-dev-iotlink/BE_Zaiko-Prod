package org.api.controller;


import org.api.annotation.LogExecutionTime;
import org.api.bean.ResultBean;

import org.api.bean.jpa.CustomerEntity;
import org.api.bean.reponse.dto.CustomerDTO;

import org.api.services.CustomerService;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@LogExecutionTime
@RestController
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/api/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultBean> getCustomers(@RequestParam Map<String, String> params) {
        try {
            List<CustomerDTO> customerDTOS;

            if (params.get("keyWord") != null && !params.get("keyWord").isEmpty()) {
                customerDTOS = customerService.findCustomerByKeyword(params.get("keyWord"));
            } else {
                customerDTOS = customerService.getAllActiveCustomers();
            }
            if (customerDTOS == null || customerDTOS.isEmpty()) {
                List<CustomerDTO> emptyList = new ArrayList<>();
                ResultBean emptyResult = new ResultBean(emptyList, Constants.STATUS_OK, "No Content");
                return new ResponseEntity<>(emptyResult, HttpStatus.OK);
            }
            ResultBean successResult = new ResultBean(customerDTOS, Constants.STATUS_OK, Constants.MESSAGE_OK);
            return new ResponseEntity<>(successResult, HttpStatus.OK);
        } catch (Exception e) {
            ResultBean errorResult = new ResultBean("500", "Error", "An error occurred: " + e.getMessage());
            return new ResponseEntity<>(errorResult, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/api/customer-by-code/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultBean> getCustomerByCode(@PathVariable String code){
        try {
            CustomerDTO entity =customerService.getCustomerByCode(code);
            if(entity==null){
                ResultBean eResultBean = new ResultBean(entity , Constants.RESULTS,"No Content");
                return new ResponseEntity<>(eResultBean,HttpStatus.OK);
            }
            ResultBean eResultBean = new ResultBean(entity,Constants.STATUS_OK,Constants.MESSAGE_OK);
            return new ResponseEntity<>(eResultBean,HttpStatus.OK);

        } catch(Exception e) {
            ResultBean errorResult = new ResultBean("500", "Error", "An error occurred: " + e.getMessage());
            return new ResponseEntity<>(errorResult, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/api/customer-by-id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultBean> getCustomerById(@PathVariable Integer id){
        try {
            CustomerDTO entity =customerService.getCustomerById(id);
            if(entity==null){
                ResultBean eResultBean = new ResultBean(entity , Constants.RESULTS,"No Content");
                return new ResponseEntity<>(eResultBean,HttpStatus.OK);
            }
            ResultBean eResultBean = new ResultBean(entity,Constants.STATUS_OK,Constants.MESSAGE_OK);
            return new ResponseEntity<>(eResultBean,HttpStatus.OK);

        } catch(Exception e) {
            ResultBean errorResult = new ResultBean("500", "Error", "An error occurred: " + e.getMessage());
            return new ResponseEntity<>(errorResult, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

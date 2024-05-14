package org.api.controller;


import org.api.annotation.LogExecutionTime;
import org.api.bean.ResultBean;
import org.api.bean.reponse.dto.CustomerDeliveryDestDTO;
import org.api.services.CustomerDeliveryDestService;
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
public class CustomerDeliveryDestController {

    @Autowired
    CustomerDeliveryDestService customerDeliveryDestService;


    @GetMapping(value = "/api/customer-dest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultBean> getCustomerDeliveryDest(@RequestParam Map<String,String> params) throws Exception{

        try {
            List<CustomerDeliveryDestDTO> customerDeliveryDestDTOS ;
            if (params.get("keyWord") != null && !params.get("keyWord").isEmpty()) {
                customerDeliveryDestDTOS=customerDeliveryDestService.findCustomerDeliveryByKeyword(params.get("keyWord"));
            }else {
                customerDeliveryDestDTOS=customerDeliveryDestService.getAllCustomerDelivery();
            }

            if (customerDeliveryDestDTOS==null || customerDeliveryDestDTOS.isEmpty()){
                List<CustomerDeliveryDestDTO> emptyList= new ArrayList<>();
                ResultBean emptyResult =new ResultBean(emptyList , Constants.STATUS_OK,"No Content");
                return new ResponseEntity<>(emptyResult, HttpStatus.OK);
            }
            ResultBean resultBean = new ResultBean(customerDeliveryDestDTOS,Constants.STATUS_OK,Constants.MESSAGE_OK);
            return new ResponseEntity<>(resultBean,HttpStatus.OK);
     }catch (Exception e){
            ResultBean errorResult = new ResultBean(Constants.STATUS_SYSTEM_ERROR, "Error", "An error occurred: " + e.getMessage());
            return new ResponseEntity<>(errorResult, HttpStatus.INTERNAL_SERVER_ERROR);
     }



    }
}

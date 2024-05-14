package org.api.controller;

import org.api.bean.ResultBean;
import org.api.services.CustomerDeliveryDestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer-dest")
public class CustomerDeliveryDestController {
    @Autowired
    private CustomerDeliveryDestService deliveryDestService;

    @GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ResultBean> getCustomerDeliveryDestForDialog(@RequestParam(name = "keyWord", required = false)
                                                                           String keyWord) throws Exception {

        ResultBean resultBean = (keyWord.isEmpty()) ? deliveryDestService.getAllCustomerDeliveryDestDialog() :
                                            deliveryDestService.searchCustomerDeliveryDestDialogByCodeOrName(keyWord);

        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
    }
}

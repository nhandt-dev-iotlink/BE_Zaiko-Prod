package org.api.controller;

import org.api.bean.ResultBean;
import org.api.services.CustomerDeliveryDestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CustomerDeliveryDestController {
    @Autowired
    private CustomerDeliveryDestService customerDeliveryDestService;
    @GetMapping("/customer-dest")
    public ResponseEntity<ResultBean> getAll(@RequestParam Map<String, String> deliveryName) throws Exception {
        ResultBean resultBean = null;
        if(deliveryName.isEmpty()){
            resultBean = customerDeliveryDestService.getAll("");
            return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
        }else {
            resultBean = customerDeliveryDestService.getAll(deliveryName.get("keyWord"));
            return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
        }
    }
    @GetMapping("/customer-destination-by-code")
    public ResponseEntity<ResultBean> findByCode(@RequestParam("code") String code) throws Exception {
        ResultBean resultBean = null;
        resultBean = customerDeliveryDestService.findDtoByCode(code);
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
    }
}

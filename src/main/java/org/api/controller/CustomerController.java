package org.api.controller;

import org.api.bean.ResultBean;
import org.api.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public ResponseEntity<ResultBean> getAll(@RequestParam Map<String, String> customerName) throws Exception {
        ResultBean resultBean = null;
        if (customerName.isEmpty()) {
            resultBean = customerService.getAll("");
            return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
        } else {
            resultBean = customerService.getAll(customerName.get("keyWord"));
            return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
        }
    }

    @GetMapping("/customer-by-code")
    public ResponseEntity<ResultBean> getByCode(@RequestParam String code) throws Exception {
        ResultBean resultBean = null;
        resultBean = customerService.getAllByCode(code);
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
    }
}

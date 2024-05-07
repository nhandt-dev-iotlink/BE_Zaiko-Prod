package org.api.controller;

import lombok.RequiredArgsConstructor;
import org.api.bean.dto.CustomerDto;
import org.api.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/get-all")
    public ResponseEntity<List<CustomerDto>> getSearchList(@RequestParam(defaultValue = "") String keyWord) {
        List<CustomerDto> customerList = customerService.getAll(keyWord);
        if (customerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerList , HttpStatus.OK);
    }
}

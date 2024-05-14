package org.api.controller;

import lombok.RequiredArgsConstructor;
import org.api.bean.dto.CustomerDestDto;

import org.api.services.ICustomerDestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer-dest")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CustomerDeliveryDestController {
    @Autowired
    private ICustomerDestService customerDestService;

    @GetMapping("/get-all")
    public ResponseEntity<List<CustomerDestDto>> getSearchList(@RequestParam(defaultValue = "") String keyWord) {
        List<CustomerDestDto> destinationList = customerDestService.getAll(keyWord);
        if (destinationList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(destinationList, HttpStatus.OK);
    }
}

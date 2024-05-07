package org.api.controller;

import lombok.RequiredArgsConstructor;
import org.api.bean.dto.CustomerDto;
import org.api.bean.dto.SupplierDto;
import org.api.services.ICustomerService;
import org.api.services.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SupplierController {
    @Autowired
    private ISupplierService supplierService;
    @GetMapping("/get-all")
    public ResponseEntity<List<SupplierDto>> getSearchList(@RequestParam(defaultValue = "") String keyWord) {
        List<SupplierDto> supplierList = supplierService.getAll(keyWord);
        if (supplierList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(supplierList , HttpStatus.OK);
    }
}

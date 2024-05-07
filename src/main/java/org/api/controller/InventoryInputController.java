package org.api.controller;

import lombok.RequiredArgsConstructor;
import org.api.bean.dto.InputListDto;
import org.api.bean.dto.SearchOutputListDto;
import org.api.services.IInventoryInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory-input")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class InventoryInputController {
    @Autowired
    private IInventoryInputService inventoryInputService;
    @GetMapping("/search-input-list")
    public ResponseEntity<Page<InputListDto>> getSearchList(@RequestParam(required = false, defaultValue = "0") Integer page,
                                                            @RequestParam(required = false, defaultValue = "20") Integer size,
                                                            @RequestParam(required = false) String inputPlanDateFrom,
                                                            @RequestParam(required = false) String inputPlanDateTo,
                                                            @RequestParam(required = false) String inputActualDateFrom,
                                                            @RequestParam(required = false) String inputActualDateTo,
                                                            @RequestParam(required = false) String slipNoFrom,
                                                            @RequestParam(required = false) String slipNoTo,
                                                            @RequestParam(required = false) String productOwnerIdFrom,
                                                            @RequestParam(required = false) String productOwnerIdTo,

                                                            @RequestParam(required = false) Integer destinationIdFrom,
                                                            @RequestParam(required = false) Integer destinationIdTo,
                                                            @RequestParam(defaultValue = "") String departmentName,
                                                            @RequestParam(required = false) Integer supplierIdFrom,
                                                            @RequestParam(required = false) Integer supplierIdTo,
                                                            @RequestParam(defaultValue = "") String supplierName,
                                                            @RequestParam(required = false) Integer customerIdFrom,
                                                            @RequestParam(required = false) Integer customerIdTo,
                                                            @RequestParam(defaultValue = "") String customerName,

                                                            @RequestParam(required = false) Integer productIdFrom,
                                                            @RequestParam(required = false) Integer productIdTo,
                                                            @RequestParam(defaultValue = "") String productName,
                                                            @RequestParam(required = false) Integer repositoryIdFrom,
                                                            @RequestParam(required = false) Integer repositoryIdTo,
                                                            @RequestParam String receiptType,
                                                            @RequestParam String receiptStatus,
                                                            @RequestParam String isClosed


    ) {

        Pageable pageable = PageRequest.of(page, size);
        System.out.println(page);

        Page<InputListDto> inputList = inventoryInputService.getSearchList(inputPlanDateFrom,inputPlanDateTo, inputActualDateFrom, inputActualDateTo, slipNoFrom, slipNoTo,
                productOwnerIdFrom, productOwnerIdTo,  destinationIdFrom, destinationIdTo, departmentName, supplierIdFrom, supplierIdTo, supplierName,
                customerIdFrom, customerIdTo, customerName, productIdFrom, productIdTo, productName, repositoryIdFrom, repositoryIdTo,
                receiptType, receiptStatus, isClosed, pageable);
        if (inputList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(inputList, HttpStatus.OK);
    }

}

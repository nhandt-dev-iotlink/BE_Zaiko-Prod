package org.api.controller;

import lombok.RequiredArgsConstructor;
import org.api.bean.dto.OutputListDto;
import org.api.bean.dto.SearchOutputListDto;
import org.api.services.IInventoryOutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory-output")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class InventoryOutputController {
    @Autowired
    private IInventoryOutputService inventoryOutputService;

    @GetMapping("/list-output")
    public ResponseEntity<List<OutputListDto>> getAllOutputList() {
        List<OutputListDto> outputList = inventoryOutputService.getAll();
        if (outputList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(outputList, HttpStatus.OK);
    }

    // Ver dùng id
//    @GetMapping("/search-output-list")
//    public ResponseEntity<Page<SearchOutputListDto>> getListOutputWithPagination(@RequestParam(required = false, defaultValue = "0") Integer page,
//                                                                                 @RequestParam(required = false, defaultValue = "20") Integer size,
//                                                                                 @RequestParam(required = false) String orderDateFrom,
//                                                                                 @RequestParam(required = false) String orderDateTo,
//                                                                                 @RequestParam(required = false) String planOutputDateFrom,
//                                                                                 @RequestParam(required = false) String planOutputDateTo,
//                                                                                 @RequestParam(required = false) String planWorkingDayFrom,
//                                                                                 @RequestParam(required = false) String planWorkingDayTo,
//                                                                                 @RequestParam(required = false) String planDeliverDateFrom,
//                                                                                 @RequestParam(required = false) String planDeliverDateTo,
//                                                                                 @RequestParam(required = false) String slipNoFrom,
//                                                                                 @RequestParam(required = false) String slipNoTo,
//                                                                                 @RequestParam(required = false) Integer customerIdFrom,
//                                                                                 @RequestParam(required = false) Integer customerIdTo,
//                                                                                 @RequestParam(defaultValue = "") String customerName,
//                                                                                 @RequestParam(required = false) Integer destinationIdFrom,
//                                                                                 @RequestParam(required = false) Integer destinationIdTo,
//                                                                                 @RequestParam(defaultValue = "") String departmentName,
//                                                                                 @RequestParam(required = false) Integer supplierIdFrom,
//                                                                                 @RequestParam(required = false) Integer supplierIdTo,
//                                                                                 @RequestParam(defaultValue = "") String supplierName,
//
//                                                                                 @RequestParam(required = false) Integer productIdFrom,
//                                                                                 @RequestParam(required = false) Integer productIdTo,
//                                                                                 @RequestParam(defaultValue = "") String productName,
//                                                                                 @RequestParam(required = false) Integer repositoryIdFrom,
//                                                                                 @RequestParam(required = false) Integer repositoryIdTo,
//                                                                                 @RequestParam(defaultValue = "") String batchNo,
//                                                                                 @RequestParam String deliveryType,
//                                                                                 @RequestParam String deliveryStatus,
//                                                                                 @RequestParam String isClosed,
//                                                                                 @RequestParam(required = false) Integer ownerIdFrom,
//                                                                                 @RequestParam(required = false) Integer ownerIdTo,
//                                                                                 @RequestParam(required = false) String ownerName
//
//
//    ) {
//
//        Pageable pageable = PageRequest.of(page, size);
//        System.out.println(page);
//
//        Page<SearchOutputListDto> outputList = inventoryOutputService.getListOutputWithPagination(orderDateFrom, orderDateTo, planOutputDateFrom, planOutputDateTo, planWorkingDayFrom, planWorkingDayTo,
//                planDeliverDateFrom, planDeliverDateTo, slipNoFrom, slipNoTo, customerIdFrom, customerIdTo, customerName, destinationIdFrom,
//                destinationIdTo, departmentName, supplierIdFrom, supplierIdTo, supplierName, productIdFrom, productIdTo, productName, repositoryIdFrom,
//                repositoryIdTo, batchNo, deliveryType, deliveryStatus, isClosed, pageable, ownerIdFrom, ownerIdTo, ownerName);
//        if (outputList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(outputList, HttpStatus.OK);
//    }

// Ver dùng code
    @GetMapping("/search-output-list")
    public ResponseEntity<Page<SearchOutputListDto>> getListOutputWithPagination(@RequestParam(required = false,defaultValue = "0") Integer page,
                                                                                 @RequestParam(required = false,defaultValue = "20") Integer size,
                                                                                 @RequestParam(required = false) String orderDateFrom,
                                                                                 @RequestParam (required = false) String orderDateTo,
                                                                                 @RequestParam (required = false) String planOutputDateFrom,
                                                                                 @RequestParam(required = false) String planOutputDateTo,
                                                                                 @RequestParam (required = false) String planWorkingDayFrom,
                                                                                 @RequestParam(required = false) String planWorkingDayTo,
                                                                                 @RequestParam(required = false) String planDeliverDateFrom,
                                                                                 @RequestParam(required = false) String planDeliverDateTo,
                                                                                 @RequestParam(required = false) String slipNoFrom,
                                                                                 @RequestParam(required = false) String slipNoTo,
                                                                                 @RequestParam(required = false) String customerCodeFrom,
                                                                                 @RequestParam(required = false) String customerCodeTo,
                                                                                 @RequestParam(defaultValue = "") String customerName,
                                                                                 @RequestParam(required = false) String destinationCodeFrom,
                                                                                 @RequestParam(required = false) String destinationCodeTo,
                                                                                 @RequestParam(required = false) String departmentName,
                                                                                 @RequestParam(required = false) String supplierCodeFrom,
                                                                                 @RequestParam(required = false) String supplierCodeTo,
                                                                                 @RequestParam(required = false) String supplierName,

                                                                                 @RequestParam(required = false) String productCodeFrom,
                                                                                 @RequestParam(required = false) String productCodeTo,
                                                                                 @RequestParam(defaultValue = "") String productName,
                                                                                 @RequestParam(required = false) Integer repositoryIdFrom,
                                                                                 @RequestParam (required = false) Integer repositoryIdTo,
                                                                                 @RequestParam (required = false)String batchNo,
                                                                                 @RequestParam (defaultValue = "0") String deliveryType,
                                                                                 @RequestParam (defaultValue = "0") String deliveryStatus,
                                                                                 @RequestParam (defaultValue = "9") String isClosed,
                                                                                 @RequestParam (required = false) String ownerCodeFrom,
                                                                                 @RequestParam (required = false) String ownerCodeTo,
                                                                                 @RequestParam(required = false) String ownerName


    ) {

        Pageable pageable = PageRequest.of(page, size);
        System.out.println(page);

        Page<SearchOutputListDto> outputList = inventoryOutputService.getListOutputWithPagination(
                orderDateFrom,
                orderDateTo,
                planOutputDateFrom,
                planOutputDateTo,
                planWorkingDayFrom,
                planWorkingDayTo,
                planDeliverDateFrom,
                planDeliverDateTo,
                slipNoFrom,
                slipNoTo,
                customerCodeFrom,
                customerCodeTo,
                customerName,
                destinationCodeFrom,
                destinationCodeTo,
                departmentName,
                supplierCodeFrom,
                supplierCodeTo,
                supplierName,
                productCodeFrom,
                productCodeTo,
                productName,
                repositoryIdFrom,
                repositoryIdTo,
                batchNo,
                deliveryType,
                deliveryStatus,
                isClosed,
                ownerCodeFrom,
                ownerCodeTo,
                ownerName,
                pageable);
        if (outputList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(outputList, HttpStatus.OK);
    }


}

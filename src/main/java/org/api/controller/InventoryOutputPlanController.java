package org.api.controller;

import lombok.RequiredArgsConstructor;
import org.api.bean.dto.*;

import org.api.services.IPlanOutputService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory-output-plan")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class InventoryOutputPlanController {
    @Autowired
    private IPlanOutputService planOutputService;


    @GetMapping("/detail")
    public ResponseEntity<OutputDto> getInventoryOutputById(@RequestParam Integer id) {
        OutputDto inventoryOutput = planOutputService.findInventoryOutputById(id);
        if (inventoryOutput == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(inventoryOutput, HttpStatus.OK);
    }

    @GetMapping("/get-plan-detail")
    public ResponseEntity<List<OutputPlanDetailDto>> getPlanOutputDetail(@RequestParam(required = false) Integer id) {
        List<OutputPlanDetailDto> listPlanOutputDetail = planOutputService.getPlanOutputDetail(id);
        if (listPlanOutputDetail.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listPlanOutputDetail, HttpStatus.OK);
    }

    @GetMapping("/check-output-exist/{code}")
    public ResponseEntity<Boolean> getInventoryOutputById(@PathVariable String code) {
        Boolean isExistingOutput = planOutputService.checkOutputByCode(code);
        return new ResponseEntity<>(isExistingOutput, HttpStatus.OK);
    }

    @GetMapping("/get-customer-info/{code}")
    public ResponseEntity<CustomerAndDestDto> getCustomerInfo(@PathVariable String code) {
        CustomerAndDestDto customerInfo = planOutputService.getCustomerInfo(code);
        if (customerInfo == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerInfo, HttpStatus.OK);
    }

    @GetMapping("/get-product-info/{code}")
    public ResponseEntity<ProductSearchDto> getProductInfo(@PathVariable String code) {
        ProductSearchDto productInfo = planOutputService.getProductInfo(code);
        if (productInfo == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productInfo, HttpStatus.OK);
    }


}

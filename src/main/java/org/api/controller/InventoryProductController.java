package org.api.controller;

import lombok.RequiredArgsConstructor;
import org.api.bean.dto.InventoryProductDto;
import org.api.bean.dto.OutputPlanDetailDto;
import org.api.services.IInventoryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-inventory")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class InventoryProductController {
    @Autowired
    private IInventoryProductService inventoryProductService;


    @GetMapping("/get-inventory-product")
    public ResponseEntity<List<InventoryProductDto>> getInventoryProduct(@RequestParam Integer repositoryId, @RequestParam String productCode) {
        List<InventoryProductDto> listInventoryProduct = inventoryProductService.getInventoryProduct(repositoryId,productCode);
        if (listInventoryProduct.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listInventoryProduct, HttpStatus.OK);
    }
}

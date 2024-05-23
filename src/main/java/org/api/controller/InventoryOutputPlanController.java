package org.api.controller;

import lombok.RequiredArgsConstructor;
import org.api.bean.dto.OutputDto;
import org.api.services.IPlanOutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}

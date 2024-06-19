package org.api.controller;

import org.api.bean.ResultBean;
import org.api.bean.jpa.InventoryOutputEntity;
import org.api.dto.InventoryOutputPlanDto;
import org.api.dto.InventoryPlanOutputDetailDto;
import org.api.dto.PlanFormDto;
import org.api.services.InventoryOutputService;
import org.api.services.InventoryPlanOutputDetailService;
import org.api.services.impl.InventoryPlanOutputDetailServiceImpl;
import org.api.utils.PageableConstrants;
import org.api.utils.PaginationUtils;
import org.api.utils.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Payload;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/inventory-output-plan")
public class InventoryPlanOutputDetailController {
    @Autowired
    private InventoryPlanOutputDetailService inventoryPlanOutputDetailService;
    @Autowired
    private InventoryOutputService inventoryOutputService;

    @GetMapping("/detail")
    public ResponseEntity<Paging<InventoryPlanOutputDetailDto>> getAllInventoryPlanOutputDetailByInventoryOutputId(@PageableDefault(size = PageableConstrants.DEFAULT_SIZE, page = PageableConstrants.DEFAULT_PAGE) Pageable pageable,
                                                                                                                   Integer page, Integer size,
                                                                                                                   @RequestParam(value = "id") Integer id) throws Exception {
        Page<InventoryPlanOutputDetailDto> pages = inventoryPlanOutputDetailService.getAllInventoryPlanOutputDetailByInventoryOutputId(pageable, id);
        HttpHeaders headers = PaginationUtils
                .generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), pages);
        return new ResponseEntity<>(PaginationUtils.generatePage(pages), headers, HttpStatus.OK);
    }

    @PostMapping(value = "/detail", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResultBean> save(@RequestBody PlanFormDto planFormDto) throws Exception {
        ResultBean resultBean = inventoryOutputService.saveOutputPlan(planFormDto);
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
    }

}

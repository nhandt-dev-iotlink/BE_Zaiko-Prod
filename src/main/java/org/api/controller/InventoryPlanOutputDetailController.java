package org.api.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.api.bean.ResultBean;
import org.api.dto.InventoryPlanOutputDetailDto;
import org.api.dto.PlanFormDto;
import org.api.services.InventoryOutputService;
import org.api.services.InventoryPlanOutputDetailService;
import org.api.utils.*;
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

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class InventoryPlanOutputDetailController {
    public static final String FILE_JSON_VALIDATE_CREATE = "createOutputPlanInfo.json";
    public static final String FILE_JSON_VALIDATE_UPDATE = "updateOutputPlanInfo.json";
    @Autowired
    private InventoryPlanOutputDetailService inventoryPlanOutputDetailService;
    @Autowired
    private InventoryOutputService inventoryOutputService;

    @GetMapping("/inventory-output-plan/detail")
    public ResponseEntity<Paging<InventoryPlanOutputDetailDto>> getAllInventoryPlanOutputDetailByInventoryOutputId(@PageableDefault(size = 1000, page = PageableConstrants.DEFAULT_PAGE) Pageable pageable,
                                                                                                                   Integer page, Integer size,
                                                                                                                   @RequestParam(value = "id") Integer id) throws Exception {
        Page<InventoryPlanOutputDetailDto> pages = inventoryPlanOutputDetailService.getAllInventoryPlanOutputDetailByInventoryOutputId(pageable, id);
        HttpHeaders headers = PaginationUtils
                .generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), pages);
        return new ResponseEntity<>(PaginationUtils.generatePage(pages), headers, HttpStatus.OK);
    }

    @PostMapping(value = "/inventory-output-plan/detail", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResultBean> save(@RequestBody PlanFormDto planFormDto) throws Exception {
        ResultBean resultBean = inventoryOutputService.saveOutputPlan(planFormDto);
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
    }

    @PostMapping(value = "/inventory-output-plan/create", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResultBean> create(@RequestBody String json) throws Exception {
        ResultBean resultBean = null;
        resultBean = inventoryOutputService.create(json);
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
    }

    @PostMapping(value = "/inventory-output-plan/update", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResultBean> update(@RequestBody String json) throws Exception {
        ResultBean resultBean = null;
        resultBean = inventoryOutputService.update(json);
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
    }
}

package org.api.controller;


import com.google.gson.JsonObject;
import org.api.bean.ResultBean;
import org.api.dto.InventoryOutputDto;
import org.api.services.InventoryOutputService;
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

import java.util.Date;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class InventoryOutputController {
    @Autowired
    private InventoryOutputService inventoryOutputService;
    public static final String ALIAS = "User";

    @GetMapping(value = "/inventory-output")
    public ResponseEntity<Paging<InventoryOutputDto>> getAllPage(@PageableDefault(size = PageableConstrants.DEFAULT_SIZE, page = PageableConstrants.DEFAULT_PAGE) Pageable pageable,
                                                                 Integer page, Integer size,
                                                                 String orderDateFrom, String orderDateTo,
                                                                 String planOutputDateFrom, String planOutputDateTo,
                                                                 String planWorkingDateFrom, String planWorkingDateTo,
                                                                 String planDeliveryDateFrom, String planDeliveryDateTo,
                                                                 String slipNoFrom, String slipNoTo,
                                                                 String customerCodeFrom, String customerCodeTo,
                                                                 String customerName, String deliveryCodeFrom,
                                                                 String deliveryCodeTo, String deliveryName,
                                                                 String supplierCodeFrom, String supplierCodeTo,
                                                                 String supplierName, String ownerCodeFrom,
                                                                 String ownerCodeTo, String ownerName,
                                                                 String productCodeFrom, String productCodeTo, String productName,
                                                                 Integer repoFrom, Integer repoTo, String batchNo,
                                                                 @RequestParam(value = "deliveryType", defaultValue = "0")
                                                                 Integer deliveryType,
                                                                 @RequestParam(value = "deliveryStatus", defaultValue = "")
                                                                 String deliveryStatus,
                                                                 @RequestParam(value = "isClose", defaultValue = "")
                                                                 String isClose
    ) throws Exception {
        Page<InventoryOutputDto> pages = inventoryOutputService.getAllPage(pageable, orderDateFrom, orderDateTo,
                planOutputDateFrom, planOutputDateTo, planWorkingDateFrom, planWorkingDateTo,
                planDeliveryDateFrom, planDeliveryDateTo, slipNoFrom, slipNoTo, customerCodeFrom, customerCodeTo, customerName,
                deliveryCodeFrom, deliveryCodeTo, deliveryName, supplierCodeFrom, supplierCodeTo, supplierName, ownerCodeFrom, ownerCodeTo, ownerName,
                productCodeFrom, productCodeTo, productName, repoFrom, repoTo, batchNo, deliveryType,
                deliveryStatus, isClose);
        HttpHeaders headers = PaginationUtils
                .generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), pages);
        return new ResponseEntity<>(PaginationUtils.generatePage(pages), headers, HttpStatus.OK);
    }

    @GetMapping(value = "/inventory-output/plan")
    public ResponseEntity<ResultBean> getInfoOutputPlan(@RequestParam(value = "id") Integer id) throws Exception {
        ResultBean resultBean = null;
        resultBean = inventoryOutputService.getInfoOutputDetailPlanById(id);
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
    }

    @GetMapping(value = "/inventory-output/actual")
    public ResponseEntity<ResultBean> getInfoOutputActual(@RequestParam(value = "id") Integer id) throws Exception {
        ResultBean resultBean = null;
        resultBean = inventoryOutputService.getInfoOutputDetailPlanById(id);
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
    }

//    @GetMapping(value = "/plan/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<ResultBean> getInfoOutputPlanById(@PathVariable Integer id) throws Exception {
//        ResultBean resultBean = null;
//        resultBean = inventoryOutputService.getInfoOutputPlanById(id);
//        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
//    }

    @GetMapping("/check-slip-no")
    public ResponseEntity<ResultBean> checkSlipNo(@RequestParam(value = "slipNo") String slipNo) throws Exception {
        ResultBean resultBean = inventoryOutputService.checkSlipNo(slipNo);
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
    }

    @PutMapping(value = "/inventory-output/plan", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResultBean> demo(@RequestBody String json) throws Exception {
        ResultBean resultBean = null;
        System.out.println(json);
        String date1 = "2022/01/01";
        JsonObject jsonObject = DataUtil.getJsonObject(json);
        Date date = DataUtil.convertStringToDate(date1, "yyyy-MM-dd");
        if (DataUtil.isDate(date.toString(), "yyyy-MM-dd")) {
            throw new ApiValidateException(Constants.ID_BKE00004, ConstantColumns.DATETIME_MNG_FROM,
                    MessageUtils.getMessage(Constants.ID_BKE00004, new Object[]{ItemNameUtils.getItemName(ConstantColumns.USER_ID, ALIAS)}));
        }
        if (DataUtil.isNull(jsonObject, ConstantColumns.USER_ID)) {
            throw new ApiValidateException(Constants.ID_BKE00004, ConstantColumns.USER_ID,
                    MessageUtils.getMessage(Constants.ID_BKE00004, new Object[]{ItemNameUtils.getItemName(ConstantColumns.USER_ID, ALIAS)}));
        }

        Integer userId = DataUtil.getJsonInteger(jsonObject, ConstantColumns.USER_ID);

        return new ResponseEntity<>(resultBean, HttpStatus.OK);
    }

    @DeleteMapping(value = "/inventory-output/plan")
    public ResponseEntity<ResultBean> deleteOutputPlan(@RequestParam(value = "id") Integer id) throws Exception {
        ResultBean resultBean = inventoryOutputService.deleteOutputPlanById(id);
        return new ResponseEntity<>(resultBean, HttpStatus.OK);
    }

//    @PostMapping("/plan/detail")
//    public ResponseEntity<Paging<InventoryPlanOutputDetailDto>> getAllInventoryPlanOutputDetailByInventoryOutputId (@PageableDefault(size = PageableConstrants.DEFAULT_SIZE, page = PageableConstrants.DEFAULT_PAGE) Pageable pageable,
//                                                                                                                   Integer page, Integer size,
//                                                                                                                   @RequestParam(value = "inventoryOutputId") Integer inventoryOutputId) throws Exception {
//        Page<InventoryPlanOutputDetailDto> pages = inventoryPlanOutputDetailService.getAllInventoryPlanOutputDetailByInventoryOutputId(pageable, inventoryOutputId);
//        HttpHeaders headers = PaginationUtils
//                .generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), pages);
//        return new ResponseEntity<>(PaginationUtils.generatePage(pages), headers, HttpStatus.OK);
//    }

}

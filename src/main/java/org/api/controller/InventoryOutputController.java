package org.api.controller;


import com.google.api.Http;
import io.lettuce.core.dynamic.annotation.Param;
import org.api.annotation.LogExecutionTime;

import org.api.bean.ResultBean;
import org.api.bean.reponse.dto.InventoryOutputListDTO;

import org.api.services.InventoryOutputService;
import org.api.utils.Constants;
import org.api.utils.PageableConstrants;
import org.api.utils.PaginationUtils;
import org.api.utils.Paging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.List;

@LogExecutionTime
@RestController
public class InventoryOutputController {


    private static final Logger log = LoggerFactory.getLogger(InventoryOutputController.class);

    /**
     * The info service.
     */


    @Autowired
    private InventoryOutputService outputService;


    @GetMapping(value = "/api/check-slip-no/{slipNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultBean> checkSlipNo(@PathVariable String slipNo) {
        try {
            Boolean exists = outputService.existsBySlipNo(slipNo);
            ResultBean successResult = new ResultBean(exists, Constants.STATUS_OK, Constants.MESSAGE_OK);
            return new ResponseEntity<>(successResult,HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/api/get-automatic-slip-no")
    public ResponseEntity<String> getNextAutomaticSlipNumber() {
        try {
            String nextSlipNumber = outputService.getNextAutomaticSlipNo();
            if (nextSlipNumber != null) {
                return ResponseEntity.ok(nextSlipNumber);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            String errorMessage = "An error occurred while retrieving the next automatic slip number: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }


    @GetMapping(value = "/api/inventory-output", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Paging<InventoryOutputListDTO>> getInventorySearch(@PageableDefault(size = PageableConstrants.DEFAULT_SIZE, page = PageableConstrants.DEFAULT_PAGE) Pageable pageable, String keyWord,Integer page, Integer size,
//*******************************************************************************************************************************************************************************************************************************************
                                                                             @Param("repositoryIdFrom") Integer repositoryIdFrom,@Param("repositoryIdTo") Integer repositoryIdTo,
                                                                             @Param("orderDateFrom") String orderDateFrom, @Param("orderDateTo") String orderDateTo,
                                                                             @Param("planOutputDateFrom") String planOutputDateFrom, @Param("planOutputDateTo") String planOutputDateTo,
                                                                             @Param("planWorkingDateFrom") String planWorkingDateFrom, @Param("planWorkingDateTo") String planWorkingDateTo,
                                                                             @Param("planDeliverDateFrom") String planDeliverDateFrom, @Param("planDeliverDateTo") String planDeliverDateTo,
                                                                             @Param("slipNoFrom") String slipNoFrom, @Param("slipNoTo") String slipNoTo,
                                                                             @Param("productCodeFrom ") String productCodeFrom , @Param("productCodeTo ") String productCodeTo,@Param("batchNo") String batchNo, @Param("productName") String productName,
                                                                             @Param("destinationCodeFrom") String destinationCodeFrom, @Param("destinationCodeTo") String destinationCodeTo, @Param("departmentName") String departmentName,
                                                                             @Param("supplierCodeFrom") String supplierCodeFrom, @Param("supplierCodeTo") String supplierCodeTo, @Param("supplierName") String supplierName,
                                                                             @Param("customerCodeFrom") String customerCodeFrom, @Param("customerCodeTo") String customerCodeTo, @Param("customerName") String customerName,
                                                                             @Param("DeliveryType") String DeliveryType, @Param("DeliveryStatus") String DeliveryStatus, @Param("isClosed") String isClosed) throws Exception {

        Page<InventoryOutputListDTO> pages = outputService.findInventoryOutputWithFilters( pageable, page, size, repositoryIdFrom, repositoryIdTo, orderDateFrom, orderDateTo, planOutputDateFrom, planOutputDateTo,  planWorkingDateFrom, planWorkingDateTo,  planDeliverDateFrom, planDeliverDateTo,
                 slipNoFrom, slipNoTo,  productCodeFrom, productCodeTo, batchNo, productName,  destinationCodeFrom, destinationCodeTo, departmentName,  supplierCodeFrom,  supplierCodeTo,  supplierName,
                 customerCodeFrom,  customerCodeTo, customerName, DeliveryType, DeliveryStatus,  isClosed);
        HttpHeaders headers = PaginationUtils.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), pages);
        return new ResponseEntity<>(PaginationUtils.generatePage(pages), headers, HttpStatus.OK);
    }


























}

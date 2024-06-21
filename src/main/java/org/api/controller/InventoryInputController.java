package org.api.controller;


import org.api.annotation.LogExecutionTime;
import org.api.bean.reponse.dto.InventoryInputListDTO;
import org.api.bean.reponse.dto.InventoryOutputListDTO;
import org.api.services.InventoryInputService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@LogExecutionTime
@RestController
public class InventoryInputController {


    @Autowired
    InventoryInputService inventoryInputService ;

    private static final Logger log = LoggerFactory.getLogger(InventoryInputController.class);


    @GetMapping(value = "/api/inventory-input", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Paging<InventoryInputListDTO>> getInventorySearch(
            @PageableDefault(size = PageableConstrants.DEFAULT_SIZE, page = PageableConstrants.DEFAULT_PAGE) Pageable pageable,
            @RequestParam(required = false) String keyWord,

            // Date range filters
            @RequestParam(required = false) String inputPlanDateFrom,
            @RequestParam(required = false) String inputPlanDateTo,
            @RequestParam(required = false) String inputActualDateFrom,
            @RequestParam(required = false) String inputActualDateTo,

            // Slip number range
            @RequestParam(required = false) String slipNoFrom,
            @RequestParam(required = false) String slipNoTo,

            // Product owner filters
            @RequestParam(required = false) Integer productOwnerIdFrom,
            @RequestParam(required = false) Integer productOwnerIdTo,

            // Destination filters
            @RequestParam(required = false) Integer destinationIdFrom,
            @RequestParam(required = false) Integer destinationIdTo,

            // Department and supplier filters
            @RequestParam(required = false) String departmentName,
            @RequestParam(required = false) Integer supplierIdFrom,
            @RequestParam(required = false) Integer supplierIdTo,
            @RequestParam(required = false) String supplierName,

            // Customer filters
            @RequestParam(required = false) Integer customerIdFrom,
            @RequestParam(required = false) Integer customerIdTo,
            @RequestParam(required = false) String customerName,

            // Product filters
            @RequestParam(required = false) Integer productIdFrom,
            @RequestParam(required = false) Integer productIdTo,
            @RequestParam(required = false) String productName,

            // Repository filters
            @RequestParam(required = false) Integer repositoryIdFrom,
            @RequestParam(required = false) Integer repositoryIdTo,

            // Required parameters
            @RequestParam String receiptType,
            @RequestParam String receiptStatus,
            @RequestParam String isClosed) throws Exception {


        Page<InventoryOutputListDTO> pages = inventoryInputService.findInventoryInputWithFilters(
                pageable, keyWord,
                inputPlanDateFrom, inputPlanDateTo,
                inputActualDateFrom, inputActualDateTo,
                slipNoFrom, slipNoTo,
                productOwnerIdFrom, productOwnerIdTo,
                destinationIdFrom, destinationIdTo,
                departmentName,
                supplierIdFrom, supplierIdTo, supplierName,
                customerIdFrom, customerIdTo, customerName,
                productIdFrom, productIdTo, productName,
                repositoryIdFrom, repositoryIdTo,
                receiptType, receiptStatus, isClosed
        );

        // Tạo các headers cho pagination
        HttpHeaders headers = PaginationUtils.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), pages);

        // Trả về kết quả với thông tin phân trang
        return new ResponseEntity<>(PaginationUtils.generatePage(pages), headers, HttpStatus.OK);
    }




}

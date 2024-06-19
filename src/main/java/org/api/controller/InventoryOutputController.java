package org.api.controller;

import lombok.RequiredArgsConstructor;
import org.api.bean.dto.*;
import org.api.bean.jpa.CustomerDeliveryDestEntity;
import org.api.bean.jpa.CustomerEntity;
import org.api.bean.jpa.InventoryOutputEntity;
import org.api.bean.jpa.InventoryPlanOutputDetailEntity;
import org.api.services.*;
import org.api.utils.Constants;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static org.apache.tomcat.util.http.FastHttpDateFormat.getCurrentDate;

@RestController
@RequestMapping("/api/inventory-output")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class InventoryOutputController {
    @Autowired
    private IInventoryOutputService inventoryOutputService;

    @Autowired
    private ICustomerDestService customerDestService;

    @Autowired
    private IProductService productService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IPlanOutputService planOutputService;

    @Autowired
    private ISalePriceService salePriceService;

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
    public ResponseEntity<Page<SearchOutputListDto>> getListOutputWithPagination(@RequestParam(required = false, defaultValue = "0") Integer page,
                                                                                 @RequestParam(required = false, defaultValue = "20") Integer size,
                                                                                 @RequestParam(required = false) String orderDateFrom,
                                                                                 @RequestParam(required = false) String orderDateTo,
                                                                                 @RequestParam(required = false) String planOutputDateFrom,
                                                                                 @RequestParam(required = false) String planOutputDateTo,
                                                                                 @RequestParam(required = false) String planWorkingDayFrom,
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
                                                                                 @RequestParam(required = false) Integer repositoryIdTo,
                                                                                 @RequestParam(required = false) String batchNo,
                                                                                 @RequestParam(defaultValue = "0") String deliveryType,
                                                                                 @RequestParam(defaultValue = "0") String deliveryStatus,
                                                                                 @RequestParam(defaultValue = "9") String isClosed,
                                                                                 @RequestParam(required = false) String ownerCodeFrom,
                                                                                 @RequestParam(required = false) String ownerCodeTo,
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

    @PostMapping("/save-output")
    public ResponseEntity<?> savePlanOutput(@RequestBody OutputAndDetailDto outputAndDetailDto) {
        String destinationCode = outputAndDetailDto.outputPlan.getDestinationCode();
        CustomerDestDto customerDestDto = customerDestService.getCustomerDestByCode(destinationCode);
        OutputPlanModel outputPlanModel = outputAndDetailDto.outputPlan;

        // Get curent date with format 'YYMMDD'
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        String formattedDate = currentDate.format(formatter);
        System.out.println(formattedDate);

        String slipNo = inventoryOutputService.generateSlipNo(formattedDate);
        System.out.println(slipNo);

        InventoryOutputEntity inventoryOutput = new InventoryOutputEntity();
        BeanUtils.copyProperties(outputAndDetailDto.outputPlan, inventoryOutput);

        inventoryOutput.setBatchStatus(Constants.BATCH_STATUS_0);
        inventoryOutput.setChecked(outputAndDetailDto.outputPlan.isDestinationOption());
        inventoryOutput.setCompanyId(Constants.ONE_IN);
        inventoryOutput.setIsClosed(Constants.ZERO);
        inventoryOutput.setDeliverDestinationName(outputAndDetailDto.outputPlan.getDepartmentName());
        inventoryOutput.setPlanRepositoryId(outputAndDetailDto.outputPlan.getRepositoryId());
        inventoryOutput.setSaleCategory(Constants.ZERO);

        // Create new customer and new customer delivery dest in case destinationOption = true and customerDestDto == null
        if (customerDestDto == null) {
            CustomerEntity newCustomer = new CustomerEntity();
            BeanUtils.copyProperties(outputPlanModel, newCustomer);
            newCustomer.setCompanyId(Constants.ONE_IN);
            CustomerEntity customer = customerService.createCustomer(newCustomer);
            System.out.println(customer);
            Integer customerId = customer.getCustomerId();

            CustomerDeliveryDestEntity customerDest = new CustomerDeliveryDestEntity();
            BeanUtils.copyProperties(outputPlanModel, customerDest);
            customerDest.setCustomerId(customerId);
            customerDest.setIsCustomer(Constants.ZERO);
            customerDest.setCompanyId(Constants.ONE_IN);

            CustomerDeliveryDestEntity newCustomerDest = customerDestService.createCustomerDest(customerDest);
            System.out.println(newCustomerDest);

            inventoryOutput.setPlanCustomerDeliveryDestinationId(newCustomerDest.getDeliveryDestinationId());
            inventoryOutput.setPlanCustomerId(customerId);
        } else {
            inventoryOutput.setPlanCustomerDeliveryDestinationId(customerDestDto.getDeliveryDestinationId());
            inventoryOutput.setPlanCustomerId(customerDestDto.getCustomerId());
        }
        inventoryOutput.setSlipNo(slipNo);
        inventoryOutput.setOutputStatus(Constants.ZERO);
        InventoryOutputEntity newInventoryOutput = inventoryOutputService.saveInventoryOutput(inventoryOutput);
        System.out.println(newInventoryOutput);
        Integer inventoryOutputId = newInventoryOutput.getInventoryOutputId();


        System.out.println("output " + inventoryOutput);
        for (OutputPlanDetailModel outputPlanDetailModel : outputAndDetailDto.detailList) {
            InventoryPlanOutputDetailEntity inventoryPlanOutputDetail = new InventoryPlanOutputDetailEntity();
            BeanUtils.copyProperties(outputPlanDetailModel, inventoryPlanOutputDetail);
            System.out.println(inventoryPlanOutputDetail);
            String productCode = outputPlanDetailModel.getProductCode();
            ProductDto productDto = productService.getByCode(productCode);
            Integer productId = productDto.getProductId();
            Integer totalPlanQuantity = outputPlanDetailModel.getTotalPlanQuantity();


            CustomerDto customerDto = customerService.getByCode(outputPlanDetailModel.getCustomerCode());
            Integer customerId = customerDto.getCustomerId();

            SalePriceDto salePriceDto = salePriceService.getSalePriceInfo(productId, customerId);
            System.out.println("salePriceDto" + salePriceDto);
            if (salePriceDto != null) {
                inventoryPlanOutputDetail.setPlanCsPrice(salePriceDto.getPackCsPrice());
                inventoryPlanOutputDetail.setPlanBlPrice(salePriceDto.getPackBlPrice());
                inventoryPlanOutputDetail.setPlanPiecePrice(salePriceDto.getPackPsPrice());
                Integer packingQuantity = totalPlanQuantity;
                Double salePrice = salePriceDto.getPackPsPrice();
                switch (outputPlanDetailModel.getBillingPackType()) {
                    case "1":
                        packingQuantity = totalPlanQuantity / (outputPlanDetailModel.getPackBlAmount() * outputPlanDetailModel.getPackCsAmount());
                        salePrice = salePriceDto.getPackCsPrice();
                        break;
                    case "2":
                        packingQuantity = totalPlanQuantity / outputPlanDetailModel.getPackBlAmount();
                        salePrice = salePriceDto.getPackBlPrice();
                        break;
                    case "3":
                        packingQuantity = totalPlanQuantity;
                        salePrice = salePriceDto.getPackPsPrice();
                        break;
                    default:
                        break;
                }
                inventoryPlanOutputDetail.setAmountTotal(packingQuantity * salePrice);
            } else {
                inventoryPlanOutputDetail.setPlanCsPrice(0.00);
                inventoryPlanOutputDetail.setPlanBlPrice(0.00);
                inventoryPlanOutputDetail.setPlanPiecePrice(0.00);
                inventoryPlanOutputDetail.setAmountTotal(0.00);
            }
            inventoryPlanOutputDetail.setBatchStatus(Constants.ZERO);
            inventoryPlanOutputDetail.setBatchNo(slipNo);
            inventoryPlanOutputDetail.setCompanyId(1);
            inventoryPlanOutputDetail.setInventoryOutputId(inventoryOutputId); // Sau khi luu InventoryOutput xong lay id len de dua vao
            inventoryPlanOutputDetail.setIsBatchInprogress(Constants.ZERO_IN);
            inventoryPlanOutputDetail.setProductId(productId);
            inventoryPlanOutputDetail.setProductOwnerId(customerDto.getCustomerId());
            InventoryPlanOutputDetailEntity newInventoryPlanOutputDetail = planOutputService.savePlanOutputDetail(inventoryPlanOutputDetail);
            System.out.println("detail " + inventoryPlanOutputDetail);
            System.out.println(newInventoryPlanOutputDetail);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get-customer-dest-address/{postCode}")
    public ResponseEntity<CustomerDestAddress> getCustomerDestAddress(@PathVariable String postCode) {
        CustomerDestAddress customerDestAddress = inventoryOutputService.getCustomerDestAddress(postCode);
        if (customerDestAddress == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerDestAddress, HttpStatus.OK);
    }


    @PostMapping("/delete-output-and-detail")
    public ResponseEntity<?> deleteOutputAndDetail(@RequestParam(value = "id") Integer id) {

        System.out.println(id);
        InventoryOutputEntity inventoryOutput = inventoryOutputService.getOutputById(id);

            inventoryOutput.setDelFlg(Constants.DEL_FLG_1);
            inventoryOutputService.saveInventoryOutput(inventoryOutput);
            System.out.println(inventoryOutput);



        List<InventoryPlanOutputDetailEntity> planOutputDetailList = planOutputService.findByOutputId(id);

            for (InventoryPlanOutputDetailEntity detail : planOutputDetailList) {
                System.out.println(detail);
                detail.setDelFlg(Constants.DEL_FLG_1);
                planOutputService.savePlanOutputDetail(detail);
                System.out.println(detail);
            }

        return new ResponseEntity<>(HttpStatus.OK);
    }


}

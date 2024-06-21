package org.api.services;

import org.api.bean.ResultBean;
import org.api.dto.InventoryOutputDto;
import org.api.dto.PlanFormDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface InventoryOutputService {
    Page<InventoryOutputDto> getAllPage(Pageable pageable, String orderDateFrom, String orderDateTo,
                                        String planOutputDateFrom, String planOutputDateTo, String planWorkingDateFrom,
                                        String planWorkingDateTo, String planDeliveryDateFrom, String planDeliveryDateTo,
                                        String slipNoFrom, String slipNoTo, String customerCodeFrom,
                                        String customerCodeTo, String customerName, String deliveryCodeFrom,
                                        String deliveryCodeTo, String deliveryName, String supplierCodeFrom,
                                        String supplierCodeTo, String supplierName, String ownerCodeFrom,
                                        String ownerCodeTo, String ownerName, String productCodeFrom,
                                        String productCodeTo, String productName, Integer repoFrom, Integer repoTo,
                                        String batchNo, Integer deliveryType,
                                        String deliveryStatus, String isClose)
            throws Exception;

    ResultBean getInfoOutputPlanById(Integer id) throws Exception;

    ResultBean saveOutputPlan(PlanFormDto planFormDto) throws Exception;

    ResultBean deleteOutputPlanById(Integer id) throws Exception;

    ResultBean checkSlipNo(String slipNo) throws Exception;
}

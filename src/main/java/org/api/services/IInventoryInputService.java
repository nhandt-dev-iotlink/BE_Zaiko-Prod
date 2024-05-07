package org.api.services;

import org.api.bean.dto.InputListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IInventoryInputService {
    Page<InputListDto> getSearchList(String inputPlanDateFrom, String inputPlanDateTo, String inputActualDateFrom, String inputActualDateTo, String slipNoFrom, String slipNoTo, String productOwnerIdFrom,  String productOwnerIdTo, Integer destinationIdFrom, Integer destinationIdTo, String departmentName, Integer supplierIdFrom, Integer supplierIdTo, String supplierName, Integer customerIdFrom, Integer customerIdTo, String customerName, Integer productIdFrom, Integer productIdTo, String productName, Integer repositoryIdFrom, Integer repositoryIdTo, String receiptType, String receiptStatus, String isClosed, Pageable pageable);
}

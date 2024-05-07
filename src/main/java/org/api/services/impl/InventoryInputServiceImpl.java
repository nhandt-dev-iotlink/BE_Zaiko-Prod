package org.api.services.impl;

import org.api.bean.dto.InputListDto;
import org.api.repository.IInventoryInputRepository;

import org.api.services.IInventoryInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InventoryInputServiceImpl implements IInventoryInputService {
    @Autowired
    private IInventoryInputRepository inventoryInputRepository;
    @Override
    public Page<InputListDto> getSearchList(String inputPlanDateFrom, String inputPlanDateTo, String slipNoFrom, String inputActualDateFrom, String inputActualDateTo, String slipNoTo, String productOwnerIdFrom,  String productOwnerIdTo, Integer destinationIdFrom, Integer destinationIdTo, String departmentName, Integer supplierIdFrom, Integer supplierIdTo, String supplierName, Integer customerIdFrom, Integer customerIdTo, String customerName, Integer productIdFrom, Integer productIdTo, String productName, Integer repositoryIdFrom, Integer repositoryIdTo, String receiptType, String receiptStatus, String isClosed, Pageable pageable) {
        return inventoryInputRepository.getSearchList( inputPlanDateFrom, inputPlanDateTo, slipNoFrom, slipNoTo, inputActualDateFrom, productOwnerIdFrom, productOwnerIdTo, inputActualDateTo, destinationIdFrom, destinationIdTo, departmentName, supplierIdFrom, supplierIdTo, supplierName, customerIdFrom, customerIdTo, customerName, productIdFrom, productIdTo, productName, repositoryIdFrom, repositoryIdTo, receiptType, receiptStatus, isClosed, pageable);
    }
}

package org.api.services.impl;

import org.api.bean.jpa.InventoryOutputEntity;
import org.api.bean.jpa.SupplierEntity;
import org.api.dto.InventoryOutputDto;
import org.api.dto.SupplierDto;
import org.api.repository.inventoryOutput.InventoryOutputRepository;
import org.api.services.InventoryOutputService;
import org.api.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryOutputServiceImpl implements InventoryOutputService {
    @Autowired
    private InventoryOutputRepository inventoryOutputRepo;
    @Autowired
    private SupplierService supplierService;

    @Override
    public Page<InventoryOutputDto> getAllPage(Pageable pageable, String orderDateFrom, String orderDateTo,
                                               String planOutputDateFrom, String planOutputDateTo, String planWorkingDateFrom,
                                               String planWorkingDateTo, String planDeliveryDateFrom, String planDeliveryDateTo,
                                               String slipNoFrom, String slipNoTo, String customerCodeFrom,
                                               String customerCodeTo, String customerName, String deliveryCodeFrom,
                                               String deliveryCodeTo, String deliveryName, String supplierCodeFrom,
                                               String supplierCodeTo, String supplierName, String ownerCodeFrom,
                                               String ownerCodeTo, String ownerName, String productCodeFrom,
                                               String productCodeTo, String productName, Integer repoFrom, Integer repoTo,
                                               String batchNo, Integer deliveryType,
                                               String deliveryStatus, String isClose) throws Exception {
        Page<InventoryOutputDto> response = inventoryOutputRepo.getAllPage(pageable, orderDateFrom, orderDateTo,
                planOutputDateFrom, planOutputDateTo, planWorkingDateFrom, planWorkingDateTo, planDeliveryDateFrom,
                planDeliveryDateTo, slipNoFrom, slipNoTo, customerCodeFrom, customerCodeTo, customerName,
                deliveryCodeFrom, deliveryCodeTo, deliveryName, supplierCodeFrom, supplierCodeTo, supplierName, ownerCodeFrom,
                ownerCodeTo, ownerName,
                productCodeFrom, productCodeTo, productName, repoFrom, repoTo, batchNo, deliveryType, deliveryStatus, isClose);
        return new PageImpl<>(response.getContent(), response.getPageable(), response.getTotalElements());
    }
}

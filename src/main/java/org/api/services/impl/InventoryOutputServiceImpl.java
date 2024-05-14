package org.api.services.impl;

import org.api.dto.inventory_output.reponse.search.InventoryOutputListDTO;
import org.api.repository.inventory_output.InventoryOutputRepository;
import org.api.services.InventoryOutputService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InventoryOutputServiceImpl implements InventoryOutputService {

    private final InventoryOutputRepository inventoryOutputRepository;

    public InventoryOutputServiceImpl(InventoryOutputRepository inventoryOutputRepository) {
        this.inventoryOutputRepository = inventoryOutputRepository;
    }

    @Override
    public Page<InventoryOutputListDTO> getAllInventoryInfor(Pageable pageRequest) {

        Page<InventoryOutputListDTO> listResult = inventoryOutputRepository.findAllInventoryOutputInfor(pageRequest);
        return new PageImpl<>(listResult.getContent(), listResult.getPageable(), listResult.getTotalElements());
    }

    @Override
    public Page<InventoryOutputListDTO> searchInventoryInformation(String fromOrderDate, String toOrderDate, String fromPlanOutputDate,
                                                                   String toPlanOutputDate, String fromPlanWorkingDate,
                                                                   String toPlanWorkingDate, String fromPlanDeliverDate,
                                                                   String toPlanDeliverDate, String fromSlipNo, String toSlipNo,
                                                                   String fromCustomerCode, String toCustomerCode, String customerName,
                                                                   String fromDeliverDestCode, String toDeliverDestCode,
                                                                   String deliveryDestName, String fromSupplierCode,
                                                                   String toSupplierCode, String supplierName,
                                                                   String fromProductCode, String toProductCode, String productName,
                                                                   Integer fromRepositoryId, Integer toRepositoryId,
                                                                   String batchNo, Integer deliveryType, String deliveryStatus,
                                                                   String isClosed, Pageable pageable) {

        Page<InventoryOutputListDTO> searchResult = inventoryOutputRepository
                .findInventoryOutputInfoByCondition(fromOrderDate,toOrderDate, fromPlanOutputDate, toPlanOutputDate, fromPlanWorkingDate,
                                                    toPlanWorkingDate, fromPlanDeliverDate, toPlanDeliverDate, fromSlipNo, toSlipNo,
                                                    fromCustomerCode, toCustomerCode, customerName, fromDeliverDestCode,
                                                    toDeliverDestCode, deliveryDestName,fromSupplierCode, toSupplierCode,
                                                    supplierName, fromProductCode, toProductCode, productName, fromRepositoryId,
                                                    toRepositoryId, batchNo, deliveryType, deliveryStatus, isClosed, pageable);

        return new PageImpl<>(searchResult.getContent(), searchResult.getPageable(), searchResult.getTotalElements());
    }
}

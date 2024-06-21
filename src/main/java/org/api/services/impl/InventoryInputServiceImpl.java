package org.api.services.impl;

import org.api.annotation.LogExecutionTime;
import org.api.bean.reponse.dto.InventoryOutputListDTO;
import org.api.services.InventoryInputService;
import org.api.utils.ApiValidateException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@LogExecutionTime
@Service
@Transactional(rollbackFor = { ApiValidateException.class, Exception.class })
public class InventoryInputServiceImpl implements InventoryInputService {

    @Override
    public Page<InventoryOutputListDTO> findInventoryInputWithFilters(Pageable pageable, String keyWord, String inputPlanDateFrom, String inputPlanDateTo, String inputActualDateFrom, String inputActualDateTo, String slipNoFrom, String slipNoTo, Integer productOwnerIdFrom, Integer productOwnerIdTo, Integer destinationIdFrom, Integer destinationIdTo, String departmentName, Integer supplierIdFrom, Integer supplierIdTo, String supplierName, Integer customerIdFrom, Integer customerIdTo, String customerName, Integer productIdFrom, Integer productIdTo, String productName, Integer repositoryIdFrom, Integer repositoryIdTo, String receiptType, String receiptStatus, String isClosed) throws Exception {
        return null;
    }
}

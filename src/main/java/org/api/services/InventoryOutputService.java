package org.api.services;


import io.lettuce.core.dynamic.annotation.Param;
import org.api.bean.reponse.dto.InventoryOutputListDTO;
import org.api.bean.request.InventorySearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InventoryOutputService {





    public Page<InventoryOutputListDTO> findInventoryOutputWithFilters(Pageable pageable,Integer page,Integer size,Integer repositoryIdFrom,Integer repositoryIdTo,String orderDateFrom,String orderDateTo,String planOutputDateFrom,String planOutputDateTo, String planWorkingDateFrom,String planWorkingDateTo, String planDeliverDateFrom,String planDeliverDateTo,
                                                                       String slipNoFrom,String slipNoTo, String productCodeFrom,String productCodeTo,String batchNo,String productName, String destinationCodeFrom,String destinationCodeTo,String departmentName, String supplierCodeFrom, String supplierCodeTo, String supplierName,
                                                                       String customerCodeFrom, String customerCodeTo,String customerName,String DeliveryType,String DeliveryStatus, String isClosed)
            throws Exception;

}

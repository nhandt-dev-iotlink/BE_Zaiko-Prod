package org.api.services;


import org.api.bean.reponse.dto.InventoryOutputListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InventoryInputService {
    public Page<InventoryOutputListDTO> findInventoryInputWithFilters(Pageable pageable, String keyWord , String inputPlanDateFrom, String inputPlanDateTo,
                                                                      String  inputActualDateFrom, String inputActualDateTo,
                                                                      String slipNoFrom,String slipNoTo,
                                                                      Integer  productOwnerIdFrom, Integer  productOwnerIdTo,
                                                                      Integer  destinationIdFrom, Integer destinationIdTo,
                                                                      String  departmentName,
                                                                      Integer  supplierIdFrom, Integer supplierIdTo,String supplierName,
                                                                      Integer  customerIdFrom,Integer  customerIdTo, String customerName,
                                                                      Integer productIdFrom, Integer productIdTo, String productName,
                                                                      Integer repositoryIdFrom,Integer  repositoryIdTo,
                                                                      String receiptType, String receiptStatus, String isClosed)
            throws Exception;

}

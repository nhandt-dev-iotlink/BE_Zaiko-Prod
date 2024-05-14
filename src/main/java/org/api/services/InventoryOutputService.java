package org.api.services;

import org.api.dto.inventory_output.reponse.search.InventoryOutputListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InventoryOutputService {
    Page<InventoryOutputListDTO> getAllInventoryInfor(Pageable pageable);
    Page<InventoryOutputListDTO> searchInventoryInformation(String fromOrderDate, String toOrderDate, String fromPlanOutputDate,
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
                                                            String isClosed, Pageable pageable);
}

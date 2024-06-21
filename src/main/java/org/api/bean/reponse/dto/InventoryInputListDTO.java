package org.api.bean.reponse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryInputListDTO {
    Integer inventoryInputId;
    String isClosed;
    String inputStatus;
    String slipNo;
    String inputPlanDate;
    String inputActualDate;
    String planDestinationCode;
    String actualDestinationCode;
    String planDepartmentName;
    String actualDepartmentName;
    String planSlipNote;
    String supplierCode;
    String supplierName;
    String customerCode;
    String customerName;
    String planRepositoryCode;
    String planRepositoryName;
    String actualRepositoryCode;
    String actualRepositoryName;
    String planSupplierSlipNo;
    String actualSupplierSlipNo;
    Integer sumPlanQuantity;
    Integer sumActualQuantity;
}

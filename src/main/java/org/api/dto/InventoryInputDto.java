package org.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InventoryInputDto {
    private Integer inventoryOutputId;
    private String isClosed;
    private String outputStatus;
    private String slipNo;
    private String inputPlanDate;
    private String inputActualDate;
    private String destinationCodePlan;
    private String departmentNamePlan;
    private String destinationCodeActual;
    private String departmentNameActual;
    private String planSlipNo;
    private String supplierCodePlan;
    private String supplierNamePlan;
    private String supplierCodeActual;
    private String supplierNameActual;
    private String ownerCodePlan;
    private String ownerNamePlan;
    private String ownerCodeActual;
    private String ownerNameActual;
    private String repositoryCodePlan;
    private String repositoryNamePlan;
    private String repositoryCodeActual;
    private String repositoryNameActual;
    private String planSupplierSlipNo;
    private String actualSupplierSlipNo;
    private Integer sumPlanQuantiry;
    private Integer sumActualQuantity;


}

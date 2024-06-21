package org.api.dto;

import lombok.*;

import java.beans.ConstructorProperties;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InventoryOutputDto {
    private Integer inventoryOutputId;
    private String isClosed;
    private String outputStatus;
    private String slipNo;
    private String planOutputDate;
    private String batchStatus;
    private String orderDate;
    private String actualOutputDate;
    private String planWorkingDate;
    private String planDeliveryDate;
    private String actualDeliveryDate;
    private String destinationCodePlan;
    private String departmentNamePlan;
    private String destinationCodeActual;
    private String departmentNameActual;
    private String customerCodePlan;
    private String customerNamePlan;
    private String customerCodeActual;
    private String customerNameActual;
    private String repositoryCodePlan;
    private String repositoryNamePlan;
    private String repositoryCodeActual;
    private String repositoryNameActual;
    private String planSupplierSlipNo;
    private String actualSupplierSlipNo;
    private Integer sumPlanQuantity;
    private Integer sumActualQuantity;

}

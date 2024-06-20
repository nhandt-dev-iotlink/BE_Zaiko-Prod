package org.api.bean.reponse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.api.bean.reponse.CommonResponse;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryOutputListDTO extends CommonResponse implements Serializable {
    private Integer inventoryOutputId;
    private String closed;
    private String outputStatus;
    private String slipNo;
    private String supplierCode;
    private String planOutputDate;
    private String batchStatus;
    private String orderDate;
    private String actualOutputDate;
    private String planWorkingDate;
    private String planDeliverDate;
    private String actualDeliverDate;
    private String deliveryDestinationCode;
    private Integer deliveryDestinationId;
    private String departmentName;
    private String customerCode;
    private String customerName;
    private String repositoryCode;
    private String repositoryName;
    private String planSupplierSlipNo;
    private String actualSupplierSlipNo;
    private Integer sumPlanQuantity;
    private Integer sumActualQuantity;

}

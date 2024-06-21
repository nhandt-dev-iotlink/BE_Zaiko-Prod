package org.api.bean.reponse.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryOutputPlanDTO {

    private Integer inventoryOutputId;
    private Integer companyId;
    private String deliverDestinationName;
    private String postCode;
    private String phoneNumber;
    private String faxNumber;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String routeCode;
    private String courseCode;
    private String orderDate;
    private String planOutputDate;
    private String planWorkingDate;
    private String planDeliverDate;
    private String planSupplierSlipNo;
    private String createSlipType;
    private String slipNo;
    private String slipNote;
    private Integer planRepositoryId;
    private String batchStatus;
    private String outputStatus;
    private String isClosed;
    private String checked;
    private String destinationCode;
    private String departmentName;
    private String customerCode;
    private String customerName;


}

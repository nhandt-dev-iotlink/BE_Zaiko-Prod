package org.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InventoryOutputPlanDto {
    private Integer inventoryOutputId;
    private String isClosed;
    private String outputStatus;
    private String orderDate;
    private String planOutputDate;
    private String planWorkingDate;
    private String planDeliveryDate;
    private String createSlipType;
    private String slipNo;
    private String planSupplierSlipNo;
    private Integer planCustomerDeliveryDestinationId;
    private Integer planCustomerId;
    private Integer planRepositoryId;
    private String checked;
    private String destinationCode;
    private String departmentName;
    private String phoneNumber;
    private String faxNumber;
    private String postCode;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String customerCode;
    private String customerName;
    private String routeCode;
    private String routeName;
    private String courseCode;
    private String courseName;
    private String repositoryCode;
    private String repositoryName;
    private String slipNote;
}

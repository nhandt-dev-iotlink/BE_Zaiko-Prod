package org.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InventoryOutputDetailDto {
    private Integer inventoryOutputId;
    private String isClosed;
    private String outputStatus;
    private String orderDate;
    private String planOutputDate;
    private String planWorkingDate;
    private String planDeliveryDate;
    private String actualOutputDate;
    private String actualDeliverDate;
    private String createSlipType;
    private String slipNo;
    private String planSupplierSlipNo;
    private String actualSupplierSlipNo;
    private Integer planCustomerDeliveryDestinationId;
    private Integer actualCustomerDeliveryDestinationId;
    private Integer planCustomerId;
    private Integer actualCustomerId;
    private Integer planRepositoryId;
    private Integer actualRepositoryId;
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




//    private Integer inventoryOutputId;
//    private Integer companyId;
//    private Integer planCustomerDeliveryDestinationId;
//    private Integer actualCustomerDeliveryDestinationId;
//    private String deliverDestinationName;
//    private String postCode;
//    private String phoneNumber;
//    private String faxNumber;
//    private String address1;
//    private String address2;
//    private String address3;
//    private String address4;
//    private String routeCode;
//    private String routeName;
//    private String courseCode;
//    private String courseName;
//    private Integer planCustomerId;
//    private Integer actualCustomerId;
//    private String orderDate;
//    private String planOutputDate;
//    private String planWorkingDate;
//    private String planDeliverDate;
//    private String actualOutputDate;
//    private String actualDeliverDate;
//    private String planSupplierSlipNo;
//    private String actualSupplierSlipNo;
//    private String createSlipType;
//    private String slipNo;
//    private String slipNote;
//    private Integer planRepositoryId;
//    private Integer actualRepositoryId;
//    private String batchStatus;
//    private String outputStatus;
//    private String isClosed;
//    private Integer sumPlanQuantity;
//    private Integer sumActualQuantity;
//    private String newDestinationName;
//    private String checked;
//    private String saleCategory;
//    private String freeItem1;
//    private String freeItem2;
//    private String freeItem3;





}
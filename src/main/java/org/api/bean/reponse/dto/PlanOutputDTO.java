package org.api.bean.reponse.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlanOutputDTO {
    private Integer inventoryOutputId;

    private String orderDate;

    private String planOutputDate;

    private String planWorkingDate;

    private String planDeliverDate;

    private String createSlipType;

    private String slipNo;

    private String planSupplierSlipNo;

    private Integer planCustomerDeliveryDestinationId;

    private String outputStatus;

    private String isClosed;

    private String departmentName;

    private Integer planCustomerId;

    private String customerName;

    private String slipNote;

    private Integer planRepositoryId;

    private String saleCategory;

    private String routeCode;

    private String courseCode;

    private String faxNumber;

    private String postCode;

    private String address1;

    private String address2;

    private String address3;

    private String address4;

}

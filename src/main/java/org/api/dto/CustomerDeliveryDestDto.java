package org.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDeliveryDestDto {
    private Integer deliveryDestinationId;
    private String destinationCode;
    private String departmentName;
    private String phoneNumber;
    private String faxNumber;
    private String postCode;
    private String routeCode;
    private String courseCode;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private Integer companyId;
    private Integer customerId;
    private String isCustomer = "0";
    private Integer leadTime;
}

package org.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDto {
    private Integer customerId;
    private String customerCode;
    private String customerName;
    private String departmentName;
    private String picName;
    private Integer leadTime;
    private Integer companyId;
    private String phoneNumber;
    private String faxNumber;
    private String postCode;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String routeCode;
    private String courseCode;
}

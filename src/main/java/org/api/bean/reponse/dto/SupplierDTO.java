package org.api.bean.reponse.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
public class SupplierDTO implements Serializable {
    private Integer supplierId;
    private Integer companyId;
    private String supplierCode;
    private String supplierName;
    private String departmentName;
    private String picName;
    private String phoneNumber;
    private String faxNumber;
    private String postCode;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String bankName;
    private String bankBranchName;
    private String bankAccNumber;
    private String bankAccHolder;
    private Integer leadTime;
    private String routeCode;
    private String courseCode;
    private String freeItem1;
    private String freeItem2;
    private String freeItem3;
    private String notes;

}
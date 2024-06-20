package org.api.bean.reponse.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@Builder
public class CustomerDeliveryDestDTO {

    @JsonProperty("deliveryDestinationId")
    private Integer deliveryDestinationId;

    // CompanyId
    @JsonProperty("companyId")
    private Integer companyId;

    //Customer ID
    @JsonProperty("customerId")
    private Integer customerId;

    //Is Customer
    @JsonProperty("isCuomer")
    private String isCuststomer;

    //Destination Code
    @JsonProperty("destinationCode")
    private String destinationCode;

    //Deparment Name
    @JsonProperty("departmentName")
    private String departmentName;

    //Pic Name
    @JsonProperty("picName")
    private String picName;

    //Phone Number
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    //Fax Number
    @JsonProperty("faxNumber")
    private String faxNumber;

    //Post Code
    @JsonProperty("postCode")
    private String postCode;

    //Address 1
    @JsonProperty("address1")
    private String address1;

    //Address 2
    @JsonProperty("address2")
    private String address2;

    //Address 3
    @JsonProperty("address3")
    private String address3;

    //Address 4
    @JsonProperty("address4")
    private String address4;

    //Lead Time
    @JsonProperty("leadTime")
    private Integer leadTime;

    //Route Code
    @JsonProperty("routeCode")
    private String routeCode;

    //Course Code
    @JsonProperty("courseCode")
    private String courseCode;

    //Output Priority Rank
    @JsonProperty("outputPriorityRank")
    private Integer outputPriorityRank = 1;

    // FreeItem1

    @JsonProperty("freeItem1")
    private String freeItem1;

    // FreeItem2

    @JsonProperty("freeItem2")
    private String freeItem2;

    // FreeItem3

    @JsonProperty("freeItem3")
    private String freeItem3;

    //Notes

    @JsonProperty("notes")
    private String notes;

}

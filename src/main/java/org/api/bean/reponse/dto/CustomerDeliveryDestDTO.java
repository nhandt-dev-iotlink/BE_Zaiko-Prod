package org.api.bean.reponse.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;



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

    //Address 1
    @JsonProperty("address1")
    private String address1;

    @JsonProperty("leadTime")
    private Integer leadTime;


}

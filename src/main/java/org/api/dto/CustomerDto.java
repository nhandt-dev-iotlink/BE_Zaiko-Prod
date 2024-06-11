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
    private Integer leadTime;
    private Integer companyId;
    private String phoneNumber;
    private String postCode;
    private String address1;
}

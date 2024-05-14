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
}

package org.api.dto.customerDeliveryDest.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerDeliveryDestDialogDTO {
    private Integer deliveryDestinationId;
    private String destinationCode;
    private String departmentName;
}

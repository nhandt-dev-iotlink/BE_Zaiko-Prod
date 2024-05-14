package org.api.dto.customer.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerDialogDTO {
    private Integer customerId;
    private String customerCode;
    private String customerName;
}

package org.api.dto.supplier.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SupplierDialogDTO {
    private Integer supplierId;
    private String supplierCode;
    private String supplierName;
}

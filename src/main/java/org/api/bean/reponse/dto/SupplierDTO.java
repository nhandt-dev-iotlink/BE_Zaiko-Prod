package org.api.bean.reponse.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SupplierDTO {
    private Integer supplierId;
    private String supplierCode;
    private String supplierName;

}
package org.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductInventoryDto {
    private Integer inventoryId;

    private Integer companyId;

    private Integer productOwnerId;

    private String customerCode;

    private Integer productId;

    private String productCode;

    private Integer supplierId;

    private String supplierCode;

    private Integer repositoryId;

    private String repositoryCode;

    private Integer locationId;

    private String locationCode;

    private String datetimeMng;

    private String numberMng;

    private String inventoryProductType;

    private Integer quantity;

    private Integer allocatedQuantity;

}

package org.api.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private Integer productId;
    private String productCode;
    private String name1;
    private String standardInfo;
    private String categoryCode1;
    private String categoryCode2;
    private String categoryCode3;
    private String categoryCode4;
    private String categoryCode5;
    private String notes;
    private String fifoType;
    private String isDatetimeMng;
    private String datetimeMngType;
    private String isNumberMng;
    private String isPackCsInput;
    private String isPackCsOutput;
    private String packCsUnitCode;
    private String packCsUnitName;
    private Integer packCsAmount;
    private String isPackBlInput;
    private String isPackBlOutput;
    private String packBlUnitCode;
    private String packBlUnitName;
    private Integer packBlAmount;
    private String isPieceInput;
    private String isPieceOutput;
    private String pieceUnitCode;
    private String pieceUnitName;
    private Integer repositoryId;
    private String repositoryCode;
    private Integer locationId;
    private String locationCode;
    private String isReplenishMng;
    private Integer minInventoryQuantity;
    private Integer minInputQuantity;
    private String isVarious;
    private Integer supplierId;
    private String supplierCode;
    private Integer leadTime;
    private String tax;
    private String isSet;
}
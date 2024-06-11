package org.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryPlanOutputDetailDto {
    private Integer companyId;
    private Integer planDetailId;
    private Integer inventoryOutputId;
    private String batchStatus;
    private String batchNo;
    private Integer productId;

    private String datetimeMngType;

    private String datetimeMngFrom;
    private String datetimeMngTo;

    private String isNumberMng;

    private String numberMngFrom;
    private String numberMngTo;
    private Integer productOwnerId;
    private Integer repositoryId;
    private Integer locationId;
    private String inventoryProductType;
    private String billingPackType;

    private Integer csPlanQuantity;
    private Integer blPlanQuantity;
    private Integer psPlanQuantity;
    private Integer packCsAmount;
    private Integer packBlAmount;
    private Integer totalPlanQuantity;

    private Double planCsPrice;
    private Double planBlPrice;
    private Double planPiecePrice;

    private Double amountTotal;
    private String productCode;
    private String productName;
    private String standardInfo;
    private String customerCode;
    private String customerName;
    private String departmentName;
    private String saleCategory;

}



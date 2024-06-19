package org.api.bean.dto;

public interface OutputPlanDetailDto {
    Integer getInventoryOutputId();

    Integer getPlanDetailId();

    String getBatchStatus();

    String getBatchNo();
    Integer getProductId();

    String getProductCode();
    String getProductName();

    String getStandardInfo();

    String getDatetimeMngFrom();

//    String getDatetimeMngType();
//
//    String getIsDatetimeMng();
//
//    String getDatetimeMng();

    String getDatetimeMngTo();
    String getNumberMngFrom();
    String getNumberMngTo();
    String getCustomerCode();
    String getCustomerName();
    String getDepartmentName();
    Integer getRepositoryId();
    String getRepositoryCode();
    String getRepositoryName();
    Integer getLocationId();
    String getLocationCode();
    String getLocationName();
    String getInventoryProductType();
    String getBillingPackType();
    Integer getCsPlanQuantity();
    Integer getBlPlanQuantity();
    Integer getPsPlanQuantity();
    Integer getTotalPlanQuantity();
    Double getPlanCsPrice();
    Double getPlanBlPrice();
    Double getPlanPiecePrice();
    Double getPlanAmountTotal();
}

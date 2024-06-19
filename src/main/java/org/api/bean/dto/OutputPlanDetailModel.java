package org.api.bean.dto;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor

public class OutputPlanDetailModel {
    private String productCode;
    private String productName;
    private String datetimeMngType;
    private String datetimeMngFrom;
    private String datetimeMngTo;
    private Integer repositoryId;
    private String billingPackType;
    private String standardInfo;
    private String numberMngFrom;
    private String numberMngTo;
    private Integer locationId;
    private Integer csPlanQuantity;
    private Integer blPlanQuantity;
    private Integer psPlanQuantity;
    private Integer packCsAmount;
    private Integer packBlAmount;
    private String customerCode;
    private String customerName;
    private String inventoryProductType;
    private Integer totalPlanQuantity;

    public String getProductCode() {
        return productCode;
    }

    public Integer getPackCsAmount() {
        return packCsAmount;
    }

    public void setPackCsAmount(Integer packCsAmount) {
        this.packCsAmount = packCsAmount;
    }

    public Integer getPackBlAmount() {
        return packBlAmount;
    }

    public void setPackBlAmount(Integer packBlAmount) {
        this.packBlAmount = packBlAmount;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public String toString() {
        return "OutputPlanDetailModel{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", datetimeMngType='" + datetimeMngType + '\'' +
                ", datetimeMngFrom='" + datetimeMngFrom + '\'' +
                ", datetimeMngTo='" + datetimeMngTo + '\'' +
                ", repositoryId=" + repositoryId +
                ", billingPackType='" + billingPackType + '\'' +
                ", standardInfo='" + standardInfo + '\'' +
                ", numberMngFrom='" + numberMngFrom + '\'' +
                ", numberMngTo='" + numberMngTo + '\'' +
                ", locationId=" + locationId +
                ", csPlanQuantity=" + csPlanQuantity +
                ", blPlanQuantity=" + blPlanQuantity +
                ", psPlanQuantity=" + psPlanQuantity +
                ", packCsAmount=" + packCsAmount +
                ", packBlAmount=" + packBlAmount +
                ", customerCode='" + customerCode + '\'' +
                ", customerName='" + customerName + '\'' +
                ", inventoryProductType='" + inventoryProductType + '\'' +
                ", totalPlanQuantity=" + totalPlanQuantity +
                '}';
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDatetimeMngType() {
        return datetimeMngType;
    }



    public void setDatetimeMngType(String datetimeMngType) {
        this.datetimeMngType = datetimeMngType;
    }

    public String getDatetimeMngFrom() {
        return datetimeMngFrom;
    }

    public void setDatetimeMngFrom(String datetimeMngFrom) {
        this.datetimeMngFrom = datetimeMngFrom;
    }

    public String getDatetimeMngTo() {
        return datetimeMngTo;
    }

    public void setDatetimeMngTo(String datetimeMngTo) {
        this.datetimeMngTo = datetimeMngTo;
    }

    public Integer getRepositoryId() {
        return repositoryId;
    }

    public void setRepositoryId(Integer repositoryId) {
        this.repositoryId = repositoryId;
    }

    public String getBillingPackType() {
        return billingPackType;
    }

    public void setBillingPackType(String billingPackType) {
        this.billingPackType = billingPackType;
    }

    public String getStandardInfo() {
        return standardInfo;
    }

    public void setStandardInfo(String standardInfo) {
        this.standardInfo = standardInfo;
    }

    public String getNumberMngFrom() {
        return numberMngFrom;
    }

    public void setNumberMngFrom(String numberMngFrom) {
        this.numberMngFrom = numberMngFrom;
    }

    public String getNumberMngTo() {
        return numberMngTo;
    }

    public void setNumberMngTo(String numberMngTo) {
        this.numberMngTo = numberMngTo;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getCsPlanQuantity() {
        return csPlanQuantity;
    }

    public void setCsPlanQuantity(Integer csPlanQuantity) {
        this.csPlanQuantity = csPlanQuantity;
    }

    public Integer getBlPlanQuantity() {
        return blPlanQuantity;
    }

    public void setBlPlanQuantity(Integer blPlanQuantity) {
        this.blPlanQuantity = blPlanQuantity;
    }

    public Integer getPsPlanQuantity() {
        return psPlanQuantity;
    }

    public void setPsPlanQuantity(Integer psPlanQuantity) {
        this.psPlanQuantity = psPlanQuantity;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getInventoryProductType() {
        return inventoryProductType;
    }

    public void setInventoryProductType(String inventoryProductType) {
        this.inventoryProductType = inventoryProductType;
    }

    public Integer getTotalPlanQuantity() {
        return totalPlanQuantity;
    }

    public void setTotalPlanQuantity(Integer totalPlanQuantity) {
        this.totalPlanQuantity = totalPlanQuantity;
    }
}

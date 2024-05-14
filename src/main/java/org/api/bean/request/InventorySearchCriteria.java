package org.api.bean.request;

import java.lang.reflect.Field;

public class InventorySearchCriteria {

    private String repositoryCode;
    private String startDate;
    private String endDate;
    private String starPlanOutputDate;
    private String endPlanOutputDate;
    private String starPlanWorkingDate;
    private String endPlanWorkingDate;
    private String starPlanDeliverDate;
    private String endPlanDeliverDate;
    private String starSlipNo;
    private String endSlipNo;
    private String starDestinationCode;
    private String endDestinationCode;
    private String departmentName;
    private String starSupplierCode;
    private String endSupplierCode;
    private String supplierName;
    private String starCustomerCode;
    private String endCustomerCode;
    private String customerName;
    private String deliveryType;
    private String deliveryStatus;
    private Integer isClosed;



    public boolean hasNonNullAttribute() {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                Object value = field.get(this);
                if (value != null) {
                    return true;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public InventorySearchCriteria(String repositoryCode, String startDate, String endDate, String starPlanOutputDate, String endPlanOutputDate, String starPlanWorkingDate, String endPlanWorkingDate, String starPlanDeliverDate, String endPlanDeliverDate, String starSlipNo, String endSlipNo, String starDestinationCode, String endDestinationCode, String departmentName, String starSupplierCode, String endSupplierCode, String supplierName, String starCustomerCode, String endCustomerCode, String customerName, String deliveryType, String deliveryStatus, Integer isClosed) {
        this.repositoryCode = repositoryCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.starPlanOutputDate = starPlanOutputDate;
        this.endPlanOutputDate = endPlanOutputDate;
        this.starPlanWorkingDate = starPlanWorkingDate;
        this.endPlanWorkingDate = endPlanWorkingDate;
        this.starPlanDeliverDate = starPlanDeliverDate;
        this.endPlanDeliverDate = endPlanDeliverDate;
        this.starSlipNo = starSlipNo;
        this.endSlipNo = endSlipNo;
        this.starDestinationCode = starDestinationCode;
        this.endDestinationCode = endDestinationCode;
        this.departmentName = departmentName;
        this.starSupplierCode = starSupplierCode;
        this.endSupplierCode = endSupplierCode;
        this.supplierName = supplierName;
        this.starCustomerCode = starCustomerCode;
        this.endCustomerCode = endCustomerCode;
        this.customerName = customerName;
        this.deliveryType = deliveryType;
        this.deliveryStatus = deliveryStatus;
        this.isClosed = isClosed;
    }

    public InventorySearchCriteria() {

    }

    public String getRepositoryCode() {
        return repositoryCode;
    }

    public void setRepositoryCode(String repositoryCode) {
        this.repositoryCode = repositoryCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStarPlanOutputDate() {
        return starPlanOutputDate;
    }

    public void setStarPlanOutputDate(String starPlanOutputDate) {
        this.starPlanOutputDate = starPlanOutputDate;
    }

    public String getEndPlanOutputDate() {
        return endPlanOutputDate;
    }

    public void setEndPlanOutputDate(String endPlanOutputDate) {
        this.endPlanOutputDate = endPlanOutputDate;
    }

    public String getStarPlanWorkingDate() {
        return starPlanWorkingDate;
    }

    public void setStarPlanWorkingDate(String starPlanWorkingDate) {
        this.starPlanWorkingDate = starPlanWorkingDate;
    }

    public String getEndPlanWorkingDate() {
        return endPlanWorkingDate;
    }

    public void setEndPlanWorkingDate(String endPlanWorkingDate) {
        this.endPlanWorkingDate = endPlanWorkingDate;
    }

    public String getStarPlanDeliverDate() {
        return starPlanDeliverDate;
    }

    public void setStarPlanDeliverDate(String starPlanDeliverDate) {
        this.starPlanDeliverDate = starPlanDeliverDate;
    }

    public String getEndPlanDeliverDate() {
        return endPlanDeliverDate;
    }

    public void setEndPlanDeliverDate(String endPlanDeliverDate) {
        this.endPlanDeliverDate = endPlanDeliverDate;
    }

    public String getStarSlipNo() {
        return starSlipNo;
    }

    public void setStarSlipNo(String starSlipNo) {
        this.starSlipNo = starSlipNo;
    }

    public String getEndSlipNo() {
        return endSlipNo;
    }

    public void setEndSlipNo(String endSlipNo) {
        this.endSlipNo = endSlipNo;
    }

    public String getStarDestinationCode() {
        return starDestinationCode;
    }

    public void setStarDestinationCode(String starDestinationCode) {
        this.starDestinationCode = starDestinationCode;
    }

    public String getEndDestinationCode() {
        return endDestinationCode;
    }

    public void setEndDestinationCode(String endDestinationCode) {
        this.endDestinationCode = endDestinationCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getStarSupplierCode() {
        return starSupplierCode;
    }

    public void setStarSupplierCode(String starSupplierCode) {
        this.starSupplierCode = starSupplierCode;
    }

    public String getEndSupplierCode() {
        return endSupplierCode;
    }

    public void setEndSupplierCode(String endSupplierCode) {
        this.endSupplierCode = endSupplierCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getStarCustomerCode() {
        return starCustomerCode;
    }

    public void setStarCustomerCode(String starCustomerCode) {
        this.starCustomerCode = starCustomerCode;
    }

    public String getEndCustomerCode() {
        return endCustomerCode;
    }

    public void setEndCustomerCode(String endCustomerCode) {
        this.endCustomerCode = endCustomerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Integer getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Integer isClosed) {
        this.isClosed = isClosed;
    }



}

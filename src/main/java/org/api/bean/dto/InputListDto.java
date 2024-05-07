package org.api.bean.dto;



public class InputListDto {
    Integer inventoryInputId;
    String isClosed;
    String inputStatus;
    String slipNo;
    String inputPlanDate;
    String inputActualDate;
    String planDestinationCode;
    String actualDestinationCode;
    String planDepartmentName;
    String actualDepartmentName;
    String planSlipNote;
    String supplierCode;
    String supplierName;
    String customerCode;
    String customerName;
    String planRepositoryCode;
    String planRepositoryName;
    String actualRepositoryCode;
    String actualRepositoryName;
    String planSupplierSlipNo;
    String actualSupplierSlipNo;
    Integer sumPlanQuantity;
    Integer sumActualQuantity;

    public InputListDto() {
    }

    public InputListDto(Integer inventoryInputId, String isClosed, String inputStatus, String slipNo, String inputPlanDate, String inputActualDate, String planDestinationCode, String actualDestinationCode, String planDepartmentName, String actualDepartmentName, String planSlipNote, String supplierCode, String supplierName, String customerCode, String customerName, String planRepositoryCode, String planRepositoryName, String actualRepositoryCode, String actualRepositoryName, String planSupplierSlipNo, String actualSupplierSlipNo, Integer sumPlanQuantity, Integer sumActualQuantity) {
        this.inventoryInputId = inventoryInputId;
        this.isClosed = isClosed;
        this.inputStatus = inputStatus;
        this.slipNo = slipNo;
        this.inputPlanDate = inputPlanDate;
        this.inputActualDate = inputActualDate;
        this.planDestinationCode = planDestinationCode;
        this.actualDestinationCode = actualDestinationCode;
        this.planDepartmentName = planDepartmentName;
        this.actualDepartmentName = actualDepartmentName;
        this.planSlipNote = planSlipNote;
        this.supplierCode = supplierCode;
        this.supplierName = supplierName;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.planRepositoryCode = planRepositoryCode;
        this.planRepositoryName = planRepositoryName;
        this.actualRepositoryCode = actualRepositoryCode;
        this.actualRepositoryName = actualRepositoryName;
        this.planSupplierSlipNo = planSupplierSlipNo;
        this.actualSupplierSlipNo = actualSupplierSlipNo;
        this.sumPlanQuantity = sumPlanQuantity;
        this.sumActualQuantity = sumActualQuantity;
    }

    public Integer getInventoryInputId() {
        return inventoryInputId;
    }

    public void setInventoryInputId(Integer inventoryInputId) {
        this.inventoryInputId = inventoryInputId;
    }

    public String getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(String isClosed) {
        this.isClosed = isClosed;
    }

    public String getInputStatus() {
        return inputStatus;
    }

    public void setInputStatus(String inputStatus) {
        this.inputStatus = inputStatus;
    }

    public String getSlipNo() {
        return slipNo;
    }

    public void setSlipNo(String slipNo) {
        this.slipNo = slipNo;
    }

    public String getInputPlanDate() {
        return inputPlanDate;
    }

    public void setInputPlanDate(String inputPlanDate) {
        this.inputPlanDate = inputPlanDate;
    }

    public String getInputActualDate() {
        return inputActualDate;
    }

    public void setInputActualDate(String inputActualDate) {
        this.inputActualDate = inputActualDate;
    }

    public String getPlanDestinationCode() {
        return planDestinationCode;
    }

    public void setPlanDestinationCode(String planDestinationCode) {
        this.planDestinationCode = planDestinationCode;
    }

    public String getActualDestinationCode() {
        return actualDestinationCode;
    }

    public void setActualDestinationCode(String actualDestinationCode) {
        this.actualDestinationCode = actualDestinationCode;
    }

    public String getPlanDepartmentName() {
        return planDepartmentName;
    }

    public void setPlanDepartmentName(String planDepartmentName) {
        this.planDepartmentName = planDepartmentName;
    }

    public String getActualDepartmentName() {
        return actualDepartmentName;
    }

    public void setActualDepartmentName(String actualDepartmentName) {
        this.actualDepartmentName = actualDepartmentName;
    }

    public String getPlanSlipNote() {
        return planSlipNote;
    }

    public void setPlanSlipNote(String planSlipNote) {
        this.planSlipNote = planSlipNote;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
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

    public String getPlanRepositoryCode() {
        return planRepositoryCode;
    }

    public void setPlanRepositoryCode(String planRepositoryCode) {
        this.planRepositoryCode = planRepositoryCode;
    }

    public String getPlanRepositoryName() {
        return planRepositoryName;
    }

    public void setPlanRepositoryName(String planRepositoryName) {
        this.planRepositoryName = planRepositoryName;
    }

    public String getActualRepositoryCode() {
        return actualRepositoryCode;
    }

    public void setActualRepositoryCode(String actualRepositoryCode) {
        this.actualRepositoryCode = actualRepositoryCode;
    }

    public String getActualRepositoryName() {
        return actualRepositoryName;
    }

    public void setActualRepositoryName(String actualRepositoryName) {
        this.actualRepositoryName = actualRepositoryName;
    }

    public String getPlanSupplierSlipNo() {
        return planSupplierSlipNo;
    }

    public void setPlanSupplierSlipNo(String planSupplierSlipNo) {
        this.planSupplierSlipNo = planSupplierSlipNo;
    }

    public String getActualSupplierSlipNo() {
        return actualSupplierSlipNo;
    }

    public void setActualSupplierSlipNo(String actualSupplierSlipNo) {
        this.actualSupplierSlipNo = actualSupplierSlipNo;
    }

    public Integer getSumPlanQuantity() {
        return sumPlanQuantity;
    }

    public void setSumPlanQuantity(Integer sumPlanQuantity) {
        this.sumPlanQuantity = sumPlanQuantity;
    }

    public Integer getSumActualQuantity() {
        return sumActualQuantity;
    }

    public void setSumActualQuantity(Integer sumActualQuantity) {
        this.sumActualQuantity = sumActualQuantity;
    }
}

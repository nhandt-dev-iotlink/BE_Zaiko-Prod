package org.api.bean.dto;


public class SearchOutputListDto {
    private Integer inventoryOutputId;

    private String isClosed;

    private String outputStatus;

    private String slipNo;

    private String planOutputDate;

    private String orderDate;

//    private String orderDateTo;

    private String batchStatus;

    private String actualOutputDate;

    private String planWorkingDate;

    private String planDeliverDate;

    private String actualDeliverDate;

    private String destinationCode;

    private String departmentName;

    private String customerCode;

    private String customerName;

    private String repositoryCode;

    private String repositoryName;

    private String planSupplierSlipNo;

    private String actualSupplierSlipNo;

    private Integer sumPlanQuantity;

    private Integer sumActualQuantity;

    public SearchOutputListDto() {
    }




    public SearchOutputListDto(Integer inventoryOutputId, String isClosed, String outputStatus, String slipNo, String planOutputDate, String orderDate, String batchStatus, String actualOutputDate, String planWorkingDate, String planDeliverDate, String actualDeliverDate, String destinationCode, String departmentName, String customerCode, String customerName, String repositoryCode, String repositoryName, String planSupplierSlipNo, String actualSupplierSlipNo, Integer sumPlanQuantity, Integer sumActualQuantity) {
        this.inventoryOutputId = inventoryOutputId;
        this.isClosed = isClosed;
        this.outputStatus = outputStatus;
        this.slipNo = slipNo;
        this.planOutputDate = planOutputDate;
        this.orderDate = orderDate;
        this.batchStatus = batchStatus;
        this.actualOutputDate = actualOutputDate;
        this.planWorkingDate = planWorkingDate;
        this.planDeliverDate = planDeliverDate;
        this.actualDeliverDate = actualDeliverDate;
        this.destinationCode = destinationCode;
        this.departmentName = departmentName;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.repositoryCode = repositoryCode;
        this.repositoryName = repositoryName;
        this.planSupplierSlipNo = planSupplierSlipNo;
        this.actualSupplierSlipNo = actualSupplierSlipNo;
        this.sumPlanQuantity = sumPlanQuantity;
        this.sumActualQuantity = sumActualQuantity;
    }

    public Integer getInventoryOutputId() {
        return inventoryOutputId;
    }

    public void setInventoryOutputId(Integer inventoryOutputId) {
        this.inventoryOutputId = inventoryOutputId;
    }

    public String getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(String isClosed) {
        this.isClosed = isClosed;
    }

    public String getOutputStatus() {
        return outputStatus;
    }

    public void setOutputStatus(String outputStatus) {
        this.outputStatus = outputStatus;
    }

    public String getSlipNo() {
        return slipNo;
    }

    public void setSlipNo(String slipNo) {
        this.slipNo = slipNo;
    }

    public String getPlanOutputDate() {
        return planOutputDate;
    }

    public void setPlanOutputDate(String planOutputDate) {
        this.planOutputDate = planOutputDate;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(String batchStatus) {
        this.batchStatus = batchStatus;
    }

    public String getActualOutputDate() {
        return actualOutputDate;
    }

    public void setActualOutputDate(String actualOutputDate) {
        this.actualOutputDate = actualOutputDate;
    }

    public String getPlanWorkingDate() {
        return planWorkingDate;
    }

    public void setPlanWorkingDate(String planWorkingDate) {
        this.planWorkingDate = planWorkingDate;
    }

    public String getPlanDeliverDate() {
        return planDeliverDate;
    }

    public void setPlanDeliverDate(String planDeliverDate) {
        this.planDeliverDate = planDeliverDate;
    }

    public String getActualDeliverDate() {
        return actualDeliverDate;
    }

    public void setActualDeliverDate(String actualDeliverDate) {
        this.actualDeliverDate = actualDeliverDate;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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

    public String getRepositoryCode() {
        return repositoryCode;
    }

    public void setRepositoryCode(String repositoryCode) {
        this.repositoryCode = repositoryCode;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
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

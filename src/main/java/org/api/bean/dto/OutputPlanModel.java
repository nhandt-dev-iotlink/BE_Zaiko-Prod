package org.api.bean.dto;

public class OutputPlanModel {
    private String orderDate;
    private String planOutputDate;
    private String planWorkingDate;
    private String planDeliverDate;
    private String createSlipType;
    private String slipNo;
    private String planSupplierSlipNo;
    private String slipNote;
    private String destinationCode;
    private String departmentName;
    private boolean destinationOption;
    private String customerCode;
    private String customerName;
    private Integer repositoryId;
    private String routeCode;
    private String courseCode;
    private String postCode;
    private String faxNumber;
    private String phoneNumber;
    private String address1;
    private String address2;
    private String address3;
    private String address4;

    public OutputPlanModel() {
    }

    @Override
    public String toString() {
        return "OutputPlanModel{" +
                "orderDate='" + orderDate + '\'' +
                ", planOutputDate='" + planOutputDate + '\'' +
                ", planWorkingDate='" + planWorkingDate + '\'' +
                ", planDeliverDate='" + planDeliverDate + '\'' +
                ", createSlipType='" + createSlipType + '\'' +
                ", slipNo='" + slipNo + '\'' +
                ", planSupplierSlipNo='" + planSupplierSlipNo + '\'' +
                ", slipNote='" + slipNote + '\'' +
                ", destinationCode='" + destinationCode + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", destinationOption=" + destinationOption +
                ", customerCode='" + customerCode + '\'' +
                ", customerName='" + customerName + '\'' +
                ", repositoryId=" + repositoryId +
                ", routeCode='" + routeCode + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", postCode='" + postCode + '\'' +
                ", faxNumber='" + faxNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", address3='" + address3 + '\'' +
                ", address4='" + address4 + '\'' +
                '}';
    }

    public OutputPlanModel(String postCode, String orderDate, String planOutputDate, String planWorkingDate, String planDeliverDate, String createSlipType, String slipNo, String planSupplierSlipNo, String slipNote, String destinationCode, String departmentName, boolean destinationOption, String customerCode, String customerName, Integer repositoryId, String routeCode, String courseCode, String faxNumber, String phoneNumber, String address1, String address2, String address3, String address4) {
        this.postCode = postCode;
        this.orderDate = orderDate;
        this.planOutputDate = planOutputDate;
        this.planWorkingDate = planWorkingDate;
        this.planDeliverDate = planDeliverDate;
        this.createSlipType = createSlipType;
        this.slipNo = slipNo;
        this.planSupplierSlipNo = planSupplierSlipNo;
        this.slipNote = slipNote;
        this.destinationCode = destinationCode;
        this.departmentName = departmentName;
        this.destinationOption = destinationOption;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.repositoryId = repositoryId;
        this.routeCode = routeCode;
        this.courseCode = courseCode;
        this.faxNumber = faxNumber;
        this.phoneNumber = phoneNumber;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.address4 = address4;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getPlanOutputDate() {
        return planOutputDate;
    }

    public void setPlanOutputDate(String planOutputDate) {
        this.planOutputDate = planOutputDate;
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

    public String getCreateSlipType() {
        return createSlipType;
    }

    public void setCreateSlipType(String createSlipType) {
        this.createSlipType = createSlipType;
    }

    public String getSlipNo() {
        return slipNo;
    }

    public void setSlipNo(String slipNo) {
        this.slipNo = slipNo;
    }

    public String getPlanSupplierSlipNo() {
        return planSupplierSlipNo;
    }

    public void setPlanSupplierSlipNo(String planSupplierSlipNo) {
        this.planSupplierSlipNo = planSupplierSlipNo;
    }

    public String getSlipNote() {
        return slipNote;
    }

    public void setSlipNote(String slipNote) {
        this.slipNote = slipNote;
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

    public boolean isDestinationOption() {
        return destinationOption;
    }

    public void setDestinationOption(boolean destinationOption) {
        this.destinationOption = destinationOption;
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

    public Integer getRepositoryId() {
        return repositoryId;
    }

    public void setRepositoryId(Integer repositoryId) {
        this.repositoryId = repositoryId;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress4() {
        return address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }
}

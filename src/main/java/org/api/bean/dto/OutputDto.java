package org.api.bean.dto;

public interface OutputDto {
    Integer getInventoryOutputId();
    String getOutputStatus();
    String getIsClosed();
    Integer getSumPlanQuantity();
    Integer getSumActualQuantity();
    String getOrderDate();
    String getPlanOutputDate();
    String getPlanWorkingDate();
    String getPlanDeliverDate();
    String getLeadTime(); // Review again
    String getCreateSlipType();
    String getSlipNo();
    String getPlanSupplierSlipNo();
    String getDestinationCode();
    String getDepartmentName();
    String getCustomerCode();
    String getCustomerName();
    String getSlipNote();
    Integer getRepositoryId();
    String getRepositoryCode();
    String getRepositoryName();
    String getRouteCode();
    String getRouteName();
    String getCourseCode();
    String getPhoneNumber();
    String getFaxNumber();
    String getPostCode();
    String getAddress1();
    String getAddress2();
    String getAddress3();
    String getAddress4();

}

package org.api.bean.dto;

public interface OutputListDto {
    Integer getInventoryOutputId();

    String getIsClosed();

    String getOutputStatus();

    String getSlipNo();

    String getPlanOutputDate();

    String getOrderDateFrom();

    String getOrderDateTo();

    String getBatchStatus();

    String getActualOutputDate();

    String getPlanWorkingDate();

    String getPlanDeliverDate();

    String getActualDeliverDate();

    String getDestinationCode();

    String getDepartmentName();

    String getCustomerCode();

    String getCustomerName();

    String getRepositoryCode();

    String getRepositoryName();

    String getPlanSupplierSlipNo();

    String getActualSupplierSlipNo();

    Integer getSumPlanQuantity();

    Integer getSumActualQuantity();

}

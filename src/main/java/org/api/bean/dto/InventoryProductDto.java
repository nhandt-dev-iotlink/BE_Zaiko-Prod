package org.api.bean.dto;

public interface InventoryProductDto {
    Integer getInventoryId();
    Integer getCustomerId();
    String getCustomerCode();
    String getCustomerName();
    Integer getLocationId();
    String getDatetimeMngTo();
    String getNumberMngTo();
    String getInventoryProductType();
    String getProductCode();
    Integer getRepositoryId();

}

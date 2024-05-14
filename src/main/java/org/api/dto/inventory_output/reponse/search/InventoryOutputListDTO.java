package org.api.dto.inventory_output.reponse.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class InventoryOutputListDTO {

    @JsonProperty("inventoryOutputId")
    private Integer inventoryOutputId;

    @JsonProperty("isClosed")
    private String isClosed;


    @JsonProperty("outputStatus")
    private String outputStatus;

    @JsonProperty("slipNumber")
    private String slipNumber;

    /*
    *DeliveryType,if planOutputDate null then
     display tex chi co thuc te 'actual' else 'plan'
     */
    @JsonProperty("deliveryType")
    private String deliveryType;

    @JsonProperty("batchStatus")
    private String batchStatus;

    @JsonProperty("orderDate")
    private String orderDate;

    @JsonProperty("planOutputDate")
    private String planOutputDate;

    @JsonProperty("actualOutputDate")
    private String actualOutputDate;

    @JsonProperty("planPackingDay")
    private String planPackingDay;

    @JsonProperty("actualPackingDay")
    private String actualPackingDay;

    @JsonProperty("planDeliverDate")
    private String planDeliverDate;

    @JsonProperty("actualDeliverDate")
    private String actualDeliverDate;

    //DestinationCode
    @JsonProperty("planDeliveryDestCode")
    private String planDeliveryDestCode;

    //DestinationName
    @JsonProperty("planDeliveryDestName")
    private String planDeliveryDestName;

    @JsonProperty("actualDeliveryDestCode")
    private String actualDeliveryDestCode;

    @JsonProperty("actualDeliveryDestName")
    private String actualDeliveryDestName;

    //CustomerCode
    @JsonProperty("planShippingDestCode")
    private String planShippingDestCode;

    //CustomerName
    @JsonProperty("planShippingDestName")
    private String planShippingDestName;

    @JsonProperty("actualShippingDestCode")
    private String actualShippingDestCode;

    @JsonProperty("actualShippingDestName")
    private String actualShippingDestName;

    //Plan_RepositoryCode
    @JsonProperty("planRepoCode")
    private String planRepoCode;

    //Plan_RepositoryName
    @JsonProperty("planRepoName")
    private String planRepoName;

    @JsonProperty("actualRepoCode")
    private String actualRepoCode;

    @JsonProperty("actualRepoName")
    private String actualRepoName;

    //PlanSupplierSlipNo
    @JsonProperty("planSupplierSlipNo")
    private String planSupplierSlipNo;

    //ActualSupplierSlipNo
    @JsonProperty("actualSupplierSlipNo")
    private String actualSupplierSlipNo;

    //SumPlanQuantity
    @JsonProperty("sumPlanQuantity")
    private Integer sumPlanQuantity;

    //SumActualQuantity
    @JsonProperty("sumActualQuantity")
    private Integer sumActualQuantity;


}

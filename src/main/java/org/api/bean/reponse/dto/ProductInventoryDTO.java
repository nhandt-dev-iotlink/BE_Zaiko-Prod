package org.api.bean.reponse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@Builder
public class ProductInventoryDTO {

    @JsonProperty("inventoryId")
    private Integer inventory_id;

    //companyId
    @JsonProperty("companyId")
    private Integer company_id;

    //productOwnerId
    @JsonProperty("companyOwnerId")
    private Integer product_owner_id;

    //customerCode
    @JsonProperty("customerCode")
    private String customer_code;

    //productId

    @JsonProperty("productId")
    private Integer product_id;

    //productCode

    @JsonProperty("productCode")
    private String product_code;

    //supplierId
    @JsonProperty("supplierId")
    private Integer supplier_id;

    //supplierCode

    @JsonProperty("supplierCode")
    private String supplier_code;

    //repositoryId

    @JsonProperty("repositoryId")
    private Integer repository_id;

    //repositoryCode

    @JsonProperty("repositoryCode")
    private String repository_code;

    //locationId

    @JsonProperty("locationId")
    private Integer location_id;

    //locationCode

    @JsonProperty("locationCode")
    private String location_code;

    //datetime_mng

    @JsonProperty("datetimeMng")
    private String datetime_mng;

    //number_mng

    @JsonProperty("numberMng")
    private String number_mng;

    //inventoryProductType

    @JsonProperty("inventoryProductType")
    private String inventory_product_type;

    //quantity

    @JsonProperty("quantity")
    private Integer quantity;

    //allocatedQuantity

    @JsonProperty("allocatedQuantity")
    private Integer allocated_quantity;

    //free_item1

    @JsonProperty("freeItem1")
    private String free_item1;

    //free_item2
    @JsonProperty("freeItem2")
    private String free_item2;

    @JsonProperty("freeItem3")
    private String free_item3;
}

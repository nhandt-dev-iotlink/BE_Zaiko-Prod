package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_product_inventory_change")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class ProductInventoryChangeEntity extends CommonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_change_id")
    @JsonProperty("inventoryChange_id")
    private Integer inventory_change_id;

    //companyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer company_id;

    //companyOwnerId
    @Column(name = "company_owner_id",
            columnDefinition = "integer default 0000000")
    @JsonProperty("companyOwner_id")
    private Integer company_owner_id;

    //productId
    @Column(name = "product_id", nullable = false)
    @JsonProperty("productId")
    private Integer product_id;

    //setProductId
    @Column(name = "set_product_id")
    @JsonProperty("setProductId")
    private Integer set_product_id;

    //supplierId
    @Column(name = "supplier_id")
    @JsonProperty("supplierId")
    private Integer supplier_id;

    //repositoryId
    @Column(name = "repository_id",nullable = false)
    @JsonProperty("repositoryId")
    private Integer repository_id;

    //locationId
    @Column(name = "location_id",nullable = false)
    @JsonProperty("locationId")
    private Integer location_id;

    //datetime_mng
    @Column(name = "datetime_mng")
    @JsonProperty("datetime_mng")
    private String datetime_mng;

    //number_mng
    @Column(name = "number_mng")
    @JsonProperty("number_mng")
    private String number_mng;

    //inventoryProductType
    @Column(name = "inventory_product_type",nullable = false)
    @JsonProperty("inventoryProductType")
    private Integer inventory_product_type;

    //inventoryQuantity
    @Column(name = "inventory_quantity",nullable = false)
    @JsonProperty("inventoryQuantity")
    private Integer inventory_quantity;

    //changeQuantity
    @Column(name = "change_quantity",nullable = false)
    @JsonProperty("changeQuantity")
    private Integer change_quantity;

    //changeDate
    @Column(name = "change_date",nullable = false)
    @JsonProperty("changeDate")
    private String change_date;

    //businessDate
    @Column(name = "business_date",nullable = false)
    @JsonProperty("businessDate")
    private String business_date;

    //changeType
    @Column(name = "change_type",nullable = false)
    @JsonProperty("changeType")
    private String change_type;

    //changeReason
    @Column(name = "change_reason")
    @JsonProperty("changeReason")
    private String change_reason;

    //free_item1
    @Column(name = "free_item1")
    @JsonProperty("freeItem1")
    private String free_item1;

    //free_item2
    @Column(name = "free_item2")
    @JsonProperty("freeItem2")
    private String free_item2;

    //free_item3
    @Column(name = "free_item3")
    @JsonProperty("freeItem3")
    private String free_item3;

    //headerId
    @Column(name = "header_id")
    @JsonProperty("headerId")
    private Integer header_id;

    //detailId
    @Column(name = "detail_id")
    @JsonProperty("detail_id")
    private Integer detail_id;

    //slipNo
    @Column(name = "slip_no")
    @JsonProperty("slipNo")
    private String slip_no;
}

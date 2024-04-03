package org.api.bean.jpa;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "t_inventory_set_product_detail")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class InventorySetProductDetail extends CommonEntity {

    private static final long serialVersionUID = 1L;

    // InventorySetProductDetail ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Integer id;

    // InventorySetProductId
    @Column(name = "inventory_set_product_id")
    @JsonProperty("inventorySetProductId")
    private Integer inventorySetProductId;

    // InventoryId
    @Column(name = "inventory_id")
    @JsonProperty("inventoryId")
    private Integer inventoryId;

    // ProductID
    @Column(name = "product_id")
    @JsonProperty("productId")
    private Integer productId;

    // DatetimeMng
    @Column(name = "datetime_mng")
    @JsonProperty("datetimeMng")
    private String datetimeMng;

    // NumberMng
    @Column(name = "number_mng")
    @JsonProperty("numberMng")
    private String numberMng;

    // ProductOwnerID
    @Column(name = "product_owner_id")
    @JsonProperty("productOwnerID")
    private Integer productOwnerID;

    // RepositoryId
    @Column(name = "repository_id")
    @JsonProperty("repositoryId")
    private Integer repositoryId;

    // LocationId
    @Column(name = "location_id")
    @JsonProperty("locationId")
    private Integer locationId;

    // InventoryProductType
    @Column(name = "inventory_product_type")
    @JsonProperty("inventoryProductType")
    private Integer inventoryProductType;

    // SupplierId
    @Column(name = "supplier_id")
    @JsonProperty("supplierId")
    private Integer supplierId;

    // SubQuantity
    @Column(name = "sub_quantity", precision = 7, scale = 2)
    @JsonProperty("subQuantity")
    private BigDecimal subQuantity;

    // ConstituentQuantity
    @Column(name = "constituent_quantity", precision = 7, scale = 2)
    @JsonProperty("constituentQuantity")
    private BigDecimal constituentQuantity;

    // InventoryChildSetProductId
    @Column(name = "inventory_child_set_product_id")
    @JsonProperty("inventoryChildSetProductId")
    private Integer inventoryChildSetProductId;

    // FreeItem1
    @Column(name = "free_item1")
    @JsonProperty("freeItem1")
    private String freeItem1;

    // FreeItem2
    @Column(name = "free_item2")
    @JsonProperty("freeItem2")
    private String freeItem2;

    // FreeItem3
    @Column(name = "free_item3")
    @JsonProperty("freeItem3")
    private String freeItem3;


}
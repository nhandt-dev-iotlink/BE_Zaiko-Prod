package org.api.bean.jpa;


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
@Table(name = "t_stocktaking_detail")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class StocktakingDetail extends CommonEntity {

    private static final long serialVersionUID = 1L;

    // StocktakingDetail ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Integer id;

    // CompanyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    // StocktakingId
    @Column(name = "stocktaking_id", nullable = false)
    @JsonProperty("stocktakingId")
    private Integer stocktakingId;

    // InventoryId
    @Column(name = "inventory_id")
    @JsonProperty("inventoryId")
    private Integer inventoryId;

    // ProductOwnerID
    @Column(name = "product_owner_id", nullable = false)
    @JsonProperty("productOwnerID")
    private Integer productOwnerID;

    // SupplierId
    @Column(name = "supplier_id", nullable = false)
    @JsonProperty("supplierId")
    private Integer supplierId;

    // ProductID
    @Column(name = "product_id", nullable = false)
    @JsonProperty("productId")
    private Integer productId;

    // RepositoryId
    @Column(name = "repository_id", nullable = false)
    @JsonProperty("repositoryId")
    private Integer repositoryId;

    // LocationId
    @Column(name = "location_id", nullable = false)
    @JsonProperty("locationId")
    private Integer locationId;

    // DatetimeMng
    @Column(name = "datetime_mng")
    @JsonProperty("datetimeMng")
    private String datetimeMng;

    // NumberMng
    @Column(name = "number_mng")
    @JsonProperty("numberMng")
    private String numberMng;

    // InventoryProductType
    @Column(name = "inventory_product_type")
    @JsonProperty("inventoryProductType")
    private Integer inventoryProductType;

    // CsQuantity
    @Column(name = "cs_quantity")
    @JsonProperty("csQuantity")
    private Integer csQuantity;

    // BlQuantity
    @Column(name = "bl_quantity")
    @JsonProperty("blQuantity")
    private Integer blQuantity;

    // PsQuantity
    @Column(name = "ps_quantity")
    @JsonProperty("psQuantity")
    private Integer psQuantity;

    // QuantityInventory
    @Column(name = "quantity_inventory")
    @JsonProperty("quantityInventory")
    private Integer quantityInventory;

    // AllocatedQuantity
    @Column(name = "allocated_quantity")
    @JsonProperty("allocatedQuantity")
    private Integer allocatedQuantity;

    // Quantity
    @Column(name = "quantity")
    @JsonProperty("quantity")
    private Integer quantity;

    // StocktakingReason
    @Column(name = "stocktaking_reason")
    @JsonProperty("stocktakingReason")
    private String stocktakingReason;

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
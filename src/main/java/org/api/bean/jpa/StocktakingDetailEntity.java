package org.api.bean.jpa;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "t_stocktaking_detail")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class StocktakingDetailEntity extends CommonEntity {

    // StocktakingDetail ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stocktaking_detail_id")
    @JsonProperty("stocktakingDetail_id")
    private Integer stocktakingDetail_id;

    // CompanyId
    @Column(name = "company_id")
    @JsonProperty("companyId")
    private Integer companyId;

    // InventoryId
    @Column(name = "inventory_id")
    @JsonProperty("inventoryId")
    private Integer inventoryId;

    // StocktakingId
    @Column(name = "stocktaking_id")
    @JsonProperty("stocktakingId")
    private Integer stocktakingId;

    // ProductOwnerID
    @Column(name = "product_owner_id")
    @JsonProperty("productOwnerID")
    private Integer productOwnerID;

    // ProductID
    @Column(name = "product_id")
    @JsonProperty("productId")
    private Integer productId;

    // SupplierId
    @Column(name = "supplier_id")
    @JsonProperty("supplierId")
    private Integer supplierId;

    // RepositoryId
    @Column(name = "repository_id")
    @JsonProperty("repositoryId")
    private Integer repositoryId;

    // LocationId
    @Column(name = "location_id")
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
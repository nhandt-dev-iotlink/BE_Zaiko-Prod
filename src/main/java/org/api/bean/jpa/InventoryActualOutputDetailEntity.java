package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_inventory_actual_output_detail")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class InventoryActualOutputDetailEntity extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actual_detail_id")
    @JsonProperty("actualDetail_id")
    private Integer actualDetailId;

    //companyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    //inventoryOutput_id
    @Column(name = "inventory_output_id",nullable = false)
    @JsonProperty("inventoryOutput_id")
    private Integer inventoryOutputId;

    //planDetail_id
    @Column(name = "plan_detail_id")
    @JsonProperty("planDetail_id")
    private Integer planDetailId;

    //actualInventory_id
    @Column(name = "actual_inventory_id", nullable = false)
    @JsonProperty("actualInventory_id")
    private Integer actualInventoryId;

    //productOwner_id
    @Column(name = "product_owner_id", nullable = false)
    @JsonProperty("productOwner_id")
    private Integer productOwnerId;

    //supplierId
    @Column(name = "supplier_id", nullable = false)
    @JsonProperty("supplierId")
    private Integer supplierId;

    //repositoryId
    @Column(name = "repository_id", nullable = false)
    @JsonProperty("repositoryId")
    private Integer repositoryId;

    //locationId
    @Column(name = "location_id", nullable = false)
    @JsonProperty("locationId")
    private Integer locationId;

    //datetime_mng
    @Column(name = "datetime_mng",nullable = false)
    @JsonProperty("datetime_mng")
    private String datetime_mng;

    //number_mng
    @Column(name = "number_mng",nullable = false)
    @JsonProperty("number_mng")
    private String number_mng;

    //productId
    @Column(name = "product_id", nullable = false)
    @JsonProperty("productId")
    private Integer productId;

    //actualOutputDate
    @Column(name = "actual_output_date")
    @JsonProperty("actualOutputDate")
    private String actualOutputDate;

    //deliverDate
    @Column(name = "deliver_date")
    @JsonProperty("deliverDate")
    private String deliverDate;

    //billingPackType
    @Column(name = "billing_pack_type",nullable = false)
    @JsonProperty("billingPackType")
    private String billingPackType;

    //actual_cs_quantity
    @Column(name = "actual_cs_quantity")
    @JsonProperty("actual_cs_quantity")
    private Integer actualCsQuantity;

    //actual_bl_quantity
    @Column(name = "actual_bl_quantity")
    @JsonProperty("actual_bl_quantity")
    private Integer actualBlQuantity;

    //actual_ps_quantity
    @Column(name = "actual_ps_quantity")
    @JsonProperty("actual_ps_quantity")
    private Integer actualPsQuantity;

    //total_actual_quantity
    @Column(name = "total_actual_quantity")
    @JsonProperty("total_actual_quantity")
    private Integer totalActualQuantity;

    //inventoryProductType
    @Column(name = "inventory_product_type")
    @JsonProperty("inventoryProductType")
    private Integer inventoryProductType;

    //actual_cs_price
    @Column(name = "actual_cs_price",precision = 7,scale = 2)
    @JsonProperty("actual_cs_price")
    private Double actualCsPrice;

    //actual_bl_price
    @Column(name = "actual_bl_price",precision = 7,scale = 2)
    @JsonProperty("actual_bl_price")
    private Double actualBlPrice;

    //actualPiecePrice
    @Column(name = "actual_piece_price",precision = 7,scale = 2)
    @JsonProperty("actualPiecePrice")
    private Double actualPiecePrice;

    //amountTotal
    @Column(name = "amount_total",precision = 19,scale = 2)
    @JsonProperty("amountTotal")
    private Double amountTotal;

    //tax
    @Column(name = "tax",precision = 2,scale = 2)
    @JsonProperty("tax")
    private Double tax;

    //correctionReason
    @Column(name = "correction_reason")
    @JsonProperty("correctionReason")
    private String correctionReason;

    //deliverySlipPrintStatus
    @Column(name = "delivery_slip_print_status",
            columnDefinition = "boolean default false")
    @JsonProperty("deliverySlipPrintStatus")
    private Boolean deliverySlipPrintStatus;

    //free_item1
    @Column(name = "free_item1")
    @JsonProperty("freeItem1")
    private String freeItem1;

    //free_item2
    @Column(name = "free_item2")
    @JsonProperty("freeItem2")
    private String freeItem2;

    //free_item3
    @Column(name = "free_item3")
    @JsonProperty("freeItem3")
    private String freeItem3;

    //deliverySlip_id
    @Column(name = "delivery_slip_id")
    @JsonProperty("deliverySlip_id")
    private Integer deliverySlipId;

    //is_batch
    @Column(name = "is_batch")
    @JsonProperty("is_batch")
    private String isBatch;

    //batch_no
    @Column(name = "batch_no")
    @JsonProperty("batch_no")
    private String batchNo;
}

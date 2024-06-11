package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_inventory_plan_output_detail")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class InventoryPlanOutputDetailEntity extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_detail_id")
    @JsonProperty("planDetailId")
    private Integer planDetailId;

    //companyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    //inventoryOutput_id
    @Column(name = "inventory_output_id",nullable = false)
    @JsonProperty("inventoryOutputId")
    private Integer inventoryOutputId;

    //productInventory_id
    @Column(name = "product_inventory_id")
    @JsonProperty("productInventoryId")
    private Integer productInventoryId;

    //productId
    @Column(name = "product_id", nullable = false)
    @JsonProperty("productId")
    private Integer productId;

    //repositoryId
    @Column(name = "repository_id", nullable = false)
    @JsonProperty("repositoryId")
    private Integer repositoryId;

    //locationId
    @Column(name = "location_id")
    @JsonProperty("locationId")
    private Integer locationId;

    //datetime_mng_from
    @Column(name = "datetime_mng_from")
    @JsonProperty("datetimeMngFrom")
    private String datetimeMngFrom;

    //datetime_mng_to
    @Column(name = "datetime_mng_to")
    @JsonProperty("datetimeMngTo")
    private String datetimeMngTo;

    //number_mng_from
    @Column(name = "number_mng_from")
    @JsonProperty("numberMngFrom")
    private String numberMngFrom;

    //number_mng_to
    @Column(name = "number_mng_to")
    @JsonProperty("numberMngTo")
    private String numberMngTo;

    //productOwner_id
    @Column(name = "product_owner_id")
    @JsonProperty("productOwnerId")
    private Integer productOwnerId;

    //supplierId
    @Column(name = "supplier_id")
    @JsonProperty("supplierId")
    private Integer supplierId;

    //cs_plan_quantity
    @Column(name = "cs_plan_quantity")
    @JsonProperty("csPlanQuantity")
    private Integer csPlanQuantity;

    //bl_plan_quantity
    @Column(name = "bl_plan_quantity")
    @JsonProperty("blPlanQuantity")
    private Integer blPlanQuantity;

    //ps_plan_quantity
    @Column(name = "ps_plan_quantity")
    @JsonProperty("psPlanQuantity")
    private Integer psPlanQuantity;

    //total_plan_quantity
    @Column(name = "total_plan_quantity")
    @JsonProperty("totalPlanQuantity")
    private Integer totalPlanQuantity;

    //inventoryProductType
    @Column(name = "inventory_product_type")
    @JsonProperty("inventoryProductType")
    private String inventoryProductType;

    //detailNote
    @Column(name = "detail_note")
    @JsonProperty("detailNote")
    private String detailNote;

    //plan_cs_price
    @Column(name = "plan_cs_price",precision = 7,scale = 2)
    @JsonProperty("planCsPrice")
    private Double planCsPrice;

    //plan_bl_price
    @Column(name = "plan_bl_price",precision = 7,scale = 2)
    @JsonProperty("planBlPrice")
    private Double planBlPrice;

    //planPiecePrice
    @Column(name = "plan_piece_price",precision = 7,scale = 2)
    @JsonProperty("planPiecePrice")
    private Double planPiecePrice;

    //planAmountTotal
    @Column(name = "plan_amount_total",precision = 19,scale = 2)
    @JsonProperty("planAmountTotal")
    private Double planAmountTotal;

    //tax
    @Column(name = "tax",precision = 2,scale = 2)
    @JsonProperty("tax")
    private Double tax;

    //isBatchInprogress
    @Column(name = "is_batch_inprogress")
    @JsonProperty("isBatchInprogress")
    private Integer isBatchInprogress;

    //batchStatus
    @Column(name = "batch_status",nullable = false)
    @JsonProperty("batchStatus")
    private String batchStatus;

    //batchNo
    @Column(name = "batch_no")
    @JsonProperty("batchNo")
    private String batchNo;

    //billingPackType
    @Column(name = "billing_pack_type",nullable = false)
    @JsonProperty("billingPackType")
    private String billingPackType;

    //amountTotal
    @Column(name = "amount_total",precision = 7,scale = 2)
    @JsonProperty("amountTotal")
    private Double amountTotal;

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
}

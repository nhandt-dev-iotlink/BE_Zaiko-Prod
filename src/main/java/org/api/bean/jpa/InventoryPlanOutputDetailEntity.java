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
    @JsonProperty("planDetail_id")
    private Integer plan_detail_id;

    //companyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer company_id;

    //inventoryOutput_id
    @Column(name = "inventory_output_id",nullable = false)
    @JsonProperty("inventoryOutput_id")
    private Integer inventory_output_id;

    //productInventory_id
    @Column(name = "product_inventory_id")
    @JsonProperty("productInventory_id")
    private Integer product_inventory_id;

    //productId
    @Column(name = "product_id", nullable = false)
    @JsonProperty("productId")
    private Integer product_id;

    //repositoryId
    @Column(name = "repository_id", nullable = false)
    @JsonProperty("repositoryId")
    private Integer repository_id;

    //locationId
    @Column(name = "location_id", nullable = false)
    @JsonProperty("locationId")
    private Integer location_id;

    //datetime_mng_from
    @Column(name = "datetime_mng_from")
    @JsonProperty("datetime_mng_from")
    private String datetime_mng_from;

    //datetime_mng_to
    @Column(name = "datetime_mng_to")
    @JsonProperty("datetime_mng_to")
    private String datetime_mng_to;

    //number_mng_from
    @Column(name = "number_mng_from")
    @JsonProperty("number_mng_from")
    private String number_mng_from;

    //number_mng_to
    @Column(name = "number_mng_to")
    @JsonProperty("number_mng_to")
    private String number_mng_to;

    //productOwner_id
    @Column(name = "product_owner_id")
    @JsonProperty("productOwner_id")
    private Integer product_owner_id;

    //supplierId
    @Column(name = "supplier_id")
    @JsonProperty("supplierId")
    private Integer supplier_id;

    //cs_plan_quantity
    @Column(name = "cs_plan_quantity")
    @JsonProperty("cs_plan_quantity")
    private Integer cs_plan_quantity;

    //bl_plan_quantity
    @Column(name = "bl_plan_quantity")
    @JsonProperty("bl_plan_quantity")
    private Integer bl_plan_quantity;

    //ps_plan_quantity
    @Column(name = "ps_plan_quantity")
    @JsonProperty("ps_plan_quantity")
    private Integer ps_plan_quantity;

    //total_plan_quantity
    @Column(name = "total_plan_quantity")
    @JsonProperty("total_plan_quantity")
    private Integer total_plan_quantity;

    //inventoryProductType
    @Column(name = "inventory_product_type")
    @JsonProperty("inventoryProductType")
    private Integer inventory_product_type;

    //detailNote
    @Column(name = "detail_note")
    @JsonProperty("detailNote")
    private String detail_note;

    //plan_cs_price
    @Column(name = "plan_cs_price",precision = 7,scale = 2)
    @JsonProperty("plan_cs_price")
    private Double plan_cs_price;

    //plan_bl_price
    @Column(name = "plan_bl_price",precision = 7,scale = 2)
    @JsonProperty("plan_bl_price")
    private Double plan_bl_price;

    //planPiecePrice
    @Column(name = "plan_piece_price",precision = 7,scale = 2)
    @JsonProperty("planPiecePrice")
    private Double plan_piece_price;

    //planAmountTotal
    @Column(name = "plan_amount_total",precision = 19,scale = 2)
    @JsonProperty("planAmountTotal")
    private Double plan_amount_total;

    //tax
    @Column(name = "tax",precision = 2,scale = 2)
    @JsonProperty("tax")
    private Double tax;

    //isBatchInprogress
    @Column(name = "is_batch_inprogress")
    @JsonProperty("isBatchInprogress")
    private Integer is_batch_inprogress;

    //batchStatus
    @Column(name = "batch_status",nullable = false)
    @JsonProperty("batchStatus")
    private String batch_status;

    //batchNo
    @Column(name = "batch_no")
    @JsonProperty("batchNo")
    private String batch_no;

    //billingPackType
    @Column(name = "billing_pack_type",nullable = false)
    @JsonProperty("billingPackType")
    private String billing_pack_type;

    //amountTotal
    @Column(name = "amount_total",precision = 7,scale = 2)
    @JsonProperty("amountTotal")
    private Double amount_total;

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
}

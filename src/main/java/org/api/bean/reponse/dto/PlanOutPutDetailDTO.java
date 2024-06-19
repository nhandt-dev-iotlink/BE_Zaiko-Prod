package org.api.bean.reponse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PlanOutPutDetailDTO {

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

    private Integer repository_id;

    private Integer location_id;


    private String datetime_mng_from;

    private String datetime_mng_to;

    private String number_mng_from;

    private String number_mng_to;


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
    private Integer total_plan_quantity;


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


    private String billing_pack_type;

    //amountTotal
    private Double amount_total;


}

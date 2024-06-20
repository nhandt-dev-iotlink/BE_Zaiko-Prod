package org.api.bean.reponse.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryPlanOutputDetailDTO {

    @JsonProperty("planDetailId")
    private Integer plan_detail_id;

    @JsonProperty("companyId")
    private Integer company_id;

    @JsonProperty("inventoryOutputId")
    private Integer inventory_output_id;

    @JsonProperty("productInventoryId")
    private Integer product_inventory_id;

    @JsonProperty("productId")
    private Integer product_id;

    @JsonProperty("repositoryId")
    private Integer repository_id;

    @JsonProperty("locationId")
    private Integer location_id;

    @JsonProperty("datetimeMngFrom")
    private String datetime_mng_from;

    @JsonProperty("datetimeMngTo")
    private String datetime_mng_to;

    @JsonProperty("numberMngFrom")
    private String number_mng_from;

    @JsonProperty("numberMngTo")
    private String number_mng_to;

    @JsonProperty("productOwnerId")
    private Integer product_owner_id;

    @JsonProperty("supplierId")
    private Integer supplier_id;

    @JsonProperty("csPlanQuantity")
    private Integer cs_plan_quantity;

    @JsonProperty("blPlanQuantity")
    private Integer bl_plan_quantity;

    @JsonProperty("psPlanQuantity")
    private Integer ps_plan_quantity;

    @JsonProperty("totalPlanQuantity")
    private Integer total_plan_quantity;

    @JsonProperty("inventoryProductType")
    private Integer inventory_product_type;

    @JsonProperty("detailNote")
    private String detail_note;

    @JsonProperty("planCsPrice")
    private Double plan_cs_price;

    @JsonProperty("planBlPrice")
    private Double plan_bl_price;

    @JsonProperty("planPiecePrice")
    private Double plan_piece_price;

    @JsonProperty("planAmountTotal")
    private Double plan_amount_total;

    @JsonProperty("tax")
    private Double tax;

    @JsonProperty("isBatchInprogress")
    private Integer is_batch_inprogress;

    @JsonProperty("batchStatus")
    private String batch_status;

    @JsonProperty("batchNo")
    private String batch_no;

    @JsonProperty("billingPackType")
    private String billing_pack_type;

    @JsonProperty("amountTotal")
    private Double amount_total;

}

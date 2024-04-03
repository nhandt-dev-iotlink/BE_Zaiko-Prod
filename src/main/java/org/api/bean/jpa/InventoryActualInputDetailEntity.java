package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_inventory_actual_input_detail")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class InventoryActualInputDetailEntity extends CommonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actual_detail_id")
    @JsonProperty("actualDetail_id")
    private Integer actual_detail_id;

    //companyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer company_id;

    //inventoryInput_id
    @Column(name = "inventory_input_id", nullable = false)
    @JsonProperty("inventoryInput_id")
    private Integer inventory_input_id;

    //planDetail_id
    @Column(name = "plan_detail_id")
    @JsonProperty("planDetail_id")
    private Integer plan_detail_id;

    //productOwnerId
    @Column(name = "product_owner_id",nullable = false,
            columnDefinition = "integer default 0000000")
    @JsonProperty("productOwner_id")
    private Integer product_owner_id;

    //supplierId
    @Column(name = "supplier_id")
    @JsonProperty("supplierId")
    private Integer supplier_id;

    //productId
    @Column(name = "product_id", nullable = false)
    @JsonProperty("productId")
    private Integer product_id;

    //inputActualDate
    @Column(name = "input_actual_date",nullable = false)
    @JsonProperty("inputActualDate")
    private String input_actual_date;

    //repositoryId
    @Column(name = "repository_id", nullable = false)
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

    //cs_actual_quantity
    @Column(name = "cs_actual_quantity",
            columnDefinition = "integer default 0")
    @JsonProperty("cs_actual_quantity")
    private Integer cs_actual_quantity;

    //bl_actual_quantity
    @Column(name = "bl_actual_quantity",
            columnDefinition = "integer default 0")
    @JsonProperty("bl_actual_quantity")
    private Integer bl_actual_quantity;

    //ps_actual_quantity
    @Column(name = "ps_actual_quantity",
            columnDefinition = "integer default 0")
    @JsonProperty("ps_actual_quantity")
    private Integer ps_actual_quantity;

    //totalActualQuantity
    @Column(name = "total_actual_quantity")
    @JsonProperty("totalActualQuantity")
    private Integer total_actual_quantity;

    //inventoryProductType
    @Column(name = "inventory_product_type")
    @JsonProperty("inventoryProductType")
    private Integer inventory_product_type;

    //pack_cs_price
    @Column(name = "pack_cs_price",precision = 7,scale = 2)
    @JsonProperty("pack_cs_price")
    private Double pack_cs_price;

    //pack_bl_price
    @Column(name = "pack_bl_price",precision = 7,scale = 2)
    @JsonProperty("pack_bl_price")
    private Double pack_bl_price;

    //piecePrice
    @Column(name = "piece_price",precision = 7,scale = 2)
    @JsonProperty("piecePrice")
    private Double piece_price;

    //amountTotal
    @Column(name = "amount_total",precision = 19,scale = 2)
    @JsonProperty("amountTotal")
    private Double amount_total;

    //detailNote
    @Column(name = "detail_note")
    @JsonProperty("detailNote")
    private String detail_note;

    //correctionReason
    @Column(name = "correction_reason")
    @JsonProperty("correctionReason")
    private String correction_reason;

    //tax
    @Column(name = "tax",precision = 2,scale = 2)
    @JsonProperty("tax")
    private Double tax;

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

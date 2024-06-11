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
    @JsonProperty("actualDetailId")
    private Integer actualDetailId;

    //companyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    //inventoryInput_id
    @Column(name = "inventory_input_id", nullable = false)
    @JsonProperty("inventoryInputId")
    private Integer inventoryInputId;

    //planDetail_id
    @Column(name = "plan_detail_id")
    @JsonProperty("planDetailId")
    private Integer planDetailId;

    //productOwnerId
    @Column(name = "product_owner_id",nullable = false,
            columnDefinition = "integer default 0000000")
    @JsonProperty("productOwnerId")
    private Integer productOwnerId;

    //supplierId
    @Column(name = "supplier_id")
    @JsonProperty("supplierId")
    private Integer supplierId;

    //productId
    @Column(name = "product_id", nullable = false)
    @JsonProperty("productId")
    private Integer productId;

    //inputActualDate
    @Column(name = "input_actual_date",nullable = false)
    @JsonProperty("inputActualDate")
    private String inputActualDate;

    //repositoryId
    @Column(name = "repository_id", nullable = false)
    @JsonProperty("repositoryId")
    private Integer repositoryId;

    //locationId
    @Column(name = "location_id",nullable = false)
    @JsonProperty("locationId")
    private Integer locationId;

    //datetime_mng
    @Column(name = "datetime_mng")
    @JsonProperty("datetimeMng")
    private String datetimeMng;

    //number_mng
    @Column(name = "number_mng")
    @JsonProperty("numberMng")
    private String numberMng;

    //cs_actual_quantity
    @Column(name = "cs_actual_quantity",
            columnDefinition = "integer default 0")
    @JsonProperty("csActualQuantity")
    private Integer csActualQuantity;

    //bl_actual_quantity
    @Column(name = "bl_actual_quantity",
            columnDefinition = "integer default 0")
    @JsonProperty("blActualQuantity")
    private Integer blActualQuantity;

    //ps_actual_quantity
    @Column(name = "ps_actual_quantity",
            columnDefinition = "integer default 0")
    @JsonProperty("psActualQuantity")
    private Integer psActualQuantity;

    //totalActualQuantity
    @Column(name = "total_actual_quantity")
    @JsonProperty("totalActualQuantity")
    private Integer totalActualQuantity;

    //inventoryProductType
    @Column(name = "inventory_product_type")
    @JsonProperty("inventoryProductType")
    private Integer inventoryProductType;

    //pack_cs_price
    @Column(name = "pack_cs_price",precision = 7,scale = 2)
    @JsonProperty("packCsPrice")
    private Double packCsPrice;

    //pack_bl_price
    @Column(name = "pack_bl_price",precision = 7,scale = 2)
    @JsonProperty("packBlPrice")
    private Double packBlPrice;

    //piecePrice
    @Column(name = "piece_price",precision = 7,scale = 2)
    @JsonProperty("piecePrice")
    private Double piecePrice;

    //amountTotal
    @Column(name = "amount_total",precision = 19,scale = 2)
    @JsonProperty("amountTotal")
    private Double amountTotal;

    //detailNote
    @Column(name = "detail_note")
    @JsonProperty("detailNote")
    private String detailNote;

    //correctionReason
    @Column(name = "correction_reason")
    @JsonProperty("correctionReason")
    private String correctionReason;

    //tax
//    @Column(name = "tax",precision = 2,scale = 2)
//    @JsonProperty("tax")
//    private Double tax;

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

package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_inventory_plan_input_detail")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class InventoryPlanInputDetailEntity extends CommonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_detail_id")
    @JsonProperty("planDetail_id")
    private Integer plan_detail_id;

    //companyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer company_id;

    //inventoryInput_id
    @Column(name = "inventory_input_id", nullable = false)
    @JsonProperty("inventoryInput_id")
    private Integer inventory_input_id;

    //productId
    @Column(name = "product_id", nullable = false)
    @JsonProperty("productId")
    private Integer product_id;

    //repositoryId
    @Column(name = "repository_id", nullable = false)
    @JsonProperty("repositoryId")
    private Integer repository_id;

    //locationId
    @Column(name = "location_id")
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

    //cs_plan_quantity
    @Column(name = "cs_plan_quantity",
            columnDefinition = "integer default 0")
    @JsonProperty("cs_plan_quantity")
    private Integer cs_plan_quantity;

    //bl_plan_quantity
    @Column(name = "bl_plan_quantity",
            columnDefinition = "integer default 0")
    @JsonProperty("bl_plan_quantity")
    private Integer bl_plan_quantity;

    //ps_plan_quantity
    @Column(name = "ps_plan_quantity",
            columnDefinition = "integer default 0")
    @JsonProperty("ps_plan_quantity")
    private Integer ps_plan_quantity;

    //total_plan_quantity
    @Column(name = "total_plan_quantity",
            columnDefinition = "integer default 0")
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

    //plan_piece_price
    @Column(name = "plan_piece_price",precision = 7,scale = 2)
    @JsonProperty("plan_piece_price")
    private Double plan_piece_price;

    //planAmountTotal
    @Column(name = "plan_amount_total",precision = 19,scale = 2)
    @JsonProperty("planAmountTotal")
    private Double plan_amount_total;

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

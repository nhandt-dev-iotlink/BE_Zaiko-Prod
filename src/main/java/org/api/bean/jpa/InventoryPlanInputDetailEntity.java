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
    @JsonProperty("planDetailId")
    private Integer planDetailId;

    //companyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    //inventoryInput_id
    @Column(name = "inventory_input_id", nullable = false)
    @JsonProperty("inventoryInputId")
    private Integer inventoryInputId;

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

    //datetime_mng
    @Column(name = "datetime_mng")
    @JsonProperty("datetimeMng")
    private String datetimeMng;

    //number_mng
    @Column(name = "number_mng")
    @JsonProperty("numberMng")
    private String numberMng;

    //cs_plan_quantity
    @Column(name = "cs_plan_quantity",
            columnDefinition = "integer default 0")
    @JsonProperty("csPlanQuantity")
    private Integer csPlanQuantity;

    //bl_plan_quantity
    @Column(name = "bl_plan_quantity",
            columnDefinition = "integer default 0")
    @JsonProperty("blPlanQuantity")
    private Integer blPlanQuantity;

    //ps_plan_quantity
    @Column(name = "ps_plan_quantity",
            columnDefinition = "integer default 0")
    @JsonProperty("psPlanQuantity")
    private Integer psPlanQuantity;

    //total_plan_quantity
    @Column(name = "total_plan_quantity",
            columnDefinition = "integer default 0")
    @JsonProperty("totalPlanQuantity")
    private Integer totalPlanQuantity;

    //inventoryProductType
    @Column(name = "inventory_product_type")
    @JsonProperty("inventoryProductType")
    private Integer inventoryProductType;

    //detailNote
    @Column(name = "detail_note")
    @JsonProperty("detailNote")
    private String detailNote;

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

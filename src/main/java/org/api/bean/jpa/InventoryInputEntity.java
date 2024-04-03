package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_inventory_input")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class InventoryInputEntity extends CommonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_input_id")
    @JsonProperty("inventoryInput_id")
    private Integer inventory_input_id;

    //companyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer company_id;

    //inputPlanDate
    @Column(name = "input_plan_date")
    @JsonProperty("inputPlanDate")
    private String input_plan_date;

    //inputActualDate
    @Column(name = "input_actual_date")
    @JsonProperty("inputActualDate")
    private String input_actual_date;

    //createSlipType
    @Column(name = "create_slip_type",nullable = false)
    @JsonProperty("createSlipType")
    private Boolean create_slip_type;

    //slipNo
    @Column(name = "slip_no",nullable = false)
    @JsonProperty("slipNo")
    private String slip_no;

    //planSupplier_slip_no
    @Column(name = "plan_supplier_slip_no")
    @JsonProperty("planSupplier_slip_no")
    private String plan_supplier_slip_no;

    //actualSupplier_slip_no
    @Column(name = "actual_supplier_slip_no")
    @JsonProperty("actualSupplier_slip_no")
    private String actual_supplier_slip_no;

    //planSlipNote
    @Column(name = "plan_slip_note")
    @JsonProperty("planSlipNote")
    private String plan_slip_note;

    //actualSlipNote
    @Column(name = "actual_slip_note")
    @JsonProperty("actualSlipNote")
    private String actual_slip_note;

    //planSupplierDelivery_destination_id
    @Column(name = "plan_supplier_delivery_destination_id")
    @JsonProperty("planSupplierDelivery_destination_id")
    private String plan_supplier_delivery_destination_id;

    //actualSupplierDelivery_destination_id
    @Column(name = "actual_supplier_delivery_destination_id")
    @JsonProperty("actualSupplierDelivery_destination_id")
    private String actual_supplier_delivery_destination_id;

    //planSupplierId
    @Column(name = "plan_supplier_id")
    @JsonProperty("planSupplierId")
    private Integer plan_supplier_id;

    //actualSupplierId
    @Column(name = "actual_supplier_id")
    @JsonProperty("actualSupplierId")
    private Integer actual_supplier_id;

    //productOwnerId
    @Column(name = "product_owner_id",nullable = false,
            columnDefinition = "integer default 0000000")
    @JsonProperty("productOwner_id")
    private Integer product_owner_id;

    //planRepositoryId
    @Column(name = "plan_repository_id")
    @JsonProperty("planRepositoryId")
    private Integer plan_repository_id;

    //actualRepositoryId
    @Column(name = "actual_repository_id")
    @JsonProperty("actualRepositoryId")
    private Integer actual_repository_id;

    //inputStatus
    @Column(name = "input_status",nullable = false)
    @JsonProperty("inputStatus")
    private String input_status;

    //is_closed
    @Column(name = "is_closed",nullable = false)
    @JsonProperty("isClosed")
    private Boolean is_closed;

    //sumPlanQuantity
    @Column(name = "sum_plan_quantity",nullable = false)
    @JsonProperty("sumPlanQuantity")
    private Integer sum_plan_quantity;

    //sumActualQuantity
    @Column(name = "sum_actual_quantity",nullable = false)
    @JsonProperty("sumActualQuantity")
    private Integer sum_actual_quantity;

    //purchaseCategory
    @Column(name = "purchase_category",
            columnDefinition = "nvarchar(20) default '掛仕入'",
            nullable = false)
    @JsonProperty("purchaseCategory")
    private String purchase_category;

    //contactStatus
    @Column(name = "contact_status",
            columnDefinition = "nvarchar(20) default '未設定'")
    @JsonProperty("contactStatus")
    private String contact_status;

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

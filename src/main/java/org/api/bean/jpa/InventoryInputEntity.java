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
    private Integer inventoryInputId;

    //companyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    //inputPlanDate
    @Column(name = "input_plan_date")
    @JsonProperty("inputPlanDate")
    private String inputPlanDate;

    //inputActualDate
    @Column(name = "input_actual_date")
    @JsonProperty("inputActualDate")
    private String inputActualDate;

    //createSlipType
    @Column(name = "create_slip_type",nullable = false)
    @JsonProperty("createSlipType")
    private Boolean createSlipType;

    //slipNo
    @Column(name = "slip_no",nullable = false)
    @JsonProperty("slipNo")
    private String slipNo;

    //planSupplier_slip_no
    @Column(name = "plan_supplier_slip_no")
    @JsonProperty("planSupplier_slip_no")
    private String planSupplierSlipNo;

    //actualSupplier_slip_no
    @Column(name = "actual_supplier_slip_no")
    @JsonProperty("actualSupplier_slip_no")
    private String actualSupplierSlipNo;

    //planSlipNote
    @Column(name = "plan_slip_note")
    @JsonProperty("planSlipNote")
    private String planSlipNote;

    //actualSlipNote
    @Column(name = "actual_slip_note")
    @JsonProperty("actualSlipNote")
    private String actualSlipNote;

    //planSupplierDelivery_destination_id
    @Column(name = "plan_supplier_delivery_destination_id")
    @JsonProperty("planSupplierDelivery_destination_id")
    private String planSupplierDeliveryDestinationId;

    //actualSupplierDelivery_destination_id
    @Column(name = "actual_supplier_delivery_destination_id")
    @JsonProperty("actualSupplierDelivery_destination_id")
    private String actualSupplierDeliveryDestinationId;

    //planSupplierId
    @Column(name = "plan_supplier_id")
    @JsonProperty("planSupplierId")
    private Integer planSupplierId;

    //actualSupplierId
    @Column(name = "actual_supplier_id")
    @JsonProperty("actualSupplierId")
    private Integer actualSupplierId;

    //productOwnerId
    @Column(name = "product_owner_id",nullable = false,
            columnDefinition = "integer default 0000000")
    @JsonProperty("productOwnerId")
    private Integer productOwnerId;

    //planRepositoryId
    @Column(name = "plan_repository_id")
    @JsonProperty("planRepositoryId")
    private Integer planRepositoryId;

    //actualRepositoryId
    @Column(name = "actual_repository_id")
    @JsonProperty("actualRepositoryId")
    private Integer actualRepositoryId;

    //inputStatus
    @Column(name = "input_status",nullable = false)
    @JsonProperty("inputStatus")
    private String inputStatus;

    //is_closed
    @Column(name = "is_closed",nullable = false)
    @JsonProperty("isClosed")
    private String isClosed;

    //sumPlanQuantity
    @Column(name = "sum_plan_quantity",nullable = false)
    @JsonProperty("sumPlanQuantity")
    private Integer sumPlanQuantity;

    //sumActualQuantity
    @Column(name = "sum_actual_quantity",nullable = false)
    @JsonProperty("sumActualQuantity")
    private Integer sumActualQuantity;

    //purchaseCategory
    @Column(name = "purchase_category",
            columnDefinition = "nvarchar(20) default '掛仕入'",
            nullable = false)
    @JsonProperty("purchaseCategory")
    private String purchaseCategory;

    //contactStatus
    @Column(name = "contact_status",
            columnDefinition = "nvarchar(20) default '未設定'")
    @JsonProperty("contactStatus")
    private String contactStatus;

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

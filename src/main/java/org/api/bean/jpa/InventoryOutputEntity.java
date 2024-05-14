package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_inventory_output")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class InventoryOutputEntity extends CommonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_output_id")
    @JsonProperty("inventoryOutput_id")
    private Integer inventoryOutputId;

    //companyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    //planCustomerDeliveryDestination_id
    @Column(name = "plan_customer_delivery_destination_id")
    @JsonProperty("planCustomerDeliveryDestination_id")
    private Integer planCustomerDeliveryDestinationId;

    //actualCustomerDeliveryDestination_id
    @Column(name = "actual_customer_delivery_destination_id")
    @JsonProperty("actualCustomerDeliveryDestination_id")
    private Integer actualCustomerDeliveryDestinationId;

    //deliverDestinationName
    @Column(name = "deliver_destination_name")
    @JsonProperty("deliverDestinationName")
    private String deliverDestinationName;

    //postCode
    @Column(name = "post_code")
    @JsonProperty("postCode")
    private String postCode;

    //phoneNumber
    @Column(name = "phone_number")
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    //faxNumber
    @Column(name = "fax_number")
    @JsonProperty("faxNumber")
    private String faxNumber;

    //address1
    @Column(name = "address1")
    @JsonProperty("address1")
    private String address1;

    //address2
    @Column(name = "address2")
    @JsonProperty("address2")
    private String address2;

    //address3
    @Column(name = "address3")
    @JsonProperty("address3")
    private String address3;

    //address4
    @Column(name = "address4")
    @JsonProperty("address4")
    private String address4;

    //routeCode
    @Column(name = "route_code")
    @JsonProperty("routeCode")
    private String routeCode;

    //courseCode
    @Column(name = "course_code")
    @JsonProperty("courseCode")
    private String courseCode;

    //planCustomer_id
    @Column(name = "plan_customer_id")
    @JsonProperty("planCustomer_id")
    private Integer planCustomerId;

    //actualCustomer_id
    @Column(name = "actual_customer_id")
    @JsonProperty("actualCustomer_id")
    private Integer actualCustomerId;

    //orderDate
    @Column(name = "order_date")
    @JsonProperty("orderDate")
    private String orderDate;

    //planOutputDate
    @Column(name = "plan_output_date")
    @JsonProperty("planOutputDate")
    private String planOutputDate;

    //planWorkingDate
    @Column(name = "plan_working_date")
    @JsonProperty("planWorkingDate")
    private String planWorkingDate;

    //planDeliverDate
    @Column(name = "plan_deliver_date")
    @JsonProperty("planDeliverDate")
    private String planDeliverDate;

    //actualOutputDate
    @Column(name = "actual_output_date")
    @JsonProperty("actualOutputDate")
    private String actualOutputDate;

    //actualDeliverDate
    @Column(name = "actual_deliver_date")
    @JsonProperty("actualDeliverDate")
    private String actualDeliverDate;

    //planSupplierSlipNo
    @Column(name = "plan_supplier_slip_no")
    @JsonProperty("planSupplierSlipNo")
    private String planSupplierSlipNo;

    //actualSupplierSlipNo
    @Column(name = "actual_supplier_slip_no")
    @JsonProperty("actualSupplierSlipNo")
    private String actualSupplierSlipNo;

    //create_slip_type
    @Column(name = "create_slip_type",nullable = false)
    @JsonProperty("create_slip_type")
    private String createSlipType;

    //slipNo
    @Column(name = "slip_no",nullable = false)
    @JsonProperty("slipNo")
    private String slipNo;

    //slipNote
    @Column(name = "slip_note")
    @JsonProperty("slipNote")
    private String slipNote;

    //planRepository_id
    @Column(name = "plan_repository_id")
    @JsonProperty("planRepository_id")
    private Integer planRepositoryId;

    //actualRepository_id
    @Column(name = "actual_repository_id")
    @JsonProperty("actualRepository_id")
    private Integer actualRepositoryId;

    //batchStatus
    @Column(name = "batch_status")
    @JsonProperty("batchStatus")
    private String batchStatus;

    //outputStatus
    @Column(name = "output_status")
    @JsonProperty("outputStatus")
    private String outputStatus;

    //isClosed
    @Column(name = "is_closed",
            columnDefinition = "varchar(50) default '未クローズ'")
    @JsonProperty("isClosed")
    private String isClosed;

    //sumPlanQuantity
    @Column(name = "sum_plan_quantity")
    @JsonProperty("sumPlanQuantity")
    private Integer sumPlanQuantity;

    //sumActualQuantity
    @Column(name = "sum_actual_quantity")
    @JsonProperty("sumActualQuantity")
    private Integer sumActualQuantity;

    //newDestinationName
    @Column(name = "new_destination_name")
    @JsonProperty("newDestinationName")
    private String newDestinationName;

    //checked
    @Column(name = "checked")
    @JsonProperty("checked")
    private Boolean checked;

    //saleCategory
    @Column(name = "sale_category",
            columnDefinition = "varchar(50) default '掛売上'")
    @JsonProperty("saleCategory")
    private String saleCategory;

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

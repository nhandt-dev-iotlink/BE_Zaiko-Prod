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
    private Integer inventory_output_id;

    //companyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer company_id;

    //planCustomerDeliveryDestination_id
    @Column(name = "plan_customer_delivery_destination_id")
    @JsonProperty("planCustomerDeliveryDestination_id")
    private Integer plan_customer_delivery_destination_id;

    //actualCustomerDeliveryDestination_id
    @Column(name = "actual_customer_delivery_destination_id")
    @JsonProperty("actualCustomerDeliveryDestination_id")
    private Integer actual_customer_delivery_destination_id;

    //deliverDestinationName
    @Column(name = "deliver_destination_name")
    @JsonProperty("deliverDestinationName")
    private String deliver_destination_name;

    //postCode
    @Column(name = "post_code")
    @JsonProperty("postCode")
    private String post_code;

    //phoneNumber
    @Column(name = "phone_number")
    @JsonProperty("phoneNumber")
    private String phone_number;

    //faxNumber
    @Column(name = "fax_number")
    @JsonProperty("faxNumber")
    private String fax_number;

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
    private String route_code;

    //courseCode
    @Column(name = "course_code")
    @JsonProperty("courseCode")
    private String course_code;

    //planCustomer_id
    @Column(name = "plan_customer_id")
    @JsonProperty("planCustomer_id")
    private Integer plan_customer_id;

    //actualCustomer_id
    @Column(name = "actual_customer_id")
    @JsonProperty("actualCustomer_id")
    private Integer actual_customer_id;

    //orderDate
    @Column(name = "order_date")
    @JsonProperty("orderDate")
    private String order_date;

    //planOutputDate
    @Column(name = "plan_output_date")
    @JsonProperty("planOutputDate")
    private String plan_output_date;

    //planWorkingDate
    @Column(name = "plan_working_date")
    @JsonProperty("planWorkingDate")
    private String plan_working_date;

    //planDeliverDate
    @Column(name = "plan_deliver_date")
    @JsonProperty("planDeliverDate")
    private String plan_deliver_date;

    //actualOutputDate
    @Column(name = "actual_output_date")
    @JsonProperty("actualOutputDate")
    private String actual_output_date;

    //actualDeliverDate
    @Column(name = "actual_deliver_date")
    @JsonProperty("actualDeliverDate")
    private String actual_deliver_date;

    //planSupplierSlipNo
    @Column(name = "plan_supplier_slip_no")
    @JsonProperty("planSupplierSlipNo")
    private String plan_supplier_slip_no;

    //actualSupplierSlipNo
    @Column(name = "actual_supplier_slip_no")
    @JsonProperty("actualSupplierSlipNo")
    private String actual_supplier_slip_no;

    //create_slip_type
    @Column(name = "create_slip_type",nullable = false)
    @JsonProperty("create_slip_type")
    private String create_slip_type;

    //slipNo
    @Column(name = "slip_no",nullable = false)
    @JsonProperty("slipNo")
    private String slip_no;

    //slipNote
    @Column(name = "slip_note")
    @JsonProperty("slipNote")
    private String slip_note;

    //planRepository_id
    @Column(name = "plan_repository_id")
    @JsonProperty("planRepository_id")
    private Integer plan_repository_id;

    //actualRepository_id
    @Column(name = "actual_repository_id")
    @JsonProperty("actualRepository_id")
    private Integer actual_repository_id;

    //batchStatus
    @Column(name = "batch_status")
    @JsonProperty("batchStatus")
    private String batch_status;

    //outputStatus
    @Column(name = "output_status")
    @JsonProperty("outputStatus")
    private String output_status;

    //isClosed
    @Column(name = "is_closed",
            columnDefinition = "varchar(50) default '未クローズ'")
    @JsonProperty("isClosed")
    private String is_closed;

    //sumPlanQuantity
    @Column(name = "sum_plan_quantity")
    @JsonProperty("sumPlanQuantity")
    private Integer sum_plan_quantity;

    //sumActualQuantity
    @Column(name = "sum_actual_quantity")
    @JsonProperty("sumActualQuantity")
    private Integer sum_actual_quantity;

    //newDestinationName
    @Column(name = "new_destination_name")
    @JsonProperty("newDestinationName")
    private String new_destination_name;

    //checked
    @Column(name = "checked")
    @JsonProperty("checked")
    private Boolean checked;

    //saleCategory
    @Column(name = "sale_category",
            columnDefinition = "varchar(50) default '掛売上'")
    @JsonProperty("saleCategory")
    private String sale_category;

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

package org.api.bean.reponse.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryOutputDTO {

    @JsonProperty("inventoryOutputId")
    private Integer inventory_output_id;


    @JsonProperty("companyId")
    private Integer company_id;

    @JsonProperty("planCustomerDeliveryDestinationId")
    private Integer plan_customer_delivery_destination_id;


    @JsonProperty("actualCustomerDeliveryDestinationId")
    private Integer actual_customer_delivery_destination_id;


    @JsonProperty("deliverDestinationName")
    private String deliver_destination_name;


    @JsonProperty("postCode")
    private String post_code;

    @JsonProperty("phoneNumber")
    private String phone_number;


    @JsonProperty("faxNumber")
    private String fax_number;


    @JsonProperty("address1")
    private String address1;


    @JsonProperty("address2")
    private String address2;


    @JsonProperty("address3")
    private String address3;

    @JsonProperty("address4")
    private String address4;


    @JsonProperty("routeCode")
    private String route_code;


    @JsonProperty("courseCode")
    private String course_code;

    @JsonProperty("planCustomerId")
    private Integer plan_customer_id;

    @JsonProperty("actualCustomerId")
    private Integer actual_customer_id;

    @JsonProperty("orderDate")
    private String order_date;

    @JsonProperty("planOutputDate")
    private String plan_output_date;


    @JsonProperty("planWorkingDate")
    private String plan_working_date;


    @JsonProperty("planDeliverDate")
    private String plan_deliver_date;


    @JsonProperty("actualOutputDate")
    private String actual_output_date;


    @JsonProperty("actualDeliverDate")
    private String actual_deliver_date;


    @JsonProperty("planSupplierSlipNo")
    private String plan_supplier_slip_no;


    @JsonProperty("actualSupplierSlipNo")
    private String actual_supplier_slip_no;

    //create_slip_type

    @JsonProperty("createSlipType")
    private String create_slip_type;

    //slipNo
    @JsonProperty("slipNo")
    private String slip_no;

    @JsonProperty("slipNote")
    private String slip_note;


    @JsonProperty("planRepositoryId")
    private Integer plan_repository_id;

    @JsonProperty("actualRepositoryId")
    private Integer actual_repository_id;

    //batchStatus

    @JsonProperty("batchStatus")
    private String batch_status;


    @JsonProperty("outputStatus")
    private String output_status;

    @JsonProperty("isClosed")
    private String is_closed;

    @JsonProperty("sumPlanQuantity")
    private Integer sum_plan_quantity;


    @JsonProperty("sumActualQuantity")
    private Integer sum_actual_quantity;


    @JsonProperty("newDestinationName")
    private String new_destination_name;


    @JsonProperty("checked")
    private String checked;


    @JsonProperty("saleCategory")
    private String sale_category;

    private String  departmentName;

    private String  customerName;

    private String  planSlipNote;
}

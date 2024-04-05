package org.api.bean.jpa;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name ="t_expense")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class ExpenseEntity extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_id")
    @JsonProperty("expenseId")
    private Integer expenseId;

    @JsonProperty("companyId")
    @Column(name = "company_id", length = 4, nullable = false)
    private Integer companyId;

    @JsonProperty("inventoryOutputId")
    @Column(name = "inventory_output_id", length = 10)
    private Integer inventoryOutputId;

    @JsonProperty("orderDate")
    @Column(name = "order_date", length = 10)
    private String orderDate;

    @JsonProperty("outputDate")
    @Column(name = "output_date", length = 10)
    private String outputDate;

    @JsonProperty("workingDate")
    @Column(name = "working_date", length = 10)
    private String workingDate;

    @JsonProperty("deliverDate")
    @Column(name = "deliver_date", length = 10)
    private String deliverDate;

    @JsonProperty("createSlipType")
    @Column(name = "create_slip_type", length = 1, nullable = false)
    private String createSlipType;

    @JsonProperty("slipNo")
    @Column(name = "slip_no", length = 20, nullable = false)
    private String slipNo;

    @JsonProperty("supplierSlipNo")
    @Column(name = "supplier_slip_no", length = 20)
    private String supplierSlipNo;

    @JsonProperty("slipNotes")
    @Column(name = "slip_notes", length = 200)
    private String slipNotes;

    @JsonProperty("customerId")
    @Column(name = "customer_id", length = 7, nullable = false)
    private Integer customerId;

    @JsonProperty("customerDeliveryDestinationId")
    @Column(name = "customer_delivery_destination_id", length = 7)
    private Integer customerDeliveryDestinationId;

    @JsonProperty("repositoryId")
    @Column(name = "repository_id", length = 7, nullable = false)
    private Integer repositoryId;

    @JsonProperty("expenseSlipPrintStatus")
    @Column(name = "expense_slip_print_status", length = 1)
    private Integer expenseSlipPrintStatus;

    @JsonProperty("destinationCode")
    @Column(name = "destination_code", length = 6)
    private String destinationCode;

    @JsonProperty("departmentName")
    @Column(name = "department_name", length = 100)
    private String departmentName;

    @JsonProperty("postCode")
    @Column(name = "post_code", length = 8)
    private String postCode;

    @JsonProperty("phoneNumber")
    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @JsonProperty("faxNumber")
    @Column(name = "fax_number", length = 15)
    private String faxNumber;

    @JsonProperty("address1")
    @Column(name = "address1", length = 50)
    private String address1;

    @JsonProperty("address2")
    @Column(name = "address2", length = 50)
    private String address2;

    @JsonProperty("address3")
    @Column(name = "address3", length = 50)
    private String address3;

    @JsonProperty("address4")
    @Column(name = "address4", length = 50)
    private String address4;

    @JsonProperty("routeCode")
    @Column(name = "route_code", length = 3)
    private String routeCode;

    @JsonProperty("courseCode")
    @Column(name = "course_code", length = 2)
    private String courseCode;

    @JsonProperty("saleCategory")
    @Column(name = "sale_category")
    private String saleCategory;

    @JsonProperty("freeItem1")
    @Column(name = "free_item1", length = 100)
    private String freeItem1;

    @JsonProperty("freeItem2")
    @Column(name = "free_item2", length = 100)
    private String freeItem2;

    @JsonProperty("freeItem3")
    @Column(name = "free_item3", length = 100)
    private String freeItem3;

    @JsonProperty("deliverySlip_id")
    @Column(name = "delivery_slip_id")
    private Integer deliverySlip_id;

}

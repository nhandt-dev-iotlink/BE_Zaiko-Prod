package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "m_customer_delivery_dest")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class CustomerDeliveryDestEntity extends CommonEntity{
    // Delivery Destination ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_destination_id")
    @JsonProperty("deliveryDestination_id")
    private Integer deliveryDestination_id;

    // CompanyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    //Customer ID
    @Column(name = "customer_id", nullable = false)
    @JsonProperty("customerId")
    private Integer customerId;

    //Is Customer
    @Column(name = "is_customer")
    @JsonProperty("isCustomer")
    private String isCustomer;

    //Destination Code
    @Column(name = "destination_code", nullable = false)
    @JsonProperty("destinationCode")
    private String destinatonCode;

    //Deparment Name
    @Column(name = "department_name", nullable = false)
    @JsonProperty("departmentName")
    private String departmentName;

    //Pic Name
    @Column(name = "pic_name")
    @JsonProperty("picName")
    private Integer picName;

    //Phone Number
    @Column(name = "phone_number", nullable = false)
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    //Fax Number
    @Column(name = "fax_number")
    @JsonProperty("faxNumber")
    private String faxNumber;

    //Post Code
    @Column(name = "post_code", nullable = false)
    @JsonProperty("postCode")
    private String postCode1;

    //Address 1
    @Column(name = "address1", nullable = false)
    @JsonProperty("address1")
    private String address1;

    //Address 2
    @Column(name = "address2")
    @JsonProperty("address2")
    private String address2;

    //Address 3
    @Column(name = "address3")
    @JsonProperty("address3")
    private String address3;

    //Address 4
    @Column(name = "address4")
    @JsonProperty("address4")
    private String address4;

    //Lead Time
    @Column(name = "lead_time")
    @JsonProperty("leadTime")
    private Integer leadTime;

    //Route Code
    @Column(name = "route_code")
    @JsonProperty("routeCode")
    private String routeCode;

    //Course Code
    @Column(name = "course_code")
    @JsonProperty("courseCode")
    private String courseCode;

    //Output Priority Rank
    @Column(name = "output_priority_rank")
    @JsonProperty("outputPriorityRank")
    private Integer outputPriorityRank = 1;

    // FreeItem1
    @Column(name = "free_item1")
    @JsonProperty("freeItem1")
    private String freeItem1;

    // FreeItem2
    @Column(name = "free_item2")
    @JsonProperty("freeItem2")
    private String freeItem2;

    // FreeItem3
    @Column(name = "free_item3")
    @JsonProperty("freeItem3")
    private String freeItem3;

    //Notes
    @Column(name = "notes")
    @JsonProperty("notes")
    private String notes;

}

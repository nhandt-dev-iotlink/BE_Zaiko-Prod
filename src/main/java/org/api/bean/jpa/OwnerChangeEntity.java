package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "t_owner_change")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class OwnerChangeEntity extends CommonEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // Owner Change ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_change_id")
    @JsonProperty("ownerChangeId")
    private Integer ownerChangeId;

    // Company ID
    @Column(name = "company_id")
    @JsonProperty("companyId")
    private Integer companyId;

    // Delivery Date
    @Column(name = "deliver_date")
    @JsonProperty("deliverDate")
    private String deliverDate;

    // Slip Number
    @Column(name = "slip_no")
    @JsonProperty("slipNo")
    private String slipNo;

    // Working Date
    @Column(name = "working_date")
    @JsonProperty("workingDate")
    private String workingDate;

    // Slip Note
    @Column(name = "slip_note")
    @JsonProperty("slipNote")
    private String slipNote;

    // New Product Owner ID
    @Column(name = "product_owner_new_id")
    @JsonProperty("productOwnerNewId")
    private String productOwnerNewId;

    // Old Product Owner ID
    @Column(name = "product_owner_old_id")
    @JsonProperty("productOwnerOldId")
    private String productOwnerOldId;

    // Customer ID
    @Column(name = "customer_id")
    @JsonProperty("customerId")
    private String customerId;

    // Delivery Slip Print Status
    @Column(name = "delivery_slip_print_status")
    @JsonProperty("deliverySlipPrintStatus")
    private String deliverySlipPrintStatus;

    // Create Slip Type
    @Column(name = "create_slip_type")
    @JsonProperty("createSlipType")
    private String createSlipType;

    // Free Item 1
    @Column(name = "free_item1")
    @JsonProperty("freeItem1")
    private String freeItem1;

    // Free Item 2
    @Column(name = "free_item2")
    @JsonProperty("freeItem2")
    private String freeItem2;

    // Free Item 3
    @Column(name = "free_item3")
    @JsonProperty("freeItem3")
    private String freeItem3;



}

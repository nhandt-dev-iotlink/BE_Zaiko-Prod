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
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    // Delivery Date
    @Column(name = "deliver_date", nullable = false, length = 10)
    @JsonProperty("deliverDate")
    private String deliverDate;

    // Slip Number
    @Column(name = "slip_no", length = 20)
    @JsonProperty("slipNo")
    private String slipNo;

    // Working Date
    @Column(name = "working_date", length = 10)
    @JsonProperty("workingDate")
    private String workingDate;

    // Slip Note
    @Column(name = "slip_note", length = 200)
    @JsonProperty("slipNote")
    private String slipNote;

    // New Product Owner ID
    @Column(name = "product_owner_new_id", length = 7)
    @JsonProperty("productOwnerNewId")
    private String productOwnerNewId;

    // Old Product Owner ID
    @Column(name = "product_owner_old_id", length = 7)
    @JsonProperty("productOwnerOldId")
    private String productOwnerOldId;

    // Customer ID
    @Column(name = "customer_id", length = 7)
    @JsonProperty("customerId")
    private String customerId;

    // Delivery Slip Print Status
    @Column(name = "delivery_slip_print_status", length = 1)
    @JsonProperty("deliverySlipPrintStatus")
    private String deliverySlipPrintStatus;

    // Create Slip Type
    @Column(name = "create_slip_type", length = 1)
    @JsonProperty("createSlipType")
    private String createSlipType;

    // Free Item 1
    @Column(name = "free_item1", length = 100)
    @JsonProperty("freeItem1")
    private String freeItem1;

    // Free Item 2
    @Column(name = "free_item2", length = 100)
    @JsonProperty("freeItem2")
    private String freeItem2;

    // Free Item 3
    @Column(name = "free_item3", length = 100)
    @JsonProperty("freeItem3")
    private String freeItem3;

    // Free Item 4
    @Column(name = "free_item4", length = 100)
    @JsonProperty("freeItem4")
    private String freeItem4;

    // Free Item 5
    @Column(name = "free_item5", length = 100)
    @JsonProperty("freeItem5")
    private String freeItem5;

    // Sale Category
    @Column(name = "sale_category", length = 1, nullable = false)
    @JsonProperty("saleCategory")
    private String saleCategory;



}

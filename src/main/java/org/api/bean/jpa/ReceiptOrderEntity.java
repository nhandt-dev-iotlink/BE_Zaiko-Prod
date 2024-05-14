package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "t_receipt_order")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class ReceiptOrderEntity extends CommonEntity {

    private static final long serialVersionUID = 1L;

    // ReceiptOrder ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receipt_order_id")
    @JsonProperty("receiptOrder_id")
    private Integer receiptOrder_id;

    // CompanyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    // OrderDate
    @Column(name = "order_date")
    @JsonProperty("orderDate")
    private String orderDate;

    // PlanDeliveryDate
    @Column(name = "plan_delivery_date")
    @JsonProperty("planDeliveryDate")
    private String planDeliveryDate;

    // RepositoryId
    @Column(name = "repository_id")
    @JsonProperty("repositoryId")
    private Integer repositoryId;

    // SupplierSlipNo
    @Column(name = "supplier_slip_no")
    @JsonProperty("supplierSlipNo")
    private String supplierSlipNo;

    // DestinationId
    @Column(name = "destination_id")
    @JsonProperty("destinationId")
    private Integer destinationId;

    // CustomerId
    @Column(name = "customer_id")
    @JsonProperty("customerId")
    private Integer customerId;

    // OrderStatus
    @Column(name = "order_status")
    @JsonProperty("orderStatus")
    private String orderStatus = "0";

    // SlipNotes
    @Column(name = "slip_notes")
    @JsonProperty("slipNotes")
    private String slipNotes;

    // PlanOuputSlipNo
    @Column(name = "plan_ouput_slip_no")
    @JsonProperty("planOuputSlipNo")
    private String planOuputSlipNo = "Null";

    // FileName
    @Column(name = "file_name")
    @JsonProperty("fileName")
    private String fileName;

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


}
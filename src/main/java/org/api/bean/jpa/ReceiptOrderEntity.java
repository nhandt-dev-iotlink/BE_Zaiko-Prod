package org.api.bean.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
    @JsonProperty("id")
    private Integer id;

    // CompanyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    // OrderDate
    @Column(name = "order_date", nullable = false)
    @JsonProperty("orderDate")
    private String orderDate;

    // PlanDeliveryDate
    @Column(name = "plan_delivery_date", nullable = false)
    @JsonProperty("planDeliveryDate")
    private String planDeliveryDate;

    // RepositoryId
    @Column(name = "repository_id", nullable = false)
    @JsonProperty("repositoryId")
    private Integer repositoryId;

    // SupplierSlipNo
    @Column(name = "supplier_slip_no", nullable = false)
    @JsonProperty("supplierSlipNo")
    private String supplierSlipNo;

    // DestinationId
    @Column(name = "destination_id", nullable = false)
    @JsonProperty("destinationId")
    private Integer destinationId;

    // CustomerId
    @Column(name = "customer_id", nullable = false)
    @JsonProperty("customerId")
    private Integer customerId;

    // OrderStatus
    @Column(name = "order_status", nullable = false)
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
    @Column(name = "file_name", nullable = false)
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
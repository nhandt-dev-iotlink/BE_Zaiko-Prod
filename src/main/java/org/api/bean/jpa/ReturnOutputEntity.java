package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;


@Entity
@Table(name = "t_return_output")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class ReturnOutputEntity extends CommonEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    //Id
    @Id
    @Column(name = "return_output_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long returnOutputId;
    @JsonProperty("company_id")
    @Column(name = "company_id", nullable = false)
    private Integer companyId;

    @JsonProperty("return_output_date")
    @Column(name = "return_output_date", length = 10)
    private String returnOutputDate;

    @JsonProperty("createSlipType")
    @Column(name = "create_slip_type", length = 1, nullable = false)
    private String createSlipType;

    @JsonProperty("slipNo")
    @Column(name = "slip_no", length = 20, nullable = false)
    private String slipNo;

    @JsonProperty("customerSlipNo")
    @Column(name = "customer_slip_no", length = 20)
    private String customerSlipNo;

    @JsonProperty("slipNotes")
    @Column(name = "slip_notes", length = 200)
    private String slipNotes;

    @JsonProperty("productOwnerId")
    @Column(name = "product_owner_id")
    private Long productOwnerId;

    @JsonProperty("supplierId")
    @Column(name = "supplier_id", nullable = false)
    private Long supplierId;

    @JsonProperty("supplier_delivery_destination_id")
    @Column(name = "supplier_delivery_destination_id", nullable = false)
    private Long supplierDeliveryDestinationId;

    @JsonProperty("repositoryId")
    @Column(name = "repository_id", nullable = false)
    private Long repositoryId;

    @JsonProperty("print_status")
    @Column(name = "print_status", length = 1, columnDefinition = "nvarchar(1) default '0'")
    private String printStatus;

    @JsonProperty("purchase_category")
    @Column(name = "purchase_category", length = 1, nullable = false)
    private String purchaseCategory;





}

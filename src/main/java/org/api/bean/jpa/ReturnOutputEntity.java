package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "t_return_output")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class ReturnOutputEntity extends CommonEntity {

    //Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "return_output_id")
    @JsonProperty("returnOutputId")
    private Long returnOutputId;

    @Column(name = "company_id")
    @JsonProperty("company_id")
    private Integer companyId;

    @Column(name = "return_output_date")
    @JsonProperty("return_output_date")
    private String returnOutputDate;

    @Column(name = "create_slip_type")
    @JsonProperty("createSlipType")
    private String createSlipType;

    @Column(name = "slip_no")
    @JsonProperty("slipNo")
    private String slipNo;

    @Column(name = "customer_slip_no")
    @JsonProperty("customerSlipNo")
    private String customerSlipNo;

    @Column(name = "slip_notes")
    @JsonProperty("slipNotes")
    private String slipNotes;

    @Column(name = "product_owner_id")
    @JsonProperty("productOwnerId")
    private Long productOwnerId;

    @Column(name = "supplier_id")
    @JsonProperty("supplierId")
    private Long supplierId;

    @Column(name = "supplier_delivery_destination_id")
    @JsonProperty("supplier_delivery_destination_id")
    private Long supplierDeliveryDestinationId;

    @Column(name = "repository_id")
    @JsonProperty("repositoryId")
    private Long repositoryId;

    @Column(name = "print_status")
    @JsonProperty("print_status")
    private String printStatus;
}

package org.api.bean.jpa;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "t_return_input")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class ReturnInputEntity extends CommonEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "return_input_id")
    @JsonProperty("returnInputId")
    private Long returnInputId;

    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    @Column(name = "return_input_date")
    @JsonProperty("returnInputDate")
    private String returnInputDate;

    @Column(name = "create_slip_type")
    @JsonProperty("createSlipType")
    private String createSlipType;

    @Column(name = "slip_no")
    @JsonProperty("slipNo")
    private String slipNo;

    @Column(name = "supplier_slip_no")
    @JsonProperty("supplierSlipNo")
    private String supplierSlipNo;

    @Column(name = "slip_notes")
    @JsonProperty("slipNotes")
    private String slipNotes;

    @Column(name = "product_owner_id")
    @JsonProperty("productOwnerId")
    private Long productOwnerId;

    @Column(name = "customer_id")
    @JsonProperty("customerId")
    private Long customerId;

    @Column(name = "customer_delivery_destination_id")
    @JsonProperty("customerDeliveryDestinationId")
    private Long customerDeliveryDestinationId;

    @Column(name = "new_destination_name")
    @JsonProperty("newDestinationName")
    private String newDestinationName;

    @Column(name = "post_code")
    @JsonProperty("postCode")
    private String postCode;

    @Column(name = "phone_number")
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @Column(name = "fax_number")
    @JsonProperty("faxNumber")
    private String faxNumber;

    @Column(name = "address1")
    @JsonProperty("address1")
    private String address1;

    @Column(name = "address2")
    @JsonProperty("address2")
    private String address2;

    @Column(name = "address3")
    @JsonProperty("address3")
    private String address3;

    @Column(name = "address4")
    @JsonProperty("address4")
    private String address4;

    @Column(name = "checked")
    @JsonProperty("checked")
    private String checked;

    @Column(name = "repository_id")
    @JsonProperty("repositoryId")
    private Long repositoryId;

    @Column(name = "delivery_slip_print_status")
    @JsonProperty("deliverySlipPrintStatus")
    private Integer deliverySlipPrintStatus;
}

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
    @JsonProperty("return_input_id")
    private Long returnInputId;

    @Column(name = "company_id", nullable = false)
    @JsonProperty("company_id")
    private Integer companyId;

    @Column(name = "return_input_date")
    @JsonProperty("return_input_date")
    private String returnInputDate;

    @Column(name = "create_slip_type")
    @JsonProperty("create_slip_type")
    private String createSlipType;

    @Column(name = "slip_no")
    @JsonProperty("slip_no")
    private String slipNo;

    @Column(name = "supplier_slip_no")
    @JsonProperty("supplier_slip_no")
    private String supplierSlipNo;

    @Column(name = "slip_notes")
    @JsonProperty("slip_notes")
    private String slipNotes;

    @Column(name = "product_owner_id")
    @JsonProperty("product_owner_id")
    private Long productOwnerId;

    @Column(name = "customer_id")
    @JsonProperty("customer_id")
    private Long customerId;

    @Column(name = "customer_delivery_destination_id")
    @JsonProperty("customer_delivery_destination_id")
    private Long customerDeliveryDestinationId;

    @Column(name = "new_destination_name")
    @JsonProperty("new_destination_name")
    private String newDestinationName;

    @Column(name = "post_code")
    @JsonProperty("post_code")
    private String postCode;

    @Column(name = "phone_number")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @Column(name = "fax_number")
    @JsonProperty("fax_number")
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
    @JsonProperty("repository_id")
    private Long repositoryId;

    @Column(name = "delivery_slip_print_status")
    @JsonProperty("delivery_slip_print_status")
    private Integer deliverySlipPrintStatus;
}

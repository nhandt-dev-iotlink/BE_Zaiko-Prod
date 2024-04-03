package org.api.bean.jpa;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

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

    @Column(name = "return_input_date", length = 10)
    @JsonProperty("return_input_date")
    private String returnInputDate;

    @Column(name = "create_slip_type", length = 1, nullable = false)
    @JsonProperty("create_slip_type")
    private String createSlipType;

    @Column(name = "slip_no", length = 20, nullable = false)
    @JsonProperty("slip_no")
    private String slipNo;

    @Column(name = "supplier_slip_no", length = 20)
    @JsonProperty("supplier_slip_no")
    private String supplierSlipNo;

    @Column(name = "slip_notes", length = 200)
    @JsonProperty("slip_notes")
    private String slipNotes;

    @Column(name = "product_owner_id", nullable = false, columnDefinition = "int(7) default 0000000")
    @JsonProperty("product_owner_id")
    private Long productOwnerId;

    @Column(name = "customer_id", nullable = false, columnDefinition = "int(7) default 0")
    @JsonProperty("customer_id")
    private Long customerId;

    @Column(name = "customer_delivery_destination_id", nullable = false, columnDefinition = "int(7) default 0")
    @JsonProperty("customer_delivery_destination_id")
    private Long customerDeliveryDestinationId;

    @Column(name = "new_destination_name", length = 100)
    @JsonProperty("new_destination_name")
    private String newDestinationName;

    @Column(name = "post_code", length = 8)
    @JsonProperty("post_code")
    private String postCode;

    @Column(name = "phone_number", length = 15)
    @JsonProperty("phone_number")
    private String phoneNumber;

    @Column(name = "fax_number", length = 15)
    @JsonProperty("fax_number")
    private String faxNumber;

    @Column(name = "address1", length = 50)
    @JsonProperty("address1")
    private String address1;

    @Column(name = "address2", length = 50)
    @JsonProperty("address2")
    private String address2;

    @Column(name = "address3", length = 50)
    @JsonProperty("address3")
    private String address3;

    @Column(name = "address4", length = 50)
    @JsonProperty("address4")
    private String address4;

    @Column(name = "checked", length = 1)
    @JsonProperty("checked")
    private String checked;

    @Column(name = "repository_id", nullable = false)
    @JsonProperty("repository_id")
    private Long repositoryId;

    @Column(name = "delivery_slip_print_status", columnDefinition = "int default 0")
    @JsonProperty("delivery_slip_print_status")
    private Integer deliverySlipPrintStatus;

    @Column(name = "sale_category", length = 1, nullable = false)
    @JsonProperty("sale_category")
    private String saleCategory;



}

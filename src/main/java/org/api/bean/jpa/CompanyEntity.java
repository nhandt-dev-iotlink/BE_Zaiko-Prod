package org.api.bean.jpa;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "m_company")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class CompanyEntity extends CommonEntity {

    // Company ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Integer id;

    //Company Name
    @Column(name = "company_name", nullable = false)
    @JsonProperty("companyName")
    private String companyName;

    //Phone Number 1
    @Column(name = "phone_number1", nullable = false)
    @JsonProperty("phoneNumber1")
    private String phoneNumber1;

    //Fax Number 1
    @Column(name = "fax_number1")
    @JsonProperty("faxNumber1")
    private String faxNumber1;

    //Post Code 1
    @Column(name = "post_code1", nullable = false)
    @JsonProperty("postCode1")
    private String postCode1;

    //Address 1_1
    @Column(name = "address1_1", nullable = false)
    @JsonProperty("address1_1")
    private String address1_1;

    //Address 1_2
    @Column(name = "address1_2", nullable = false)
    @JsonProperty("address1_2")
    private String address1_2;

    //Address 1_3
    @Column(name = "address1_3", nullable = false)
    @JsonProperty("address1_3")
    private String address1_3;

    //Address 1_4
    @Column(name = "address1_4", nullable = false)
    @JsonProperty("address1_4")
    private String address1_4;

    //Phone Number 2
    @Column(name = "phone_number2")
    @JsonProperty("phoneNumber2")
    private String phoneNumber2;

    //Fax Number 2
    @Column(name = "fax_number2")
    @JsonProperty("faxNumber2")
    private String faxNumber2;

    //Post Code 2
    @Column(name = "post_code2")
    @JsonProperty("postCode2")
    private String postCode2;

    //Address 2_1
    @Column(name = "address2_1")
    @JsonProperty("address2_1")
    private String address2_1;

    //Address 2_2
    @Column(name = "address2_2")
    @JsonProperty("address2_2")
    private String address2_2;

    //Address 2_3
    @Column(name = "address2_3")
    @JsonProperty("address2_3")
    private String address2_3;

    //Address 2_4
    @Column(name = "address2_4")
    @JsonProperty("address2_4")
    private String address2_4;

    //Bank Name
    @Column(name = "bank_name")
    @JsonProperty("bankName")
    private String bankName;

    //Bank Branch Name
    @Column(name = "bank_branch_name")
    @JsonProperty("bankBranchName")
    private String bankBranchName;

    //Bank Acc Number
    @Column(name = "bank_acc_number")
    @JsonProperty("bankAccNumber")
    private String bankAccNumber;

    //Bank Acc Holder
    @Column(name = "bank_acc_holder")
    @JsonProperty("bankAccHolder")
    private String bankAccHolder;

    //Note
    @Column(name = "note")
    @JsonProperty("note")
    private String note;

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

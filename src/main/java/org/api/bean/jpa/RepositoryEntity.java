package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "m_repository")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class RepositoryEntity extends CommonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repository_id", nullable = false)
    @JsonProperty("repositoryId")
    private Integer repository_id;

    //company_id
    @Column(name = "company_id",
            nullable = false)
    @JsonProperty("companyId")
    private Integer company_id;

    //repository_code
    @Column(name = "repository_code")
    @JsonProperty("repositoryCode")
    private String repository_code;

    //repository_name
    @Column(name = "repository_name")
    @JsonProperty("repositoryName")
    private String repository_name;

    //phone_number1
    @Column(name = "phone_number1")
    @JsonProperty("phoneNumber1")
    private String phone_number1;

    //fax_number1
    @Column(name = "fax_number1")
    @JsonProperty("fax_number1")
    private String fax_number1;

    //post_code1
    @Column(name = "post_code1")
    @JsonProperty("postCode1")
    private String post_code1;

    //address1_1
    @Column(name = "address1_1")
    @JsonProperty("address1_1")
    private String address1_1;

    //address1_2
    @Column(name = "address1_2")
    @JsonProperty("address1_2")
    private String address1_2;

    //address1_3
    @Column(name = "address1_3")
    @JsonProperty("address1_3")
    private String address1_3;

    //address1_4
    @Column(name = "address1_4")
    @JsonProperty("address1_4")
    private String address1_4;

    //phone_number2
    @Column(name = "phone_number2")
    @JsonProperty("phoneNumber2")
    private String phone_number2;

    //fax_number2
    @Column(name = "fax_number2")
    @JsonProperty("faxNumber2")
    private String fax_number2;

    //post_code2
    @Column(name = "post_code2")
    @JsonProperty("postCode2")
    private String post_code2;

    //address2_1
    @Column(name = "address2_1")
    @JsonProperty("address2_1")
    private String address2_1;

    //address2_2
    @Column(name = "address2_2")
    @JsonProperty("address2_2")
    private String address2_2;

    //address2_3
    @Column(name = "address2_3")
    @JsonProperty("address2_3")
    private String address2_3;

    //address2_4
    @Column(name = "address2_4")
    @JsonProperty("address2_4")
    private String address2_4;

    //notes
    @Column(name = "notes")
    @JsonProperty("notes")
    private String notes;

    //free_item1
    @Column(name = "free_item1")
    @JsonProperty("free_item1")
    private String free_item1;

    //free_item2
    @Column(name = "free_item2")
    @JsonProperty("free_item2")
    private String free_item2;

    //free_item3
    @Column(name = "free_item3")
    @JsonProperty("free_item3")
    private String free_item3;
}

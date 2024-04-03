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
@Table(name = "t_stocktaking")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class Stocktaking extends CommonEntity {

    private static final long serialVersionUID = 1L;

    // Stocktaking ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Integer id;

    // CompanyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    // InstructionNo
    @Column(name = "instruction_no", nullable = false)
    @JsonProperty("instructionNo")
    private String instructionNo;

    // RepositoryId
    @Column(name = "repository_id", nullable = false)
    @JsonProperty("repositoryId")
    private Integer repositoryId;

    // LocationIdFrom
    @Column(name = "location_id_from")
    @JsonProperty("locationIdFrom")
    private Integer locationIdFrom;

    // LocationIdTo
    @Column(name = "location_id_to")
    @JsonProperty("locationIdTo")
    private Integer locationIdTo;

    // ProductOwnerID
    @Column(name = "product_owner_id")
    @JsonProperty("productOwnerID")
    private Integer productOwnerID;

    // ProductId
    @Column(name = "product_id")
    @JsonProperty("productId")
    private Integer productId;

    // CategoryCode1
    @Column(name = "category_code_1")
    @JsonProperty("categoryCode1")
    private String categoryCode1;

    // CategoryCode2
    @Column(name = "category_code_2")
    @JsonProperty("categoryCode2")
    private String categoryCode2;

    // CategoryCode3
    @Column(name = "category_code_3")
    @JsonProperty("categoryCode3")
    private String categoryCode3;

    // CategoryCode4
    @Column(name = "category_code_4")
    @JsonProperty("categoryCode4")
    private String categoryCode4;

    // CategoryCode5
    @Column(name = "category_code_5")
    @JsonProperty("categoryCode5")
    private String categoryCode5;

    // Remarks
    @Column(name = "remarks")
    @JsonProperty("remarks")
    private String remarks;

    // Status
    @Column(name = "status", nullable = false)
    @JsonProperty("status")
    private String status = "1";


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
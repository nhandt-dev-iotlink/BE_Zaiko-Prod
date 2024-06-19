package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "t_stocktaking")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class StocktakingEntity extends CommonEntity {

    // Stocktaking ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stocktaking_id")
    @JsonProperty("stocktakingId")
    private Integer stocktakingId;

    // CompanyId
    @Column(name = "company_id")
    @JsonProperty("companyId")
    private Integer companyId;

    // InstructionNo
    @Column(name = "instruction_no")
    @JsonProperty("instructionNo")
    private String instructionNo;

    // RepositoryId
    @Column(name = "repository_id")
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

    // Remarks
    @Column(name = "remarks")
    @JsonProperty("remarks")
    private String remarks;

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

    // Status
    @Column(name = "status")
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
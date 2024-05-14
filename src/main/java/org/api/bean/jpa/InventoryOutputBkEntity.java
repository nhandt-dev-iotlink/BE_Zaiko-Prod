package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "t_inventory_output_bk")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class InventoryOutputBkEntity extends CommonEntity {

    private static final long serialVersionUID = 1L;

    // InventoryOutputBk ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_output_bk_id")
    @JsonProperty("inventoryOutput_bk_id")
    private int inventoryOutput_bk_id;

    // InventoryOuputId
    @Column(name = "inventory_output_id", nullable = false)
    @JsonProperty("inventoryOutputId")
    private Integer inventoryOutputId;

    // CompanyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    // ChangeDate
    @Column(name = "change_date")
    @JsonProperty("changeDate")
    private String changeDate;

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

    // FreeItem4
    @Column(name = "free_item4")
    @JsonProperty("freeItem4")
    private String freeItem4;

    // FreeItem5
    @Column(name = "free_item5")
    @JsonProperty("freeItem5")
    private String freeItem5;


}
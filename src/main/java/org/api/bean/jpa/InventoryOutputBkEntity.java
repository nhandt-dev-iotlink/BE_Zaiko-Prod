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
@Table(name = "t_inventory_output_bk")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class InventoryOutputBkEntity extends CommonEntity {

    private static final long serialVersionUID = 1L;

    // InventoryOutputBkId
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_output_bk_id")
    @JsonProperty("id")
    private int id;

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
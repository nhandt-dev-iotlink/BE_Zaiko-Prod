package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "t_inventory_input_bk")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class InventoryInputBkEntity extends CommonEntity {

    private static final long serialVersionUID = 1L;

    // InventoryInputBk ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_input_bk_id")
    @JsonProperty("inventoryInput_bk_id")
    private Integer inventoryInput_bk_id;

    // InventoryInputId
    @Column(name = "inventory_input_id", nullable = false)
    @JsonProperty("inventoryInputId")
    private Integer inventoryInputId;

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
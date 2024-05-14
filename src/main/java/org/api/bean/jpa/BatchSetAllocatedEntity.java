package org.api.bean.jpa;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "t_batch_set_allocated")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class BatchSetAllocatedEntity extends CommonEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    // Batch Set Allocated ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "batch_set_allocated_id")
    @JsonProperty("batchSetAllocatedId")
    private Integer batchSetAllocatedId;

    // Company ID
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    // Batch Detail ID
    @Column(name = "batch_detail_id", nullable = false)
    @JsonProperty("batchDetailId")
    private Integer batchDetailId;

    // Inventory ID
    @Column(name = "inventory_id", nullable = false)
    @JsonProperty("inventoryId")
    private Integer inventoryId;

    // CS Quantity
    @Column(name = "cs_quantity")
    @JsonProperty("csQuantity")
    private Integer csQuantity = 0;

    // BL Quantity
    @Column(name = "bl_quantity")
    @JsonProperty("blQuantity")
    private Integer blQuantity = 0;

    // PS Quantity
    @Column(name = "ps_quantity", nullable = false)
    @JsonProperty("psQuantity")
    private Integer psQuantity = 0;

    // Set Quantity
    @Column(name = "set_quantity")
    @JsonProperty("setQuantity")
    private Integer setQuantity;

    // Constituent Quantity
    @Column(name = "constituent_quantity")
    @JsonProperty("constituentQuantity")
    private Integer constituentQuantity;

    // Free Item 1
    @Column(name = "free_item1", length = 100)
    @JsonProperty("freeItem1")
    private String freeItem1;

    // Free Item 2
    @Column(name = "free_item2", length = 100)
    @JsonProperty("freeItem2")
    private String freeItem2;

    // Free Item 3
    @Column(name = "free_item3", length = 100)
    @JsonProperty("freeItem3")
    private String freeItem3;


}

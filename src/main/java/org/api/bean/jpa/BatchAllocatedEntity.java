package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;


@Entity
@Table(name = "t_batch_allocated")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class BatchAllocatedEntity extends CommonEntity implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;


    // Batch Allocated ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "batch_allocated_id")
    @JsonProperty("batchAllocatedId")
    private Integer batchAllocatedId;

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
    @Column(name = "ps_quantity")
    @JsonProperty("psQuantity")
    private Integer psQuantity = 0;

    // Total Allocated Quantity
    @Column(name = "quantity", nullable = false)
    @JsonProperty("quantity")
    private Integer quantity;

    // CS Price
    @Column(name = "cs_price", precision = 19, scale = 2)
    @JsonProperty("csPrice")
    private Double csPrice;

    // BL Price
    @Column(name = "bl_price", precision = 7, scale = 2)
    @JsonProperty("blPrice")
    private Double blPrice;

    // PS Price
    @Column(name = "piece_price", precision = 7, scale = 2)
    @JsonProperty("piecePrice")
    private Double piecePrice;

    // Total Amount
    @Column(name = "amount_total", precision = 7, scale = 2)
    @JsonProperty("amountTotal")
    private Double amountTotal;

    // Tax
    @Column(name = "tax", precision = 2, scale = 2)
    @JsonProperty("tax")
    private Double tax;

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

    // billing_pack_type
    @Column(name = "billing_pack_type")
    @JsonProperty("billingPackType")
    private String billing_pack_type;



}

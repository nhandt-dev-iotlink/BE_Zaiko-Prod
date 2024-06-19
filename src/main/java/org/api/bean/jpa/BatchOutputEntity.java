package org.api.bean.jpa;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "t_batch_output")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class BatchOutputEntity  extends CommonEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "batch_output_id")
    @JsonProperty("batchOutputId")
    private Integer batchOutputId;


    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    @Column(name = "batch_id", nullable = false)
    @JsonProperty("batchId")
    private Integer batchId;

    @Column(name = "inventory_output_id", nullable = false)
    @JsonProperty("inventoryOutputId")
    private Integer inventoryOutputId;

    @Column(name = "slip_no", nullable = false, length = 20)
    @JsonProperty("slipNo")
    private String slipNo;

    @Column(name = "batch_no", nullable = false, length = 50)
    @JsonProperty("batchNo")
    private String batchNo;

    @Column(name = "name", nullable = false, length = 100)
    @JsonProperty("name")
    private String name;

    @Column(name = "batch_status", nullable = false, length = 1)
    @JsonProperty("batchStatus")
    private String batchStatus;

    @Column(name = "lack_of_product_status", length = 1)
    @JsonProperty("lackOfProductStatus")
    private String lackOfProductStatus;

    @Column(name = "delivery_instruction_status", length = 1)
    @JsonProperty("deliveryInstructionStatus")
    private String deliveryInstructionStatus;

    @Column(name = "confirm_status", length = 1)
    @JsonProperty("confirmStatus")
    private String confirmStatus;

    @Column(name = "delivery_note_status", length = 1)
    @JsonProperty("deliveryNoteStatus")
    private String deliveryNoteStatus;

    @JsonProperty("freeItem1")
    @Column(name = "free_item1", length = 100)
    private String freeItem1;

    @JsonProperty("freeItem2")
    @Column(name = "free_item2", length = 100)
    private String freeItem2;

    @JsonProperty("freeItem3")
    @Column(name = "free_item3", length = 100)
    private String freeItem3;


}

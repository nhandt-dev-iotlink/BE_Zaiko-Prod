package org.api.bean.jpa;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "t_batch_detail")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class BatchDetailEntity extends CommonEntity implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "batch_detail_id")
    @JsonProperty("batchDetailId")
    private Integer batchDetailId;
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    @Column(name = "batch_output_id", nullable = false)
    @JsonProperty("batchOutputId")
    private Integer batchOutputId;

    @Column(name = "plan_detail_id", nullable = false)
    @JsonProperty("planDetailId")
    private Integer planDetailId;

    @Column(name = "slip_no", nullable = false, length = 20)
    @JsonProperty("slipNo")
    private String slipNo;

    @Column(name = "allocated_quantity", nullable = false)
    @JsonProperty("allocatedQuantity")
    private Integer allocatedQuantity;

    @Column(name = "remain_quantity")
    @JsonProperty("remainQuantity")
    private Integer remainQuantity;

    @Column(name = "picking_list", nullable = false, length = 1, columnDefinition = "char default '0'")
    @JsonProperty("pickingList")
    private String pickingList = "0";

    @Column(name = "set_product_list", nullable = false, length = 1, columnDefinition = "char default '0'")
    @JsonProperty("setProductList")
    private String setProductList = "0";

    @Column(name = "lack_product_list", nullable = false, length = 1, columnDefinition = "char default '0'")
    @JsonProperty("lackProductList")
    private String lackProductList = "0";

    @Column(name = "batch_status", nullable = false, length = 1, columnDefinition = "char default '0'")
    @JsonProperty("batchStatus")
    private String batchStatus = "0";

    @Column(name = "lack_of_product_status", length = 1, columnDefinition = "char default '0'")
    @JsonProperty("lackOfProductStatus")
    private String lackOfProductStatus = "0";

    @Column(name = "delivery_instruction_status", length = 1, columnDefinition = "char default '0'")
    @JsonProperty("deliveryInstructionStatus")
    private String deliveryInstructionStatus = "0";

    @Column(name = "confirm_status", length = 1, columnDefinition = "char default '0'")
    @JsonProperty("confirmStatus")
    private String confirmStatus = "0";

    @Column(name = "delivery_note_status", length = 1, columnDefinition = "char default '0'")
    @JsonProperty("deliveryNoteStatus")
    private String deliveryNoteStatus = "0";

    @Column(name = "inventory_output_id")
    @JsonProperty("inventoryOutputId")
    private Integer inventoryOutputId;

    @Column(name = "business_day", length = 10)
    @JsonProperty("businessDay")
    private String businessDay;

    @Column(name = "free_item1", length = 100)
    @JsonProperty("freeItem1")
    private String freeItem1;

    @Column(name = "free_item2", length = 100)
    @JsonProperty("freeItem2")
    private String freeItem2;

    @Column(name = "free_item3", length = 100)
    @JsonProperty("freeItem3")
    private String freeItem3;

}

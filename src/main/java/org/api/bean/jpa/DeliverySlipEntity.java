package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "t_delivery_slip")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class DeliverySlipEntity extends CommonEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // Delivery Slip ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_slip_id")
    @JsonProperty("deliverySlipId")
    private Integer deliverySlipId;

    // Company ID
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    // Delivery Date
    @Column(name = "delivery_date", nullable = false, length = 10)
    @JsonProperty("deliveryDate")
    private String deliveryDate;

    // Slip Number
    @Column(name = "slip_number")
    @JsonProperty("slipNumber")
    private Integer slipNumber = null;

    // Slip Type
    @Column(name = "slip_type", length = 1, nullable = false)
    @JsonProperty("slipType")
    private String slipType;

    // Slip Number
    @Column(name = "slip_no", length = 20, nullable = false)
    @JsonProperty("slipNo")
    private String slipNo;

    // Print Status
    @Column(name = "print_status", length = 1, nullable = false)
    @JsonProperty("printStatus")
    private String printStatus = "0";

    // Text Print Status
    @Column(name = "text_print_status", length = 1, nullable = false)
    @JsonProperty("textPrintStatus")
    private String textPrintStatus ="0";

    // Output ID
    @Column(name = "output_id", nullable = false)
    @JsonProperty("outputId")
    private Integer outputId=0;

    // working_date
    @Column(name = "working_date")
    @JsonProperty("workingDate")
    private String workingDate;

    // batchNo
    @Column(name = "batch_no")
    @JsonProperty("batchNo")
    private String batchNo;

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

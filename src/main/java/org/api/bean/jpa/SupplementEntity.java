package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "t_supplement")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class SupplementEntity extends CommonEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    //Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplement_id")
    @JsonProperty("supplementId")
    private Integer supplementId;

    // companyId
    @Column(name = "company_id")
    @JsonProperty("companyId")
    private Integer companyId;

    // plan_quantity
    @Column(name = "plan_quantity")
    @JsonProperty("planQuantity")
    private Integer planQuantity;

    // actual_quantity
    @Column(name = "actual_quantity")
    @JsonProperty("actualQuantity")
    private Integer actualQuantity;

    // output_available_quantity
    @Column(name = "output_available_quantity")
    @JsonProperty("outputAvailableQuantity")
    private Integer outputAvailableQuantity;

    // input_available_quantity
    @Column(name = "input_available_quantity")
    @JsonProperty("inputAvailableQuantity")
    private Integer inputAvailableQuantity;

    // supplement_quantity
    @Column(name = "supplement_quantity")
    @JsonProperty("supplementQuantity")
    private Integer supplementQuantity;

    //product_id
    @Column(name = "product_id")
    @JsonProperty("productId")
    private Integer productId;

    // status
    @Column(name = "status")
    @JsonProperty("status")
    private String status;

    //free_item3
    @Column(name = "free_item3")
    @JsonProperty("freeItem3")
    private String freeItem3;

    //free_item4
    @Column(name = "free_item4")
    @JsonProperty("freeItem4")
    private String freeItem4;

    //free_item5
    @Column(name = "free_item5")
    @JsonProperty("freeItem5")
    private String freeItem5;





}

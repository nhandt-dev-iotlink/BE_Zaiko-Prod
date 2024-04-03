package org.api.bean.jpa;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name ="t_expense_detail")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class ExpenseDetailEntity extends CommonEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_detail_id")
    @JsonProperty("expenseDetailId")
    private Integer expenseDetailId;

    @JsonProperty("companyId")
    @Column(name = "company_id", length = 4, nullable = false)
    private Integer companyId;

    @JsonProperty("expenseId")
    @Column(name = "expense_id", length = 10, nullable = false)
    private Integer expenseId;

    @JsonProperty("productId")
    @Column(name = "product_id", length = 10, nullable = false)
    private Integer productId;

    @JsonProperty("productName")
    @Column(name = "product_name", length = 100, nullable = false)
    private String productName;

    @JsonProperty("quantity")
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @JsonProperty("unitPrice")
    @Column(name = "unit_price", precision = 19, scale = 2, nullable = false)
    private Double unitPrice;

    @JsonProperty("amountTotal")
    @Column(name = "amount_total", precision = 19, scale = 2, nullable = false)
    private Double amountTotal;

    @JsonProperty("tax")
    @Column(name = "tax", precision = 2, scale = 2)
    private Double tax;

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

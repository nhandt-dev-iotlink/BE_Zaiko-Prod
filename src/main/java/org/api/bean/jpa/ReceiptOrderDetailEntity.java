package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "t_receipt_order_detail")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class ReceiptOrderDetailEntity extends CommonEntity {

    private static final long serialVersionUID = 1L;

    // ReceiptOrderDetail ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    @JsonProperty("detailId")
    private Integer detailId;

    // CompanyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    // ReceiptOrderId
    @Column(name = "receipt_order_id", nullable = false)
    @JsonProperty("receiptOrderId")
    private Integer receiptOrderId;

    // ProductId
    @Column(name = "product_id", nullable = false)
    @JsonProperty("productId")
    private Integer productId;

    // Quantity
    @Column(name = "quantity", nullable = false)
    @JsonProperty("quantity")
    private Integer quantity;

    // PackUnitCode
    @Column(name = "pack_unit_code", nullable = false)
    @JsonProperty("packUnitCode")
    private String packUnitCode;

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


}
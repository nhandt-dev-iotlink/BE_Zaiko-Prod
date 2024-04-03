package org.api.bean.jpa;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "t_return_output_detail")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class ReturnOutputDetailEntity  extends CommonEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    @JsonProperty("detail_id")
    private Long detailId;

    @Column(name = "company_id", nullable = false)
    @JsonProperty("company_id")
    private Integer companyId;

    @Column(name = "return_output_id", nullable = false)
    @JsonProperty("return_output_id")
    private Long returnOutputId;

    @Column(name = "return_output_date", length = 10)
    @JsonProperty("return_output_date")
    private String returnOutputDate;

    @Column(name = "inventory_id", nullable = false)
    @JsonProperty("inventory_id")
    private Long inventoryId;

    @Column(name = "product_owner_id", nullable = false)
    @JsonProperty("product_owner_id")
    private Long productOwnerId;

    @Column(name = "supplier_id", nullable = false)
    @JsonProperty("supplier_id")
    private Long supplierId;

    @Column(name = "repository_id", nullable = false)
    @JsonProperty("repository_id")
    private Long repositoryId;

    @Column(name = "location_id", nullable = false)
    @JsonProperty("location_id")
    private Long locationId;

    @Column(name = "datetime_mng", length = 10, nullable = false)
    @JsonProperty("datetime_mng")
    private String datetimeMng;

    @Column(name = "number_mng", length = 10, nullable = false)
    @JsonProperty("number_mng")
    private String numberMng;

    @Column(name = "product_id", nullable = false)
    @JsonProperty("product_id")
    private Long productId;

    @Column(name = "cs_quantity", columnDefinition = "int(6) default 0")
    @JsonProperty("cs_quantity")
    private Integer csQuantity;

    @Column(name = "bl_quantity", columnDefinition = "int(9) default 0")
    @JsonProperty("bl_quantity")
    private Integer blQuantity;

    @Column(name = "ps_quantity", columnDefinition = "int(9) default 0")
    @JsonProperty("ps_quantity")
    private Integer psQuantity;

    @Column(name = "quantity", columnDefinition = "int default 0")
    @JsonProperty("quantity")
    private Integer quantity;

    @Column(name = "inventory_product_type", length = 50)
    @JsonProperty("inventory_product_type")
    private String inventoryProductType;

    @Column(name = "actual_cs_price", precision = 19, scale = 2)
    @JsonProperty("actual_cs_price")
    private Double actualCsPrice;

    @Column(name = "actual_bl_price", precision = 19, scale = 2)
    @JsonProperty("actual_bl_price")
    private Double actualBlPrice;

    @Column(name = "actual_piece_price", precision = 19, scale = 2)
    @JsonProperty("actual_piece_price")
    private Double actualPiecePrice;

    @Column(name = "amount_total", precision = 19, scale = 2)
    @JsonProperty("amount_total")
    private Double amountTotal;

    @Column(name = "tax", precision = 2, scale = 2)
    @JsonProperty("tax")
    private Double tax;

    @Column(name = "correction_reason", length = 50)
    @JsonProperty("correction_reason")
    private String correctionReason;

    @Column(name = "notes", length = 200)
    @JsonProperty("notes")
    private String notes;


}

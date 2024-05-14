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

    @Column(name = "company_id")
    @JsonProperty("company_id")
    private Integer companyId;

    @Column(name = "return_output_id")
    @JsonProperty("return_output_id")
    private Long returnOutputId;

    @Column(name = "return_output_date")
    @JsonProperty("return_output_date")
    private String returnOutputDate;

    @Column(name = "inventory_id")
    @JsonProperty("inventory_id")
    private Long inventoryId;

    @Column(name = "product_owner_id")
    @JsonProperty("product_owner_id")
    private Long productOwnerId;

    @Column(name = "supplier_id")
    @JsonProperty("supplier_id")
    private Long supplierId;

    @Column(name = "repository_id")
    @JsonProperty("repository_id")
    private Long repositoryId;

    @Column(name = "location_id")
    @JsonProperty("location_id")
    private Long locationId;

    @Column(name = "datetime_mng")
    @JsonProperty("datetime_mng")
    private String datetimeMng;

    @Column(name = "number_mng")
    @JsonProperty("number_mng")
    private String numberMng;

    @Column(name = "product_id")
    @JsonProperty("product_id")
    private Long productId;

    @Column(name = "cs_quantity")
    @JsonProperty("cs_quantity")
    private Integer csQuantity;

    @Column(name = "bl_quantity")
    @JsonProperty("bl_quantity")
    private Integer blQuantity;

    @Column(name = "ps_quantity")
    @JsonProperty("ps_quantity")
    private Integer psQuantity;

    @Column(name = "quantity")
    @JsonProperty("quantity")
    private Integer quantity;

    @Column(name = "inventory_product_type")
    @JsonProperty("inventory_product_type")
    private String inventoryProductType;

    @Column(name = "cs_price")
    @JsonProperty("csPrice")
    private Double csPrice;

    @Column(name = "bl_price")
    @JsonProperty("bl_price")
    private Double bl_price;

    @Column(name = "piece_price")
    @JsonProperty("piece_price")
    private Double piece_price;

    @Column(name = "amount_total")
    @JsonProperty("amount_total")
    private Double amountTotal;

    @Column(name = "tax")
    @JsonProperty("tax")
    private Double tax;

    @Column(name = "correction_reason")
    @JsonProperty("correction_reason")
    private String correctionReason;

    @Column(name = "notes")
    @JsonProperty("notes")
    private String notes;


}

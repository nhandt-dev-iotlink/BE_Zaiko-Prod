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
    @JsonProperty("detailId")
    private Long detailId;

    @Column(name = "company_id")
    @JsonProperty("companyId")
    private Integer companyId;

    @Column(name = "return_output_id")
    @JsonProperty("returnOutputId")
    private Long returnOutputId;

    @Column(name = "return_output_date")
    @JsonProperty("returnOutputDate")
    private String returnOutputDate;

    @Column(name = "inventory_id")
    @JsonProperty("inventoryId")
    private Long inventoryId;

    @Column(name = "product_owner_id")
    @JsonProperty("productOwnerId")
    private Long productOwnerId;

    @Column(name = "supplier_id")
    @JsonProperty("supplierId")
    private Long supplierId;

    @Column(name = "repository_id")
    @JsonProperty("repositoryId")
    private Long repositoryId;

    @Column(name = "location_id")
    @JsonProperty("locationId")
    private Long locationId;

    @Column(name = "datetime_mng")
    @JsonProperty("datetimeMng")
    private String datetimeMng;

    @Column(name = "number_mng")
    @JsonProperty("numberMng")
    private String numberMng;

    @Column(name = "product_id")
    @JsonProperty("productId")
    private Long productId;

    @Column(name = "cs_quantity")
    @JsonProperty("csQuantity")
    private Integer csQuantity;

    @Column(name = "bl_quantity")
    @JsonProperty("blQuantity")
    private Integer blQuantity;

    @Column(name = "ps_quantity")
    @JsonProperty("psQuantity")
    private Integer psQuantity;

    @Column(name = "quantity")
    @JsonProperty("quantity")
    private Integer quantity;

    @Column(name = "inventory_product_type")
    @JsonProperty("inventoryProductType")
    private String inventoryProductType;

    @Column(name = "cs_price")
    @JsonProperty("csPrice")
    private Double csPrice;

    @Column(name = "bl_price")
    @JsonProperty("blPrice")
    private Double blPrice;

    @Column(name = "piece_price")
    @JsonProperty("piecePrice")
    private Double piecePrice;

    @Column(name = "amount_total")
    @JsonProperty("amountTotal")
    private Double amountTotal;

    @Column(name = "tax")
    @JsonProperty("tax")
    private Double tax;

    @Column(name = "correction_reason")
    @JsonProperty("correctionReason")
    private String correctionReason;

    @Column(name = "notes")
    @JsonProperty("notes")
    private String notes;


}

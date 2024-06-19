package org.api.bean.jpa;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name ="t_owner_change_detail")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class OwnerChangeDetailEntity extends CommonEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_change_detail_id")
    @JsonProperty("ownerChangeDetailId")
    private Long ownerChangeDetailId;

    @Column(name = "company_id")
    @JsonProperty("companyId")
    private Integer companyId;

    @Column(name = "owner_change_id")
    @JsonProperty("ownerChangeId")
    private Integer ownerChangeId;

    @Column(name = "product_id")
    @JsonProperty("productId")
    private Long productId;

    @Column(name = "product_owner_id")
    @JsonProperty("productOwnerId")
    private Long productOwnerId;

    @Column(name = "repository_id")
    @JsonProperty("repositoryId")
    private Long repositoryId;

    @Column(name = "location_id")
    @JsonProperty("locationId")
    private Long locationId;

    @Column(name = "date_time_mng")
    @JsonProperty("dateTimeMng")
    private String dateTimeMng;

    @Column(name = "number_mng")
    @JsonProperty("numberMng")
    private String numberMng;

    @Column(name = "create_slip_type")
    @JsonProperty("createSlipType")
    private String createSlipType;

    @Column(name = "inventory_product_type")
    @JsonProperty("inventoryProductType")
    private String inventoryProductType;

    @Column(name = "supplier_id")
    @JsonProperty("supplierId")
    private Integer supplierId;

    @Column(name = "billing_pack_type")
    @JsonProperty("billingPackType")
    private String billingPackType;

    @Column(name = "cs_price")
    @JsonProperty("csPrice")
    private Double csPrice;

    @Column(name = "cs_quantity")
    @JsonProperty("csQuantity")
    private Integer csQuantity;

    @Column(name = "bl_price")
    @JsonProperty("blPrice")
    private Double blPrice;

    @Column(name = "bl_quantity")
    @JsonProperty("blQuantity")
    private Integer blQuantity;

    @Column(name = "piece_price")
    @JsonProperty("piecePrice")
    private Double piecePrice;

    @Column(name = "ps_quantity")
    @JsonProperty("psQuantity")
    private Integer psQuantity;

    @Column(name = "amount_total")
    @JsonProperty("amountTotal")
    private Double amountTotal;

    @Column(name = "quantity")
    @JsonProperty("quantity")
    private Integer quantity;

    @Column(name = "correction_reason")
    @JsonProperty("correctionReason")
    private String correctionReason;

    @Column(name = "delivery_slip_print_status")
    @JsonProperty("deliverySlipPrintStatus")
    private String deliverySlipPrintStatus;

    @Column(name = "tax")
    @JsonProperty("tax")
    private Double tax;

    @Column(name = "free_item1")
    @JsonProperty("freeItem1")
    private String freeItem1;

    @Column(name = "free_item2")
    @JsonProperty("freeItem2")
    private String freeItem2;

    @Column(name = "free_item3")
    @JsonProperty("freeItem3")
    private String freeItem3;

    @Column(name = "free_item4")
    @JsonProperty("freeItem4")
    private String freeItem4;

    @Column(name = "free_item5")
    @JsonProperty("freeItem5")
    private String freeItem5;



}

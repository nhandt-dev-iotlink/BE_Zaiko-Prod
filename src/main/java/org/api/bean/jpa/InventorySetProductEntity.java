package org.api.bean.jpa;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "t_inventory_set_product")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class InventorySetProductEntity extends CommonEntity {

    private static final long serialVersionUID = 1L;

    // InventorySetProduct ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_set_product_id")
    @JsonProperty("id")
    private Integer id;

    // WorkingDate
    @Column(name = "working_date", nullable = false)
    @JsonProperty("workingDate")
    private String workingDate;

    // CreateSlipType
    @Column(name = "create_slip_type", nullable = false)
    @JsonProperty("createSlipType")
    private String createSlipType;

    // SlipNo
    @Column(name = "slip_no", nullable = false)
    @JsonProperty("slipNo")
    private String slipNo;

    // SlipNote
    @Column(name = "slip_note")
    @JsonProperty("slipNote")
    private String slipNote;

    // ProductID
    @Column(name = "product_id", nullable = false)
    @JsonProperty("productId")
    private Integer productId;

    // DatetimeMng
    @Column(name = "datetime_mng", nullable = false)
    @JsonProperty("datetimeMng")
    private String datetimeMng;

    // NumberMng
    @Column(name = "number_mng", nullable = false)
    @JsonProperty("numberMng")
    private String numberMng;

    // ProductOwnerID
    @Column(name = "product_owner_id")
    @JsonProperty("productOwnerID")
    private Integer productOwnerID;

    // RepositoryId
    @Column(name = "repository_id", nullable = false)
    @JsonProperty("repositoryId")
    private Integer repositoryId;

    // LocationId
    @Column(name = "location_id", nullable = false)
    @JsonProperty("locationId")
    private Integer locationId;

    // InventoryProductType
    @Column(name = "inventory_product_type")
    @JsonProperty("inventoryProductType")
    private Integer inventoryProductType;

    // SupplierId
    @Column(name = "supplier_id")
    @JsonProperty("supplierId")
    private Integer supplierId;

    // CsQuantity
    @Column(name = "cs_quantity", precision = 7, scale = 2)
    @JsonProperty("csQuantity")
    private BigDecimal csQuantity;

    // BlQuantity
    @Column(name = "bl_quantity", precision = 7, scale = 2)
    @JsonProperty("blQuantity")
    private BigDecimal blQuantity;

    // PsQuantity
    @Column(name = "ps_quantity", precision = 7, scale = 2)
    @JsonProperty("psQuantity")
    private BigDecimal psQuantity;

    // Quantity
    @Column(name = "quantity", precision = 7, scale = 2)
    @JsonProperty("quantity")
    private BigDecimal quantity;

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
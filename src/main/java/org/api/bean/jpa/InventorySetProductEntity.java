package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;


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
    @JsonProperty("inventorySetProduct_id")
    private Integer inventorySetProduct_id;

    // companyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    // createDay
    @Column(name = "create_day", nullable = false)
    @JsonProperty("createDay")
    private String createDay;

    // WorkingDate
    @Column(name = "working_date", nullable = false)
    @JsonProperty("workingDate")
    private String workingDate;

    // SlipNo
    @Column(name = "slip_no", nullable = false)
    @JsonProperty("slipNo")
    private String slipNo;

    // SlipNote
    @Column(name = "slip_note")
    @JsonProperty("slipNote")
    private String slipNote;

    // CreateSlipType
    @Column(name = "create_slip_type", nullable = false)
    @JsonProperty("createSlipType")
    private String createSlipType;

    // ProductID
    @Column(name = "product_id", nullable = false)
    @JsonProperty("productId")
    private Integer productId;

    // ProductOwnerID
    @Column(name = "product_owner_id")
    @JsonProperty("productOwnerID")
    private Integer productOwnerID;

    // SupplierId
    @Column(name = "supplier_id")
    @JsonProperty("supplierId")
    private Integer supplierId;

    // RepositoryId
    @Column(name = "repository_id", nullable = false)
    @JsonProperty("repositoryId")
    private Integer repositoryId;

    // LocationId
    @Column(name = "location_id", nullable = false)
    @JsonProperty("locationId")
    private Integer locationId;

    // NumberMng
    @Column(name = "number_mng", nullable = false)
    @JsonProperty("numberMng")
    private String numberMng;

    // DatetimeMng
    @Column(name = "datetime_mng", nullable = false)
    @JsonProperty("datetimeMng")
    private String datetimeMng;

    // InventoryProductType
    @Column(name = "inventory_product_type")
    @JsonProperty("inventoryProductType")
    private Integer inventoryProductType;

    // correctionReason
    @Column(name = "correction_reason", nullable = false)
    @JsonProperty("correctionReason")
    private String correctionReason;

    // CsQuantity
    @Column(name = "cs_quantity")
    @JsonProperty("csQuantity")
    private Integer csQuantity;

    // BlQuantity
    @Column(name = "bl_quantity", precision = 7, scale = 2)
    @JsonProperty("blQuantity")
    private Integer blQuantity;

    // PsQuantity
    @Column(name = "ps_quantity", precision = 7, scale = 2)
    @JsonProperty("psQuantity")
    private Integer psQuantity;

    // Quantity
    @Column(name = "quantity", precision = 7, scale = 2)
    @JsonProperty("quantity")
    private Integer quantity;

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
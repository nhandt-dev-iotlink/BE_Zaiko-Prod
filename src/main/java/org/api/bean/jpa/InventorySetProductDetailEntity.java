package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "t_inventory_set_product_detail")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class InventorySetProductDetailEntity extends CommonEntity {

    private static final long serialVersionUID = 1L;

    // InventorySetProductDetail ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_set_product_detail_id")
    @JsonProperty("inventorySetProductDetail_id")
    private Integer inventorySetProductDetail_id;

    // ProductID
    @Column(name = "company_id")
    @JsonProperty("companyId")
    private Integer companyId;

    // InventoryId
    @Column(name = "inventory_id")
    @JsonProperty("inventoryId")
    private Integer inventoryId;

    // InventorySetProductId
    @Column(name = "inventory_set_product_id")
    @JsonProperty("inventorySetProductId")
    private Integer inventorySetProductId;

    // SubQuantity
    @Column(name = "quantity")
    @JsonProperty("quantity")
    private Integer quantity;

    // ConstituentQuantity
    @Column(name = "constituent_quantity")
    @JsonProperty("constituentQuantity")
    private Integer constituentQuantity;


}
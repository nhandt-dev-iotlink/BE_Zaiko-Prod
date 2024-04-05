package org.api.bean.jpa;


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
    @JsonProperty("id")
    private Integer id;

    // InventorySetProductId
    @Column(name = "inventory_set_product_id", nullable = false)
    @JsonProperty("inventorySetProductId")
    private Integer inventorySetProductId;

    // InventoryId
    @Column(name = "inventory_id", nullable = false)
    @JsonProperty("inventoryId")
    private Integer inventoryId;

    // CompanyID
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    // Quantity
    @Column(name = "quantity")
    @JsonProperty("quantity")
    private Integer quantity;

    // ConstituentQuantity
    @Column(name = "constituent_quantity")
    @JsonProperty("constituentQuantity")
    private Integer constituentQuantity;


}
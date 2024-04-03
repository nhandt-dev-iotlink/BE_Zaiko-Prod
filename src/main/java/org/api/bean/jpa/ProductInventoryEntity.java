package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_product_inventory")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class ProductInventoryEntity extends CommonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    @JsonProperty("inventoryId")
    private Integer inventory_id;

    //companyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer company_id;

    //companyOwnerId
    @Column(name = "company_owner_id",
            columnDefinition = "integer default 0000000")
    @JsonProperty("companyOwner_id")
    private Integer company_owner_id;

    //productId
    @Column(name = "product_id", nullable = false)
    @JsonProperty("productId")
    private Integer product_id;

    //supplierId
    @Column(name = "supplier_id")
    @JsonProperty("supplierId")
    private Integer supplier_id;

    //repositoryId
    @Column(name = "repository_id", nullable = false)
    @JsonProperty("repositoryId")
    private Integer repository_id;

    //locationId
    @Column(name = "location_id", nullable = false)
    @JsonProperty("locationId")
    private Integer location_id;

    //datetime_mng
    @Column(name = "datetime_mng")
    @JsonProperty("datetime_mng")
    private String datetime_mng;

    //number_mng
    @Column(name = "number_mng")
    @JsonProperty("number_mng")
    private String number_mng;

    //inventoryProductType
    @Column(name = "inventory_product_type")
    @JsonProperty("inventoryProductType")
    private Integer inventory_product_type;

    //quantity
    @Column(name = "quantity", nullable = false)
    @JsonProperty("quantity")
    private Integer quantity;

    //allocatedQuantity
    @Column(name = "allocated_quantity")
    @JsonProperty("allocatedQuantity")
    private Integer allocated_quantity;

    //free_item1
    @Column(name = "free_item1")
    @JsonProperty("freeItem1")
    private String free_item1;

    //free_item2
    @Column(name = "free_item2")
    @JsonProperty("freeItem2")
    private String free_item2;

    //free_item3
    @Column(name = "free_item3")
    @JsonProperty("freeItem3")
    private String free_item3;

    //free_item4
    @Column(name = "free_item4")
    @JsonProperty("freeItem4")
    private String free_item4;

    //free_item5
    @Column(name = "free_item5")
    @JsonProperty("freeItem5")
    private String free_item5;
}

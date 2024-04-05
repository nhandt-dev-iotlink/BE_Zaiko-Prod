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
    @Column(name = "company_id")
    @JsonProperty("companyId")
    private Integer company_id;

    //productOwnerId
    @Column(name = "product_owner_id")
    @JsonProperty("companyOwner_id")
    private Integer product_owner_id;

    //customerCode
    @Column(name = "customer_code")
    @JsonProperty("customerCode")
    private String customer_code;

    //productId
    @Column(name = "product_id")
    @JsonProperty("productId")
    private Integer product_id;

    //productCode
    @Column(name = "product_code")
    @JsonProperty("productCode")
    private String product_code;

    //supplierId
    @Column(name = "supplier_id")
    @JsonProperty("supplierId")
    private Integer supplier_id;

    //supplierCode
    @Column(name = "supplier_code")
    @JsonProperty("supplierCode")
    private String supplier_code;

    //repositoryId
    @Column(name = "repository_id")
    @JsonProperty("repositoryId")
    private Integer repository_id;

    //repositoryCode
    @Column(name = "repository_code")
    @JsonProperty("repositoryCode")
    private String repository_code;

    //locationId
    @Column(name = "location_id")
    @JsonProperty("locationId")
    private Integer location_id;

    //locationCode
    @Column(name = "location_code")
    @JsonProperty("locationCode")
    private String location_code;

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
    private String inventory_product_type;

    //quantity
    @Column(name = "quantity")
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
}

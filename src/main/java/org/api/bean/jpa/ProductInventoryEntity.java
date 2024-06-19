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
    private Integer inventoryId;

    //companyId
    @Column(name = "company_id")
    @JsonProperty("companyId")
    private Integer companyId;

    //productOwnerId
    @Column(name = "product_owner_id")
    @JsonProperty("productOwnerId")
    private Integer productOwnerId;

    //customerCode
    @Column(name = "customer_code")
    @JsonProperty("customerCode")
    private String customerCode;

    //productId
    @Column(name = "product_id")
    @JsonProperty("productId")
    private Integer productId;

    //productCode
    @Column(name = "product_code")
    @JsonProperty("productCode")
    private String productCode;

    //supplierId
    @Column(name = "supplier_id")
    @JsonProperty("supplierId")
    private Integer supplierId;

    //supplierCode
    @Column(name = "supplier_code")
    @JsonProperty("supplierCode")
    private String supplierCode;

    //repositoryId
    @Column(name = "repository_id")
    @JsonProperty("repositoryId")
    private Integer repositoryId;

    //repositoryCode
    @Column(name = "repository_code")
    @JsonProperty("repositoryCode")
    private String repositoryCode;

    //locationId
    @Column(name = "location_id")
    @JsonProperty("locationId")
    private Integer locationId;

    //locationCode
    @Column(name = "location_code")
    @JsonProperty("locationCode")
    private String locationCode;

    //datetime_mng
    @Column(name = "datetime_mng")
    @JsonProperty("datetimeMng")
    private String datetimeMng;

    //number_mng
    @Column(name = "number_mng")
    @JsonProperty("numberMng")
    private String numberMng;

    //inventoryProductType
    @Column(name = "inventory_product_type")
    @JsonProperty("inventoryProductType")
    private String inventoryProductType;

    //quantity
    @Column(name = "quantity")
    @JsonProperty("quantity")
    private Integer quantity;

    //allocatedQuantity
    @Column(name = "allocated_quantity")
    @JsonProperty("allocatedQuantity")
    private Integer allocatedQuantity;

    //Free Item 1
    @Column(name = "free_item1")
    @JsonProperty("freeItem1")
    private String freeItem1;

    //Free Item 2
    @Column(name = "free_item2")
    @JsonProperty("freeItem2")
    private String freeItem2;

    //Free Item 3
    @Column(name = "free_item3")
    @JsonProperty("freeItem3")
    private String freeItem3;
}

package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_product_inventory_change")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class ProductInventoryChangeEntity extends CommonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_change_id")
    @JsonProperty("inventoryChangeId")
    private Integer inventoryChangeId;

    //companyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    //productOwner_id
    @Column(name = "product_owner_id")
    @JsonProperty("productOwnerId")
    private Integer productOwnerId;

    //productId
    @Column(name = "product_id")
    @JsonProperty("productId")
    private Integer productId;

    //setProductId
    @Column(name = "set_product_id")
    @JsonProperty("setProductId")
    private Integer setProductId;

    //supplierId
    @Column(name = "supplier_id")
    @JsonProperty("supplierId")
    private Integer supplierId;

    //repositoryId
    @Column(name = "repository_id")
    @JsonProperty("repositoryId")
    private Integer repositoryId;

    //locationId
    @Column(name = "location_id")
    @JsonProperty("locationId")
    private Integer locationId;

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
    private Integer inventoryProductType;

    //inventoryQuantity
    @Column(name = "inventory_quantity")
    @JsonProperty("inventoryQuantity")
    private Integer inventoryQuantity;

    //changeQuantity
    @Column(name = "change_quantity")
    @JsonProperty("changeQuantity")
    private Integer changeQuantity;

    //changeDate
    @Column(name = "change_date")
    @JsonProperty("changeDate")
    private String changeDate;

    //changeType
    @Column(name = "change_type")
    @JsonProperty("changeType")
    private String changeType;

    //changeReason
    @Column(name = "change_reason")
    @JsonProperty("changeReason")
    private String changeReason;

    //detailId
    @Column(name = "detail_id")
    @JsonProperty("detailId")
    private Integer detailId;

    //headerId
    @Column(name = "header_id")
    @JsonProperty("headerId")
    private Integer headerId;

    //slipNo
    @Column(name = "slip_no")
    @JsonProperty("slipNo")
    private String slipNo;

    //businessDate
    @Column(name = "business_date")
    @JsonProperty("businessDate")
    private String businessDate;

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

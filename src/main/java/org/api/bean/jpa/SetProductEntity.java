package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "m_set_product")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class SetProductEntity extends CommonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "set_product_id")
    @JsonProperty("setProductId")
    private Integer setProductId;

    // Company Id
    @Column(name = "company_id")
    @JsonProperty("companyId")
    private Integer companyId;

    // Product Id
    @Column(name = "product_id")
    @JsonProperty("productId")
    private Integer productId;

    // ProductCode
    @Column(name = "product_code")
    @JsonProperty("productCode")
    private String productCode;

    // Child Product Id
    @Column(name = "child_product_id")
    @JsonProperty("childProductId")
    private Integer childProductId;

    // product_code_child
    @Column(name = "product_code_child")
    @JsonProperty("productCodeChild")
    private Integer productCodeChild;

    // Quantity
    @Column(name = "quantity")
    @JsonProperty("quantity")
    private Integer quantity;

    // Product Owner Id
    @Column(name = "product_owner_id")
    @JsonProperty("productOwnerId")
    private Integer productOwnerId;

    //customer_code
    @Column(name = "customer_code")
    @JsonProperty("customerCode")
    private String customer_code;

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

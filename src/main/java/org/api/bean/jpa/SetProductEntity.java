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
    // Set Product ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Integer id;

    // Company Id
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    // Product Id
    @Column(name = "product_id", nullable = false)
    @JsonProperty("productId")
    private Integer productId;

    // Child Product Id
    @Column(name = "child_product_id", nullable = false)
    @JsonProperty("childProductId")
    private Integer childProductId;

    // Quantity
    @Column(name = "quantity", nullable = false)
    @JsonProperty("quantity")
    private Integer quantity;

    // Product Owner Id
    @Column(name = "product_owner_id", nullable = false)
    @JsonProperty("productOwnerId")
    private Integer productOwnerId;


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

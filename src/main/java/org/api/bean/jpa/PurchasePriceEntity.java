package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "m_purchase_price")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class PurchasePriceEntity extends CommonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_price_id")
    @JsonProperty("purchasePrice_id")
    private Integer purchase_price_id;

    //companyId
    @Column(name = "company_id")
    @JsonProperty("companyId")
    private Integer company_id;

    //supplierId
    @Column(name = "supplier_id")
    @JsonProperty("supplierId")
    private Integer supplier_id;

    //supplierCode
    @Column(name = "supplier_code")
    @JsonProperty("supplierCode")
    private String supplier_code;

    //productId
    @Column(name = "product_id")
    @JsonProperty("productId")
    private Integer product_id;

    //productCode
    @Column(name = "product_code")
    @JsonProperty("productCode")
    private String product_code;

    //number_mng
    @Column(name = "number_mng")
    @JsonProperty("number_mng")
    private String number_mng;

    //datetime_mng_from
    @Column(name = "datetime_mng_from")
    @JsonProperty("datetime_mng_from")
    private String datetime_mng_from;

    //datetime_mng_to
    @Column(name = "datetime_mng_to")
    @JsonProperty("datetime_mng_to")
    private String datetime_mng_to;

    //pack_cs_price
    @Column(name = "pack_cs_price")
    @JsonProperty("pack_cs_price")
    private Double pack_cs_price;

    //pack_bl_price
    @Column(name = "pack_bl_price")
    @JsonProperty("pack_bl_price")
    private Double pack_bl_price;

    //piecePrice
    @Column(name = "piece_price")
    @JsonProperty("piecePrice")
    private Double piece_price;

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

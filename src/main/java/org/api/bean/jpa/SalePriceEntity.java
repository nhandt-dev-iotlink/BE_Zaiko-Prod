package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "m_sale_price")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class SalePriceEntity extends CommonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_price_id")
    @JsonProperty("salePriceId")
    private Integer salePriceId;

    //companyId
    @Column(name = "company_id")
    @JsonProperty("companyId")
    private Integer companyId;

    //customerId
    @Column(name = "customer_id")
    @JsonProperty("customerId")
    private Integer customerId;

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

    //number_mng
    @Column(name = "number_mng")
    @JsonProperty("numberMng")
    private String numberMng;

    //datetime_mng_from
    @Column(name = "datetime_mng_from")
    @JsonProperty("datetimeMngFrom")
    private String datetimeMngFrom;

    //datetime_mng_to
    @Column(name = "datetime_mng_to")
    @JsonProperty("datetimeMngTo")
    private String datetimeMngTo;

    //pack_cs_price
    @Column(name = "pack_cs_price")
    @JsonProperty("packCsPrice")
    private Double packCsPrice;

    //pack_bl_price
    @Column(name = "pack_bl_price")
    @JsonProperty("packBlPrice")
    private Double packBlPrice;

    //piecePrice
    @Column(name = "piece_price")
    @JsonProperty("piecePrice")
    private Double piecePrice;

    //free_item1
    @Column(name = "free_item1")
    @JsonProperty("freeItem1")
    private String freeItem1;

    //free_item2
    @Column(name = "free_item2")
    @JsonProperty("freeItem2")
    private String freeItem2;

    //free_item3
    @Column(name = "free_item3")
    @JsonProperty("freeItem3")
    private String freeItem3;
}

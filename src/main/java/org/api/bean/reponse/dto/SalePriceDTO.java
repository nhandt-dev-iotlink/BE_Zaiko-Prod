package org.api.bean.reponse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@Builder
public class SalePriceDTO {

    @JsonProperty("salePriceId")
    private Integer sale_price_id;

    @JsonProperty("companyId")
    private Integer company_id;

    @JsonProperty("customerId")
    private Integer customer_id;


    @JsonProperty("customerCode")
    private String customer_code;

    @JsonProperty("productId")
    private Integer product_id;

    @JsonProperty("productCode")
    private String product_code;

    @JsonProperty("numberMng")
    private String number_mng;

    @JsonProperty("datetimeMngFrom")
    private String datetime_mng_from;

    @JsonProperty("datetimeMngTo")
    private String datetime_mng_to;

    @JsonProperty("packCsPrice")
    private Double pack_cs_price;

    @JsonProperty("packBlPrice")
    private Double pack_bl_price;

    @JsonProperty("piecePrice")
    private Double piece_price;

    @JsonProperty("freeItem1")
    private String free_item1;

    @JsonProperty("freeItem2")
    private String free_item2;

    @JsonProperty("freeItem3")
    private String free_item3;
}

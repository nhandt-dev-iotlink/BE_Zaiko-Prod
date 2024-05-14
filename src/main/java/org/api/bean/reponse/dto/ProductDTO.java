package org.api.bean.reponse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
public class ProductDTO {
    @JsonProperty("productId")
    private Integer productId;

    @JsonProperty("productCode")
    private String productCode;

    @JsonProperty("upcCd1")
    private String upcCd1;

    @JsonProperty("upcCd2")
    private String upcCd2;

    @JsonProperty("name1")
    private String name1;

    @JsonProperty("standardInfo")
    private String standardInfo;

    @JsonProperty("categoryCode1")
    private String categoryCode1;

    @JsonProperty("categoryCode2")
    private String categoryCode2;

    @JsonProperty("categoryCode3")
    private String categoryCode3;

    @JsonProperty("notes")
    private String notes;

    @JsonProperty("pieceUnitCode")
    private String pieceUnitCode;

    @JsonProperty("pieceUnitName")
    private String pieceUnitName;

    @JsonProperty("leadTime")
    private Integer leadTime;
}

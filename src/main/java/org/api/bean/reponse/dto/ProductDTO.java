package org.api.bean.reponse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Builder
public class ProductDTO {
    // Product ID

    @JsonProperty("productId")
    private Integer productId;

    // Company ID

    @JsonProperty("companyId")
    private Integer companyId;

    //Product Code
    @JsonProperty("productCode")
    private String productCode;

    //Upc Cd1
    @JsonProperty("upcCd1")
    private String upcCd1;

    //Upc Cd2
    @JsonProperty("upcCd2")
    private String upcCd2;

    //Name 1
    @JsonProperty("name1")
    private String name1;

    //Name 2
    @JsonProperty("name2")
    private String name2;

    //Name 3
    @JsonProperty("name3")
    private String name3;

    //Name 4
    @JsonProperty("name4")
    private String name4;

    //Name 5
    @JsonProperty("name5")
    private String name5;

    //Standard Info
    @JsonProperty("standardInfo")
    private String standardInfo;

    //Category Code 1
    @JsonProperty("categoryCode1")
    private String categoryCode1;

    //Category Code 2
    @JsonProperty("categoryCode2")
    private String categoryCode2;

    //Category Code 3
    @JsonProperty("categoryCode3")
    private String categoryCode3;

    //Category Code 4
    @JsonProperty("categoryCode4")
    private String categoryCode4;

    //Category Code 5
    @JsonProperty("categoryCode5")
    private String categoryCode5;

    //Note
    @JsonProperty("notes")
    private String notes;

    //Fifo Type
    @JsonProperty("fifoType")
    private String fifoType = "0";

    //Is Datetime Mng
    @JsonProperty("isDatetimeMng")
    private String isDatetimeMng = "0";

    //Datetime Mng Type
    @JsonProperty("datetimeMngType")
    private String datetimeMngType = "0";

    //Is Number Mng
    @JsonProperty("isNumberMng")
    private String isNumberMng = "0";

    //Carton Weight
    @JsonProperty("cartonWeight")
    private Double cartonWeight;

    //Carton Weight Name
    @JsonProperty("cartonWeightName")
    private String cartonWeightName;

    //Carton Volume
    @JsonProperty("cartonVolume")
    private Double cartonVolume;

    //Carton Volume Name
    @JsonProperty("cartonVolumeName")
    private String cartonVolumeName;

    //Carton Vertical
    @JsonProperty("cartonVertical")
    private Double cartonVertical;

    //Carton Horizontal
    @JsonProperty("cartonHorizontal")
    private Double cartonHorizontal;

    //Carton High
    @JsonProperty("cartonHigh")
    private Double cartonHigh;

    //Piece Weight
    @JsonProperty("pieceWeight")
    private Double pieceWeight;

    //Piece Weight Name
    @JsonProperty("pieceWeightName")
    private String pieceWeightName;

    //Piece Volume
    @JsonProperty("pieceVolume")
    private Double pieceVolume;

    //Piece Volume Name
    @JsonProperty("pieceVolumeName")
    private String pieceVolumeName;

    //Piece Vertical
    @JsonProperty("pieceVertical")
    private Double pieceVertical;

    //Piece Horizontal
    @JsonProperty("pieceHorizontal")
    private Double pieceHorizontal;

    //Piece High
    @JsonProperty("pieceHigh")
    private Double pieceHigh;

    //Is Pack Cs Input
    @JsonProperty("isPackCsInput")
    private String isPackCsInput = "0";

    //Is Pack Cs Output
    @JsonProperty("isPackCsOutput")
    private String isPackCsOutput = "0";

    //Pack Cs Unit Code
    @JsonProperty("packCsUnitCode")
    private String packCsUnitCode;

    //Pack Cs Unit name
    @JsonProperty("packCsUnitName")
    private String packCsUnitName;

    //Pack Cs Amount
    @JsonProperty("packCsAmount")
    private Integer packCsAmount;

    //Is Pack Bl Input
    @JsonProperty("isPackBlInput")
    private String isPackBlInput = "0";

    //Is Pack Bl Output
    @JsonProperty("isPackBlOutput")
    private String isPackBlOutput = "0";

    //Pack Bl Unit Code
    @JsonProperty("packBlUnitCode")
    private String packBlUnitCode;

    //Pack Bl Unit Name
    @JsonProperty("packBlUnitName")
    private String packBlUnitName;

    //Pack Bl Amount
    @JsonProperty("packBlAmount")
    private Integer packBlAmount;

    //Is Piece Input
    @JsonProperty("isPieceInput")
    private String isPieceInput = "0";

    //Is Piece Output
    @JsonProperty("isPieceOutput")
    private String isPieceOutput = "0";

    //Piece Unit Code
    @JsonProperty("pieceUnitCode")
    private String pieceUnitCode;

    //Piece Unit Name
    @JsonProperty("pieceUnitName")
    private String pieceUnitName;

    //Repository Id
    @JsonProperty("repositoryId")
    private Integer repositoryId;

    //repositoryCode
    @JsonProperty("repositoryCode")
    private String repositoryCode;

    //Location Id
    @JsonProperty("locationId")
    private Integer locationId;

    //locationCode
    @JsonProperty("locationCode")
    private String locationCode;

    //Is Replenish Quantity
    @JsonProperty("isReplenishMng")
    private String isReplenishMng;

    //Min Inventory Quantity
    @JsonProperty("minInventoryQuantity")
    private Integer minInventoryQuantity;

    //Min Input Quantity
    @JsonProperty("minInputQuantity")
    private Integer minInputQuantity;

    //Supplier Id
    @JsonProperty("supplierId")
    private Integer supplierId;

    //supplierCode
    @JsonProperty("supplierCode")
    private String supplierCode;

    //Lead Time
    @JsonProperty("leadTime")
    private Integer leadTime;




}

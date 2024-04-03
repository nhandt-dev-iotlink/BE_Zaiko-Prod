package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "m_product")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class ProductEntity extends CommonEntity {
    // Product ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Integer id;

    // Company ID
    @Column(name = "company_id")
    @JsonProperty("companyId")
    private Integer companyId;

    //Product Code
    @Column(name = "product_code", nullable = false)
    @JsonProperty("productCode")
    private String productCode;

    //Upc Cd1
    @Column(name = "upc_cd1")
    @JsonProperty("upcCd1")
    private String upcCd1;

    //Upc Cd2
    @Column(name = "upc_cd2")
    @JsonProperty("upcCd2")
    private String upcCd2;

    //Name 1
    @Column(name = "name1", nullable = false)
    @JsonProperty("name1")
    private String name1;

    //Name 2
    @Column(name = "name2")
    @JsonProperty("name2")
    private String name2;

    //Name 3
    @Column(name = "name3")
    @JsonProperty("name3")
    private String name3;

    //Name 4
    @Column(name = "name4")
    @JsonProperty("name4")
    private String name4;

    //Name 5
    @Column(name = "name5")
    @JsonProperty("name5")
    private String name5;

    //Standard Info
    @Column(name = "standard_info")
    @JsonProperty("standardInfo")
    private String standardInfo;

    //Category Code 1
    @Column(name = "category_code_1")
    @JsonProperty("categoryCode1")
    private String categoryCode1;

    //Category Code 2
    @Column(name = "category_code_2")
    @JsonProperty("categoryCode2")
    private String categoryCode2;

    //Category Code 3
    @Column(name = "category_code_3")
    @JsonProperty("categoryCode3")
    private String categoryCode3;

    //Category Code 4
    @Column(name = "category_code_4")
    @JsonProperty("categoryCode4")
    private String categoryCode4;

    //Category Code 5
    @Column(name = "category_code_5")
    @JsonProperty("categoryCode5")
    private String categoryCode5;

    //Note
    @Column(name = "note")
    @JsonProperty("note")
    private String note;

    //Fifo Type
    @Column(name = "fifo_type")
    @JsonProperty("fifoType")
    private String fifoType = "0";

    //Is Datetime Mng
    @Column(name = "is_datetime_mng")
    @JsonProperty("isDatetimeMng")
    private String isDatetimeMng = "0";

    //Datetime Mng Type
    @Column(name = "datetime_mng_type")
    @JsonProperty("datetimeMngType")
    private String datetimeMngType = "0";

    //Is Number Mng
    @Column(name = "is_number_mng")
    @JsonProperty("isNumberMng")
    private String isNumberMng = "0";

    //Carton Weight
    @Column(name = "carton_weight")
    @JsonProperty("cartonWeight")
    private Double cartonWeight;

    //Carton Weight Name
    @Column(name = "carton_weight_name")
    @JsonProperty("cartonWeightName")
    private String cartonWeightName;

    //Carton Volume
    @Column(name = "carton_volume")
    @JsonProperty("cartonVolume")
    private Double cartonVolume;

    //Carton Volume Name
    @Column(name = "carton_volume_name")
    @JsonProperty("cartonVolumeName")
    private String cartonVolumeName;

    //Carton Vertical
    @Column(name = "carton_vertical")
    @JsonProperty("cartonVertical")
    private Double cartonVertical;

    //Carton Horizontal
    @Column(name = "carton_horizontal")
    @JsonProperty("cartonHorizontal")
    private Double cartonHorizontal;

    //Carton High
    @Column(name = "carton_high")
    @JsonProperty("cartonHigh")
    private Double cartonHigh;

    //Piece Weight
    @Column(name = "piece_weight")
    @JsonProperty("pieceWeight")
    private Double pieceWeight;

    //Piece Weight Name
    @Column(name = "piece_weight_name")
    @JsonProperty("pieceWeightName")
    private String pieceWeightName;

    //Piece Volume
    @Column(name = "piece_volume")
    @JsonProperty("pieceVolume")
    private Double pieceVolume;

    //Piece Volume Name
    @Column(name = "piece_volme_name")
    @JsonProperty("pieceVolumeName")
    private String pieceVolumeName;

    //Piece Vertical
    @Column(name = "piece_vertical")
    @JsonProperty("pieceVertical")
    private Double pieceVertical;

    //Piece Horizontal
    @Column(name = "piece_horizontal")
    @JsonProperty("pieceHorizontal")
    private Double pieceHorizontal;

    //Piece High
    @Column(name = "piece_high")
    @JsonProperty("pieceHigh")
    private Double pieceHigh;

    //Is Pack Cs Input
    @Column(name = "is_pack_cs_input")
    @JsonProperty("isPackCsInput")
    private String isPackCsInput = "0";

    //Is Pack Cs Output
    @Column(name = "is_pack_cs_output")
    @JsonProperty("isPackCsOutput")
    private String isPackCsOutput = "0";

    //Pack Cs Unit Code
    @Column(name = "pack_cs_unit_code")
    @JsonProperty("packCsUnitCode")
    private String packCsUnitCode;

    //Pack Cs Amount
    @Column(name = "pack_cs_amount")
    @JsonProperty("packCsAmount")
    private Integer packCsAmount;

    //Is Pack Bl Input
    @Column(name = "is_pack_bl_input")
    @JsonProperty("isPackBlInput")
    private String isPackBlInput = "0";

    //Is Pack Bl Output
    @Column(name = "is_pack_bl_output")
    @JsonProperty("isPackBlOutput")
    private String isPackBlOutput = "0";

    //Pack Bl Unit Code
    @Column(name = "pack_bl_unit_code")
    @JsonProperty("packBlUnitCode")
    private String packBlUnitCode;

    //Pack Bl Amount
    @Column(name = "pack_bl_amount")
    @JsonProperty("packBlAmount")
    private Integer packBlAmount;

    //Is Piece Input
    @Column(name = "is_piece_input")
    @JsonProperty("isPieceInput")
    private String isPieceInput = "0";

    //Is Piece Output
    @Column(name = "is_piece_output")
    @JsonProperty("isPieceOutput")
    private String isPieceOutput = "0";

    //Piece Unit Code
    @Column(name = "piece_unit_code")
    @JsonProperty("pieceUnitCode")
    private String pieceUnitCode;

    //Repository Id
    @Column(name = "repository_id")
    @JsonProperty("repositoryId")
    private Integer repositoryId;

    //Location Id
    @Column(name = "location_id")
    @JsonProperty("locationId")
    private Integer locationId;

    //Is Replenish Quantity
    @Column(name = "is_replenish_mng")
    @JsonProperty("isReplenishMng")
    private String isReplenishMng;

    //Min Inventory Quantity
    @Column(name = "min_inventory_quantity")
    @JsonProperty("minInventoryQuantity")
    private Integer minInventoryQuantity;

    //Min Input Quantity
    @Column(name = "min_input_quantity")
    @JsonProperty("minInputQuantity")
    private Integer minInputQuantity;

    //Is Various
    @Column(name = "is_various")
    @JsonProperty("isVarious")
    private String isVarious;

    //Supplier Id
    @Column(name = "supplier_id")
    @JsonProperty("supplierId")
    private Integer supplierId;

    //Lead Time
    @Column(name = "lead_time")
    @JsonProperty("leadTime")
    private Integer leadTime;

    //Tax
    @Column(name = "tax")
    @JsonProperty("tax")
    private String tax;

    //Is Set
    @Column(name = "is_set")
    @JsonProperty("isSet")
    private String isSet;

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

    //Free Item 4
    @Column(name = "free_item4")
    @JsonProperty("freeItem4")
    private String freeItem4;

    //Free Item 5
    @Column(name = "free_item5")
    @JsonProperty("freeItem5")
    private String freeItem5;


}

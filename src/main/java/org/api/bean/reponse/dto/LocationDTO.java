package org.api.bean.reponse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LocationDTO {

    @JsonProperty("locationId")
    private Integer locationId;

    //companyId
    @JsonProperty("companyId")
    private Integer companyId;

    //repositoryId
    @JsonProperty("repositoryId")
    private Integer repositoryId;

    //repositoryCode
    @JsonProperty("repositoryCode")
    private String repository_code;

    //locationCode
    @JsonProperty("locationCode")
    private String locationCode;

    //locationName
    @JsonProperty("locationName")
    private String locationName;

    //is_reserve_mcarton
    @JsonProperty("isReserveMcarton")
    private String isReserveMcarton;

    //is_reserve_icarton
    @JsonProperty("isReserveIcarton")
    private String isReserveIcarton;

    //is_reserve_piece
    @JsonProperty("isReservePiece")
    private String isReservePiece;

    //is_input_ban
    @JsonProperty("isInputBan")
    private String isInputBan;

    //is_output_ban
    @JsonProperty("isOutputBan")
    private String isOutputBan;

    //is_reserve_ban
    @JsonProperty("isReserveBan")
    private String isReserveBan;

    //road_order_inventory
    @JsonProperty("roadOrderInventory")
    private String roadOrderInventory;

    //road_order_pick
    @JsonProperty("roadOrderPick")
    private String roadOrderPick;

    //notes
    @JsonProperty("notes")
    private String notes;


}

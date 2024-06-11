package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "m_location")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class LocationEntity extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    @JsonProperty("locationId")
    private Integer locationId;

    //companyId
    @Column(name = "company_id",
            nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    //repositoryId
    @Column(name = "repository_id",
            nullable = false)
    @JsonProperty("repositoryId")
    private Integer repositoryId;

    //repositoryCode
    @Column(name = "repository_code")
    @JsonProperty("repositoryCode")
    private String repositoryCode;

    //locationCode
    @Column(name = "location_code",
            nullable = false)
    @JsonProperty("locationCode")
    private String locationCode;

    //locationName
    @Column(name = "location_name")
    @JsonProperty("locationName")
    private String locationName;

    //is_reserve_mcarton
    @Column(name = "is_reserve_mcarton")
    @JsonProperty("isReserveMcarton")
    private String isReserveMcarton;

    //is_reserve_icarton
    @Column(name = "is_reserve_icarton")
    @JsonProperty("isReserveIcarton")
    private String isReserveIcarton;

    //is_reserve_piece
    @Column(name = "is_reserve_piece")
    @JsonProperty("isReservePiece")
    private String isReservePiece;

    //is_input_ban
    @Column(name = "is_input_ban")
    @JsonProperty("isInputBan")
    private String isInputBan;

    //is_output_ban
    @Column(name = "is_output_ban")
    @JsonProperty("isOutputBan")
    private String isOutputBan;

    //is_reserve_ban
    @Column(name = "is_reserve_ban")
    @JsonProperty("isReserveBan")
    private String isReserveBan;

    //road_order_inventory
    @Column(name = "road_order_inventory")
    @JsonProperty("roadOrderInventory")
    private String roadOrderInventory;

    //road_order_pick
    @Column(name = "road_order_pick")
    @JsonProperty("roadOrderPick")
    private String roadOrderPick;

    //notes
    @Column(name = "notes")
    @JsonProperty("notes")
    private String notes;

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

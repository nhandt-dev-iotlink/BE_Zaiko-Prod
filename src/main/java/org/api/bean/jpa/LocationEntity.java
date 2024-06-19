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
    @Column(name = "location_id", nullable = false)
    @JsonProperty("locationId")
    private Integer location_id;

    //companyId
    @Column(name = "company_id",
            nullable = false)
    @JsonProperty("companyId")
    private Integer company_id;

    //repositoryId
    @Id
    @Column(name = "repository_id",
            nullable = false)
    @JsonProperty("repositoryId")
    private Integer repository_id;

    //repositoryCode
    @Column(name = "repository_code")
    @JsonProperty("repositoryCode")
    private String repository_code;

    //locationCode
    @Column(name = "location_code",
            nullable = false)
    @JsonProperty("locationCode")
    private String location_code;

    //locationName
    @Column(name = "location_name")
    @JsonProperty("locationName")
    private String location_name;

    //is_reserve_mcarton
    @Column(name = "is_reserve_mcarton")
    @JsonProperty("is_reserve_mcarton")
    private String is_reserve_mcarton;

    //is_reserve_icarton
    @Column(name = "is_reserve_icarton")
    @JsonProperty("is_reserve_icarton")
    private String is_reserve_icarton;

    //is_reserve_piece
    @Column(name = "is_reserve_piece")
    @JsonProperty("is_reserve_piece")
    private String is_reserve_piece;

    //is_input_ban
    @Column(name = "is_input_ban")
    @JsonProperty("is_input_ban")
    private String is_input_ban;

    //is_output_ban
    @Column(name = "is_output_ban")
    @JsonProperty("is_output_ban")
    private String is_output_ban;

    //is_reserve_ban
    @Column(name = "is_reserve_ban")
    @JsonProperty("is_reserve_ban")
    private String is_reserve_ban;

    //road_order_inventory
    @Column(name = "road_order_inventory")
    @JsonProperty("road_order_inventory")
    private String road_order_inventory;

    //road_order_pick
    @Column(name = "road_order_pick")
    @JsonProperty("road_order_pick")
    private String road_order_pick;

    //notes
    @Column(name = "notes")
    @JsonProperty("notes")
    private String notes;

    //free_item1
    @Column(name = "free_item1")
    @JsonProperty("free_item1")
    private String free_item1;

    //free_item2
    @Column(name = "free_item2")
    @JsonProperty("free_item2")
    private String free_item2;

    //free_item3
    @Column(name = "free_item3")
    @JsonProperty("free_item3")
    private String free_item3;
}

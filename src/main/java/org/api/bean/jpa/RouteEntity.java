package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "m_route")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@IdClass(RouteEntityId.class)
public class RouteEntity extends CommonEntity{
    // Company ID
    @Id
    @Column(name = "company_id")
    @JsonProperty("companyId")
    private Integer companyId;

    //Route Code
    @Id
    @Column(name = "route_code")
    @JsonProperty("routeCode")
    private String routeCode;

    //Route Name
    @Column(name = "route_name")
    @JsonProperty("routeName")
    private String routeName;

    //Notes
    @Column(name = "notes")
    @JsonProperty("notes")
    private String notes;


}

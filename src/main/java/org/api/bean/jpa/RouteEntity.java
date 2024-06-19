package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.api.utils.RouteEntityId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "m_route")
@IdClass(RouteEntityId.class)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class RouteEntity extends CommonEntity implements Serializable {
    // Company ID
    @Id
    @Column(name = "company_id")
    @JsonProperty("companyId")
    private Integer company_id;

    //Route Code
    @Id
    @Column(name = "route_code")
    @JsonProperty("routeCode")
    private String route_code;

    //Route Name
    @Column(name = "route_name")
    @JsonProperty("routeName")
    private String route_name;

    //Notes
    @Column(name = "notes")
    @JsonProperty("notes")
    private String notes;


}

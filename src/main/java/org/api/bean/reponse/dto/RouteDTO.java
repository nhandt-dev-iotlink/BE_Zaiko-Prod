package org.api.bean.reponse.dto;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;

@Getter
@Setter
public class RouteDTO implements Serializable {

    private Integer company_id;

    //Route Code
    private String route_code;

    //Route Name
    private String route_name;

    //Notes
    private String notes;
}

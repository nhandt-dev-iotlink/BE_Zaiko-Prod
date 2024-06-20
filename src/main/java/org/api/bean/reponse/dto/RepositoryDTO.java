package org.api.bean.reponse.dto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RepositoryDTO implements Serializable {

    private Integer repository_id;

    private Integer company_id;

    private String repositoryCode;

    private String repositoryName;

    private String phone_number1;

    private String fax_number1;

    private String post_code1;

    private String address1_1;

    private String address1_2;

    private String address1_3;

    private String address1_4;

    private String phone_number2;
}
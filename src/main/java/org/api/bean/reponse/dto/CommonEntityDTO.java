package org.api.bean.reponse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class CommonEntityDTO implements Serializable {

    private String delFlg;
    private String createDate;
    private String createBy;
    private String updateDate;
    private String updateBy;

}
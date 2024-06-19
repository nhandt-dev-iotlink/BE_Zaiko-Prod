package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;


@Entity
@Table(name = "m_common_setting")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class CommonSettingEntity extends CommonEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    @JsonProperty("companyId")
    private Integer companyId;

    // code
    @Column(name = "code")
    @JsonProperty("code")
    private String code;

    // idx
    @Column(name = "idx")
    @JsonProperty("idx")
    private Integer idx;

    // description
    @Column(name = "description")
    @JsonProperty("description")
    private String description;

    // value1
    @Column(name = "value1")
    @JsonProperty("value1")
    private String value1;

    // value2
    @Column(name = "value2")
    @JsonProperty("value2")
    private String value2;

    // value3
    @Column(name = "value3")
    @JsonProperty("value3")
    private String value3;

    // value4
    @Column(name = "value4")
    @JsonProperty("value4")
    private String value4;

    // value5
    @Column(name = "value5")
    @JsonProperty("value5")
    private String value5;
}

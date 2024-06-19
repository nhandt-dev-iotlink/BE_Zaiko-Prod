package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_unit_name")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class UnitNameEntity extends CommonEntity{
    @Id
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer company_id;

    //unitCode
    @Id
    @Column(name = "unit_code", nullable = false)
    @JsonProperty("unitCode")
    private String unit_code;

    //unit_name
    @Column(name = "unitName", nullable = false)
    @JsonProperty("unitName")
    private String unit_name;

    //notes
    @Column(name = "notes")
    @JsonProperty("notes")
    private String notes;
}

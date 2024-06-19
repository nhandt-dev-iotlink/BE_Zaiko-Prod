package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "m_reason")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class ReasonEntity extends CommonEntity{
    @Id
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer company_id;

    //reason
    @Id
    @Column(name = "reason")
    @JsonProperty("reason")
    private String reason;

    //reasonCode
    @Id
    @Column(name = "reason_code")
    @JsonProperty("reasonCode")
    private String reason_code;

    //reasonContent
    @Column(name = "reason_content")
    @JsonProperty("reasonContent")
    private String reason_content;

    //notes
    @Column(name = "notes")
    @JsonProperty("notes")
    private String notes;
}

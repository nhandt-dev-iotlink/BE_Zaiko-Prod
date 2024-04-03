package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "m_category1")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class Category1Entity extends CommonEntity{

    //Company ID
    @Id
    @Column(name = "company_id")
    @JsonProperty("companyId")
    private Integer companyId;

    //Category Code
    @Id
    @Column(name = "category_code")
    @JsonProperty("categoryCode")
    private String categoryCode;

    //Category Name
    @Column(name = "category_name", nullable = false)
    @JsonProperty("categoryName")
    private String categoryName;

    //Sort Idx
    @Column(name = "sort_idx")
    @JsonProperty("sortIdx")
    private Integer sortIdx = 0;

}

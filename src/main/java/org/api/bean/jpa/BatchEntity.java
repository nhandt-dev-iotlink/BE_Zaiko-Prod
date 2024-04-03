package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "t_batch")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter

public class BatchEntity extends CommonEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // ID
    @JsonProperty("batchId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "batch_id", length = 7)
    private Integer batchId;

    @JsonProperty("companyId")
    @Column(name = "company_id", length = 4, nullable = false)
    private Integer companyId;

    @JsonProperty("repositoryId")
    @Column(name = "repository_id", length = 7, nullable = false)
    private Integer repositoryId;

    @JsonProperty("planWorkingDate")
    @Column(name = "plan_working_date", length = 10, nullable = false)
    private String planWorkingDate;

    @JsonProperty("freeItem1")
    @Column(name = "free_item1", length = 100)
    private String freeItem1;

    @JsonProperty("freeItem2")
    @Column(name = "free_item2", length = 100)
    private String freeItem2;

    @JsonProperty("freeItem3")
    @Column(name = "free_item3", length = 100)
    private String freeItem3;
}

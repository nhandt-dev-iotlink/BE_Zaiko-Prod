package org.api.bean.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_daily_process")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class DailyProcessEntity extends CommonEntity {

    private static final long serialVersionUID = 1L;

    // DailyProcessId
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "daily_process_id")
    @JsonProperty("id")
    private Integer id;

    // CompanyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    // ProcessDate
    @Column(name = "process_date", nullable = false)
    @JsonProperty("processDate")
    private String processDate;

    // ProcessStatus
    @Column(name = "process_status")
    @JsonProperty("processStatus")
    private String processStatus;

    // BusinessDate
    @Column(name = "business_date", nullable = false)
    @JsonProperty("businessDate")
    private String businessDate;

    // FreeItem1
    @Column(name = "free_item1")
    @JsonProperty("freeItem1")
    private String freeItem1;

    // FreeItem2
    @Column(name = "free_item2")
    @JsonProperty("freeItem2")
    private String freeItem2;

    // FreeItem3
    @Column(name = "free_item3")
    @JsonProperty("freeItem3")
    private String freeItem3;


}
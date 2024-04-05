package org.api.bean.jpa;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "m_holiday")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class HolidayEntity extends CommonEntity {

    private static final long serialVersionUID = 1L;

    // Holiday ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "holiday_id")
    @JsonProperty("holidayId")
    private Integer holidayId;

    // CompanyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    // HolidayDate
    @Column(name = "holiday_date", nullable = false)
    @JsonProperty("holidayDate")
    private String holidayDate;

    // HolidayName
    @Column(name = "holiday_name", nullable = false)
    @JsonProperty("holidayName")
    private String holidayName;

    // Annual
    @Column(name = "annual", nullable = false)
    @JsonProperty("annual")
    private String annual = "0";

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
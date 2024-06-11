package org.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {
    private Integer locationId;
    private String locationCode;
    private String locationName;
    private Integer repositoryId;
    private String repositoryCode;
    private String notes;
}

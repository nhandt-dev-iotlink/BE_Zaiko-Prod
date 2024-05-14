package org.api.dto.repository.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RepositoryDropDownDTO {
    @JsonProperty("repositoryId")
    private Integer repository_id;
    @JsonProperty("repositoryCode")
    private String repository_code;
    @JsonProperty("repositoryName")
    private String repository_name;
}

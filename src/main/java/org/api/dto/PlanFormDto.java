package org.api.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanFormDto {
    private InventoryOutputPlanDto infoForm;
    private List<InventoryPlanOutputDetailDto> detailForm;
}

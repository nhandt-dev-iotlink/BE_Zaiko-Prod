package org.api.services;

import org.api.bean.dto.InputProductStatusDto;
import org.api.bean.dto.OutputPlanDetailDto;

import java.util.List;

public interface IProductStatusService {

    List<InputProductStatusDto> getPlanOutputDetail();
}

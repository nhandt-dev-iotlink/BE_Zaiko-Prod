package org.api.services;

import org.api.bean.dto.CommonSettingDto;


import java.util.List;

public interface ICommonSettingService {
    List<CommonSettingDto> getAll();
}

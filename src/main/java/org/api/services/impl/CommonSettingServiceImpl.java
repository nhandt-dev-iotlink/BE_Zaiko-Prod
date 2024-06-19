package org.api.services.impl;

import org.api.bean.dto.CommonSettingDto;
import org.api.repository.ICommonSettingRepository;
import org.api.services.ICommonSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommonSettingServiceImpl implements ICommonSettingService {
    @Autowired
    private ICommonSettingRepository commonSettingRepository;
    @Override
    public List<CommonSettingDto> getAll() {
        return commonSettingRepository.getAll();
    }
}

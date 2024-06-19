package org.api.controller;

import lombok.RequiredArgsConstructor;
import org.api.bean.dto.CommonSettingDto;

import org.api.services.ICommonSettingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/common/setting")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CommonSettingController {
    @Autowired
    private ICommonSettingService commonSettingService;

    @GetMapping("/get-all")
    public ResponseEntity<List<CommonSettingDto>> getAllLocation() {
        List<CommonSettingDto> commonSettingList = commonSettingService.getAll();

        if (commonSettingList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(commonSettingList, HttpStatus.OK);
    }
}

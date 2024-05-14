package org.api.controller;

import org.api.bean.ResultBean;
import org.api.dto.RepositoryDto;
import org.api.services.RepositoryService;
import org.api.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/repository")
public class RepositoryController {
    @Autowired
    private RepositoryService repositoryService;

    @GetMapping("")
    public ResponseEntity<ResultBean> getAll() {
        ResultBean resultBean = null;
        List<RepositoryDto> repositoryDtoList = repositoryService.getAll();
        if (repositoryDtoList == null || repositoryDtoList.isEmpty()) {
            resultBean = new ResultBean(new ArrayList<>(), Constants.STATUS_OK, Constants.MESSAGE_OK);
            return new ResponseEntity<ResultBean>(resultBean, HttpStatus.NO_CONTENT);
        } else {
            resultBean = new ResultBean(repositoryDtoList, Constants.STATUS_OK, Constants.MESSAGE_OK);
            return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);

        }
    }
}

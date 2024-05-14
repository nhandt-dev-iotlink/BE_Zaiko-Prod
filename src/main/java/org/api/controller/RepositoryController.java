package org.api.controller;

import org.api.bean.ResultBean;
import org.api.services.MRepositoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/repository")
public class RepositoryController {

    private final MRepositoryService mRepositoryService;

    public RepositoryController(MRepositoryService mRepositoryService) {
        this.mRepositoryService = mRepositoryService;
    }

    @GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ResultBean> getRepositoryDropDown() throws Exception {

        ResultBean resultBean = mRepositoryService.getAllRepository();
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
    }
}

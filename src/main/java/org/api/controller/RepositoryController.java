package org.api.controller;


import org.api.annotation.LogExecutionTime;
import org.api.bean.ResultBean;
import org.api.bean.jpa.RepositoryEntity;
import org.api.services.RepositoryService;
import org.api.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@LogExecutionTime
@RestController
public class RepositoryController {
    private static final Logger log = LoggerFactory.getLogger(RepositoryController.class);

    @Autowired
    private RepositoryService repositoryService;


    @GetMapping(value = "/api/repository", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultBean> getRepository() {
        try {
            List<RepositoryEntity> repository = repositoryService.getAll();
            ResultBean successResult = new ResultBean(repository, Constants.STATUS_OK, Constants.MESSAGE_OK);
            return new ResponseEntity<ResultBean>(successResult, HttpStatus.OK);
        } catch (Exception e) {
            // Trả về HTTP 500 nếu có lỗi
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

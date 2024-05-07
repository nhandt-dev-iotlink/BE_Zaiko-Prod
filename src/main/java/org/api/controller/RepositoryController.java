package org.api.controller;

import lombok.RequiredArgsConstructor;
import org.api.bean.dto.RepositoryDto;
import org.api.services.IRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/repository")
@RequiredArgsConstructor
@CrossOrigin("*")
public class RepositoryController {
    @Autowired
    private IRepositoryService repositoryService;

    @GetMapping("/get-all")
    public ResponseEntity<List<RepositoryDto>> getAllOutputList() {
        List<RepositoryDto> repositoryList = repositoryService.getAll();

        if (repositoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(repositoryList, HttpStatus.OK);
    }

}

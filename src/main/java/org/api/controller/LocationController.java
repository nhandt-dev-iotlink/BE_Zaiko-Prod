package org.api.controller;


import org.api.annotation.LogExecutionTime;

import org.api.bean.ResultBean;
import org.api.bean.reponse.dto.LocationDTO;
import org.api.bean.reponse.dto.RouteDTO;
import org.api.services.LocationService;
import org.api.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@LogExecutionTime
@RestController
public class LocationController {
    @Autowired
    LocationService locationService;

    private static final Logger log = LoggerFactory.getLogger(LocationController.class);

    @GetMapping(value = "/api/master-location", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultBean> getLocation() {
        try {
            List<LocationDTO> location = locationService.LOCATION_ENTITIES();
            ResultBean successResult = new ResultBean(location, Constants.STATUS_OK, Constants.MESSAGE_OK);
            return new ResponseEntity<ResultBean>(successResult, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/api/master-location/{repo_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultBean> getLocationByRepo(@PathVariable("repo_id") Integer repo_id ){
        try {
            List<LocationDTO> dtos =locationService.LOCATION_BY_REPOSITORY_ID(repo_id);
            ResultBean succesResult = new ResultBean(dtos, Constants.STATUS_OK,Constants.MESSAGE_OK);
            return new ResponseEntity<ResultBean>(succesResult,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

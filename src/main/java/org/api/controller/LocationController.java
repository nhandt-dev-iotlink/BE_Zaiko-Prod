package org.api.controller;

import org.api.bean.ResultBean;
import org.api.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/master-location")
public class LocationController {
    @Autowired
    private LocationService locationService;
    @GetMapping(value = "")
    public ResponseEntity<ResultBean> getAllByRepo(@RequestParam(value = "id") Integer id) throws Exception{
        ResultBean resultBean = null;
        resultBean = locationService.getAllByRepositoryId(id);
        return new ResponseEntity<>(resultBean, HttpStatus.OK);
    }
}

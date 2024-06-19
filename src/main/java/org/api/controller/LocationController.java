package org.api.controller;

import lombok.RequiredArgsConstructor;
import org.api.bean.dto.LocationDto;

import org.api.services.ILocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/master-location")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LocationController {
    @Autowired
    private ILocationService locationService;

    @GetMapping("/get-all")
    public ResponseEntity<List<LocationDto>> getAllLocation() {
        List<LocationDto> locationList = locationService.getAll();

        if (locationList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(locationList, HttpStatus.OK);
    }

    @GetMapping("/get-by-repo/{repositoryId}")
    public ResponseEntity<List<LocationDto>> getLocationByRepo(@PathVariable Integer repositoryId) {
        List<LocationDto> locationList = locationService.getByRepo(repositoryId);

        if (locationList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(locationList, HttpStatus.OK);
    }
}

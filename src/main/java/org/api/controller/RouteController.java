package org.api.controller;

import lombok.RequiredArgsConstructor;
import org.api.bean.dto.CustomerDto;
import org.api.bean.dto.RouteDto;
import org.api.services.ICustomerService;
import org.api.services.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/route")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RouteController {
    @Autowired
    private IRouteService routeService;
    @GetMapping("/get-all")
    public ResponseEntity<List<RouteDto>> getSearchList() {
        List<RouteDto> routeList = routeService.getAll();
        if (routeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(routeList , HttpStatus.OK);
    }
}

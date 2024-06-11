package org.api.controller;

import org.api.bean.ResultBean;
import org.api.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/route")
public class RouteController {
    @Autowired
    private RouteService routeService;
    @GetMapping(value = "")
    public ResponseEntity<ResultBean> getALL() throws Exception{
        ResultBean resultBean = null;
        resultBean = routeService.getAll();
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
    }
//    @GetMapping(value = "/{id}")
//    public ResponseEntity<ResultBean> getById(@PathVariable(value = "id") Integer id) throws Exception{
//        ResultBean resultBean = null;
//        resultBean = routeService.getAll();
//        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
//    }
}

package com.taxiService.taxi.controllers;

import com.taxiService.taxi.models.Request;
import com.taxiService.taxi.models.data.RequestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Action;
import java.util.List;

@RestController
@RequestMapping("requests")
public class RequestController {

    @Autowired
    RequestDao requestDao;

    @GetMapping
    public List<Request> displayRequests(){
        return requestDao.findAll();
    }
}

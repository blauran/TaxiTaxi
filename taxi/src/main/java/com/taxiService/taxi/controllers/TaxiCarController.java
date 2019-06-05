package com.taxiService.taxi.controllers;

import com.taxiService.taxi.models.TaxiCar;
import com.taxiService.taxi.models.User;
import com.taxiService.taxi.models.data.TaxiCarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cars")
public class TaxiCarController {

    @Autowired
    TaxiCarDao taxiCarDao;

    @GetMapping
    public List<TaxiCar> index(){
        return taxiCarDao.findAll();
    }

}

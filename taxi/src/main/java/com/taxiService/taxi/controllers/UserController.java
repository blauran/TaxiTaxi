package com.taxiService.taxi.controllers;

import com.taxiService.taxi.models.User;
import com.taxiService.taxi.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping
    public List<User> displayUsers(){
        return userDao.findAll();
    }
}

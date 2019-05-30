package com.yczuoxin.springboot.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.yczuoxin.springboot.model.User;
import com.yczuoxin.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/{id}")
    @SentinelResource(value = "user-resource")
    public User getById(@PathVariable("id") Long id){
        return userService.getById(id);
    }

}

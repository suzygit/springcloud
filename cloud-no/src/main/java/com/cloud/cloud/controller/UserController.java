package com.cloud.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.cloud.service.UserService;


@RestController
public class UserController {
	
    @Autowired
    private UserService userService;
    
    @RequestMapping("/hello")
    public String hello(String name){
    	
    	return userService.hello(name);
    	
    }

}

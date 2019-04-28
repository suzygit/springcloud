package com.cloud.cloud.controller;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cloud.cloud.service.UserService;


@RestController
public class UserController {
	
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    
    @Autowired
    private UserService userService;
    
    @Bean
    public AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }
    
	private static final Logger LOG = Logger.getLogger(UserController.class.getName());


    @RequestMapping("/hi")
    public String home(){
        LOG.log(Level.INFO, "hi i'm service-hello!");
        return "hi i'm service-hello!";
    }

    @RequestMapping("/info")
    public String info(){
        LOG.log(Level.INFO, "info is being called");
        return restTemplate.getForObject("http://localhost:2222/info",String.class);
    }
    
    @RequestMapping("/hello")
    public String hello(String name){
    	
    	return userService.hello(name);
    	
    }

}

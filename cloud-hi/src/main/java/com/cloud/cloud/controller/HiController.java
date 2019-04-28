package com.cloud.cloud.controller;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.cloud.cloud.CloudHiApplication;

@RestController
public class HiController {
	
	 private static final Logger LOG = Logger.getLogger(CloudHiApplication.class.getName());


	    @Autowired
	    private RestTemplate restTemplate;

	    @Bean
	    public RestTemplate getRestTemplate(){
	        return new RestTemplate();
	    }

	    @RequestMapping("/hi")
	    public String callHome(){
	        LOG.log(Level.INFO, "calling trace service-hi  ");
	        return restTemplate.getForObject("http://localhost:3333/hi", String.class);
	    }
	    
	    @RequestMapping("/info")
	    public String info(){
	        LOG.log(Level.INFO, "i'm service-hi");

	        return "i'm service-hi";

	    }
	    @RequestMapping("/helloHi")
	    public String hello(String name) throws InterruptedException{
	    	LOG.log(Level.INFO, "i'm service-hi1");

	        return "hello " + name + ",i'm from port 4444";

	    }

	    @Bean
	    public AlwaysSampler defaultSampler(){
	        return new AlwaysSampler();
	    }

}

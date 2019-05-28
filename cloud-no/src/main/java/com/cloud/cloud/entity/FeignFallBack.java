package com.cloud.cloud.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Retryer;

@Configuration
public class FeignFallBack {
	
	@Bean
	public Retryer feignRetryer(){
		return new Retryer.Default();
	}

}

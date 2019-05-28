package com.cloud.cloud.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Scope("prototype")
public class SingleMvc {
	
	private int a = 0;
	
	private static int b = 0;

	@RequestMapping("/singleTest")
	public void test(){
		
		System.out.println(a++ +" | " + b++);
		
	}
	

}

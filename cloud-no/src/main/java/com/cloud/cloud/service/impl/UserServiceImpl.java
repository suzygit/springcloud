package com.cloud.cloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cloud.cloud.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	

	@Override
	public String hello(String name) {
		return "aaa";
	}
	

}

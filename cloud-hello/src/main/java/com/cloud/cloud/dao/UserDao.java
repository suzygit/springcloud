package com.cloud.cloud.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.cloud.cloud.entity.FeignFallBack;

//调用的远程服务名
@FeignClient(name = "service-hi")
public interface UserDao {

	//远程服务路径
	@RequestMapping(value = "/helloHi", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

}

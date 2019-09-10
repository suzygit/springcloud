package com.cloud.cloud.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //开启更新功能
@RequestMapping("api")
public class ConfigClientController {
	
	@Value("${myName}")
    private  String myName;
	
	@Value("${age}")
    private  String age;
	
	@RequestMapping("/test")
    public String test(){
        return "姓名：" + myName + " 年龄：" +age;
    }

}

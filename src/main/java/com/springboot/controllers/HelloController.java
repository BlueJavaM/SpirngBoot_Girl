package com.springboot.controllers;

import com.springboot.beans.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author: XieLiang
 *@Date : 2018/7/2
 *@Comment :
 */
@RestController
public class HelloController {
    /**
     * 通过配置文件给变量赋值
     */
//    @Value("${content}")
//    private String content;

    /**
     * 通过@ConfigurationProperties(prefix = "girl")来获取配置文件中的前缀为girl的属性并赋值，
     * 就不需要@Value("${content}")
     */
    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
         return girlProperties.toString();
    }
}

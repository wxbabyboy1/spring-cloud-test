package com.zhagl.demo.controller;

import com.zhagl.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer(){
        //访问服务
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-user", method = RequestMethod.GET)
    public String helloConsumer(String name, Integer age){
        //访问服务
        String string = helloService.user(name, age);
        return string;
    }

    @RequestMapping(value = "/feign-postUser", method = RequestMethod.POST)
    public String helloPostUser(String name, Integer age){
        //访问服务
        String string = helloService.helloPostUser(name, age);
        return string;
    }
}

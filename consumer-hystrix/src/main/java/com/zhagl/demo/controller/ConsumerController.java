package com.zhagl.demo.controller;

import com.zhagl.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hystrix-consumer", method = RequestMethod.GET)
    public String helloConsumer(){
        //访问服务
        return helloService.helloService();
    }

    @RequestMapping(value = "/helloWait", method = RequestMethod.GET)
    public String helloWait(){
        //访问服务
        return helloService.helloWaitService();
    }
}

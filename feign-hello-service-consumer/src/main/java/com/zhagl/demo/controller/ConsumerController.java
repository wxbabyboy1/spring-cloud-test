package com.zhagl.demo.controller;

import com.zhagl.demo.dto.User;
import com.zhagl.demo.service.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private RefactorHelloService refactorHelloService;

    @RequestMapping(value = "/feign-consumer3", method = RequestMethod.GET)
    public String helloConsumer3(){
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("MINI")).append("\n");
        sb.append(refactorHelloService.hello("haha", 20)).append("\n");
        sb.append(refactorHelloService.hello(new User("uuuu", 18))).append("\n");
        return sb.toString();
    }


}

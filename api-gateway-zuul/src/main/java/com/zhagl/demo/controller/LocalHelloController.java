package com.zhagl.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalHelloController {

    @RequestMapping(value = "/tt", method = RequestMethod.GET)
    public String tt(Integer a){
        return "Hello World Local, forward:" + a;
    }
}

package com.zhagl.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController2 {

    @Autowired
    private Environment env;

    @RequestMapping("/from")
    public String from(){
        return env.getProperty("from", "undefined");
    }
}

package com.zhagl.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalHelloController {

    @RequestMapping(value = "/tt", method = RequestMethod.GET)
    public String tt(){
        return "Hello World Local";
    }
}

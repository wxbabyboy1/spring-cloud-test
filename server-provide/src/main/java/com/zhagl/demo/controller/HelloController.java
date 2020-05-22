package com.zhagl.demo.controller;

import com.zhagl.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index(){
        ServiceInstance instance = client.getLocalServiceInstance();
        return "Hello World!host:" + instance.getHost() + ",service_id:"+instance.getServiceId();
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(String name, Integer age){
        return "name:"+name+",age:"+age;
    }

    @RequestMapping(value = "/papa", method = RequestMethod.GET)
    public String user(String name, String time){
        return "name:"+name+",time:"+time;
    }

    /*@RequestMapping(value = "/user-obj", method = RequestMethod.GET)
    public User userObj(String name){
        User user = new User();
        user.name = name;
        return user;
    }*/
}

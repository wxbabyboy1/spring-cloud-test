package com.zhagl.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

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

    @RequestMapping(value = "/hello-hystrix", method = RequestMethod.GET)
    public String indexHystrix() throws InterruptedException {
        ServiceInstance instance = client.getLocalServiceInstance();
        //让处理线程等待几秒钟
        int sleepTime = new Random().nextInt(3000);//由于服务默认有超时时间，所以这样可以模拟服务未响应
        System.out.println(sleepTime);
        Thread.sleep(sleepTime);
        return "Hello World!host:" + instance.getHost() + ",service_id:"+instance.getServiceId();
    }
}

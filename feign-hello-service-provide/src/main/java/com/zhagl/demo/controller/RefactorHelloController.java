package com.zhagl.demo.controller;

import com.zhagl.demo.dto.User;
import com.zhagl.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RefactorHelloController implements HelloService {
    @Autowired
    private DiscoveryClient client;

    @Override
    public String hello(@RequestParam("name") String name) {
        return "Hello:" + name;
    }

    @Override
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User(name, age);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "Hello:" + user.getName() + ",age:" + user.getAge();
    }

    @Override
    public String hello() {
        ServiceInstance instance = client.getLocalServiceInstance();
        //测试超时
        //让处理线程等待几秒钟
        int sleepTime = new Random().nextInt(3000);//由于服务默认有超时时间，所以这样可以模拟服务未响应
        System.out.println("====================sleepTime:"+sleepTime);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello World!host:" + instance.getHost() + ",service_id:"+instance.getServiceId();
    }
}

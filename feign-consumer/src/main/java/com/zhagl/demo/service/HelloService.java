package com.zhagl.demo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("hello-service")
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    String user(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/postUser", method = RequestMethod.POST)
    String helloPostUser(@RequestHeader("name") String name, @RequestHeader("age") Integer age);
}

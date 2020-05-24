package com.zhagl.demo.fallback;

import com.zhagl.demo.dto.User;
import com.zhagl.demo.service.RefactorHelloService;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback implements RefactorHelloService {


    @Override
    public String hello(String name) {
        return "error";
    }

    @Override
    public User hello(String name, Integer age) {
        return new User("error", 0);
    }

    @Override
    public String hello(User user) {
        return "error";
    }

    @Override
    public String hello() {
        return "error";
    }
}

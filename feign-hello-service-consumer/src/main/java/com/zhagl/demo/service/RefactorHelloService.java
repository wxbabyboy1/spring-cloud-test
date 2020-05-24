package com.zhagl.demo.service;

import com.zhagl.demo.fallback.HelloServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "HELLO-SERVICE", fallback = HelloServiceFallback.class)
public interface RefactorHelloService extends HelloService{
}

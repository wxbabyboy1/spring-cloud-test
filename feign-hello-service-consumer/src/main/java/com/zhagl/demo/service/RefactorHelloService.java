package com.zhagl.demo.service;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("HELLO-SERVICE")
public interface RefactorHelloService extends HelloService{
}

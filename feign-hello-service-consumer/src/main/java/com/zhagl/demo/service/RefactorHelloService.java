package com.zhagl.demo.service;

import com.zhagl.demo.configuration.DisableHystrixConfiguration;
import com.zhagl.demo.configuration.FullLogConfiguration;
import com.zhagl.demo.fallback.HelloServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;

//@FeignClient(value = "HELLO-SERVICE", fallback = HelloServiceFallback.class)
//@FeignClient(value = "HELLO-SERVICE", fallback = HelloServiceFallback.class, configuration = DisableHystrixConfiguration.class)
@FeignClient(value = "HELLO-SERVICE", fallback = HelloServiceFallback.class, configuration = FullLogConfiguration.class)
public interface RefactorHelloService extends HelloService{
}

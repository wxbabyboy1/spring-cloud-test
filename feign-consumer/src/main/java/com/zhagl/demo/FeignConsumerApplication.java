package com.zhagl.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

//开启feign注解
@EnableFeignClients
//服务发现的注解
@EnableDiscoveryClient
@SpringBootApplication
public class FeignConsumerApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(FeignConsumerApplication.class).web(true).run(args);
	}

}

package com.zhagl.demo;

import feign.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

//开启feign注解
@EnableFeignClients
//服务发现的注解
@EnableDiscoveryClient
@SpringBootApplication
public class FeignConsumerApplication {

	/*
	这个是全局配置日志
	@Bean
	Logger.Level feignLoggerLevel(){
		return Logger.Level.FULL;
	}*/

	public static void main(String[] args) {
		new SpringApplicationBuilder(FeignConsumerApplication.class).web(true).run(args);
	}

}

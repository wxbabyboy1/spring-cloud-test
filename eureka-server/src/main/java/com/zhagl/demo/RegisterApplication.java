package com.zhagl.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//服务注册的注解
@EnableEurekaServer
@SpringBootApplication
public class RegisterApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(RegisterApplication.class).web(true).run(args);
	}

}

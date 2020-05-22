package com.zhagl.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//服务注册的注解
@EnableEurekaServer
@SpringBootApplication
public class RegisterPeer2Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(RegisterPeer2Application.class).web(true).run(args);
	}

}

package com.zhagl.demo;

import com.zhagl.demo.filter.AccessFilter;
import com.zhagl.demo.filter.ThrowExceptionFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringCloudApplication
public class ZuulApplication {

	@Bean
	public AccessFilter accessFilter(){
		return new AccessFilter();
	}

	/*@Bean
	public ThrowExceptionFilter exceptionFilter(){
		return new ThrowExceptionFilter();
	}*/

	/*@Bean
	public PatternServiceRouteMapper serviceRouteMapper(){
		return new PatternServiceRouteMapper(
			"(?<name>^.+)-(?<version>v.+$)",
			"${version}/${name}"
		);
	}*/

	public static void main(String[] args) {
		new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
	}

}

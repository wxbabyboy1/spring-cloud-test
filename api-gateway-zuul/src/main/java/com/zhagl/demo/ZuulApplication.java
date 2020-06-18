package com.zhagl.demo;

import com.netflix.zuul.FilterProcessor;
import com.zhagl.demo.configuration.DidiErrorAttributes;
import com.zhagl.demo.filter.AccessFilter;
import com.zhagl.demo.filter.ErrorExtFilter;
import com.zhagl.demo.filter.ErrorFilter;
import com.zhagl.demo.filter.ThrowExceptionFilter;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
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

	@Bean
	public ThrowExceptionFilter exceptionFilter(){
		return new ThrowExceptionFilter();
	}

	@Bean
	public ErrorFilter errorFilter(){
		return new ErrorFilter();
	}

	@Bean
	public DefaultErrorAttributes errorAttributes(){
		return new DidiErrorAttributes();
	}

	/*@Bean
	public PatternServiceRouteMapper serviceRouteMapper(){
		return new PatternServiceRouteMapper(
			"(?<name>^.+)-(?<version>v.+$)",
			"${version}/${name}"
		);
	}*/

	public static void main(String[] args) {
//		FilterProcessor.setProcessor(new DidiFilterProcessor());
		new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
	}

}

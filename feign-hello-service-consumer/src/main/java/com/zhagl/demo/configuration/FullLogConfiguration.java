package com.zhagl.demo.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//这是指定日志
@Configuration
public class FullLogConfiguration {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;//有四种配置：NONE、BASIC、HEADERS、FULL
    }
}

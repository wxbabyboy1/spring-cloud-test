//package com.zhagl.test;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.cloud.stream.annotation.rxjava.EnableRxJavaProcessor;
//import org.springframework.cloud.stream.annotation.rxjava.RxJavaProcessor;
//import org.springframework.context.annotation.Bean;
//
//@EnableRxJavaProcessor
//public class App1_1 {
//
//    private static Logger logger = LoggerFactory.getLogger(App1_1.class);
//
//    @Bean
//    public RxJavaProcessor<String, String> processor(){
//        return inputStream -> inputStream.map(data -> {
//            logger.info("Received: " + data);
//            return data;
//        }).map(data -> String.valueOf("From Input Channel Return - " + data));
//    }
//}

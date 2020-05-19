# spring-cloud-test
Spring Cloud微服务实战的代码练习

1.DemoApplication:这个是基本的启动类，回顾一下spring-boot的启动类

2.RegisterApplication：这个是服务注册的启动类，eureka，咱们开始吧！

启动后，页面输入：http://localhost:1111
页面显示注册中心页面。此时没有服务提供住进行注册，注册中心是空的


作为注册中心的核心：

pom的spring-cloud-starter-eureka-server

启动类的注解@EnableEurekaServer


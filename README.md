# spring-cloud-test
Spring Cloud微服务实战的代码练习

1.eureka-server：第一个项目，用作服务注册中心，启动类RegisterApplication（DemoApplication类是springboot的启动类，回忆一下spring），页面输入：http://localhost:1111
页面显示注册中心页面。

2.server-provide：服务提供者，注册到注册中心里。

3.高可用的注册中心：eureka-server-peer1、eureka-server-peer2，启动类RegisterPeer1Application，启动类RegisterPeer2Application，
页面输入：http://peer1:1111，http://peer2:1112页面显示注册中心页面。
同时将server-provide启动类启动，就注册成功了。
如果关闭RegisterPeer1Application，http://peer2:1112还在，关闭RegisterPeer2Application，http://peer1:1111还在。
以及同一个提供者多个端口注册，详情看eureka-server-peer1、eureka-server-peer2的README.md

4.ribbon消费：ribbon-consumer。一定要保证高可用注册中心peer1、peer2启动，服务提供者java -jar启动两个端口，启动类，
页面访问页面输入http://localhost:9000/ribbon-consumer
来消费HELLO-SERVICE这个服务。

5.断路器hystrix：consumer-hystrix

6.feign：feign-consumer。feign整合了ribbon和hystrix，还提供了一种声明式的web服务客户端定义方式。
基于Netlfix Feign实现。
另：
1）feign的继承特性，将接口定义从controller中剥离：
feign-hello-service-api、feign-hello-service-provide、feign-hello-service-consumer三个模块一起使用。
api定义接口和对象，provide服务提供者（实现接口），consumer实现（接口继承api的接口）。
一定要保证高可用注册中心peer1、peer2启动，服务提供者启动类，消费类启动
页面访问页面输入http://localhost:9001/feign-consumer3
2）feign的继承特性，继承了ribbon
3) feign的继承特性，重试机制
4) feign的服务降级
以及全局默认服务降级配置，如果想禁用指定服务的熔断，需要定义DisableHystrixConfiguration类，
并在接口中指明configuration配置(在feign-hello-service-consumer项目里全局配置)
5）设置日志，参考feign-consumer项目，开启日志，主要是logging.level.包名.服务类名=DEBUG。有两种：全局、接口指定configuration。

7.zuul网关：api-gateway-zuul。
1）转发
2）过滤（自定义过滤）
3) 默认路由
自定义路由映射规则
路径匹配
忽略表达式
路由前缀（不同版本可能存在一些bug）
forward本地跳转
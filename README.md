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
1）feign-hello-service-api、feign-hello-service-provide、feign-hello-service-consumer三个模块一起使用。
api定义接口和对象，provide服务提供者（实现接口），consumer实现（接口继承api的接口）。
一定要保证高可用注册中心peer1、peer2启动，服务提供者启动类，消费类启动
页面访问页面输入http://localhost:9001/feign-consumer3
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


feign整合了ribbon和hystrix，还提供了一种声明式的web服务客户端定义方式。
基于Netlfix Feign实现。

1.pom加入spring-cloud-starter-feign
2.启动类开启feign注解：EnableFeignClients
3.serviec的接口开启注解FeignClient，接口声明服务提供者的方法和requestMapping，参数等。
controller直接加载这个service的接口就可以了。
4.注意：
  1）前面要启动高可用注册中心：peer1和peer2
  2）前面要服务提供者注册：要用java -jar的形式启动provide项目，两个端口1111，1112。咱们在配置文件里服务名是HELLO-SERVICE
  3）这个项目来消费这个HELLO-SERVICE，启动类
  
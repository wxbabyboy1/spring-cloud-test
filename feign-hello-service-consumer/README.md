1.这个要引用feign-hello-service-api的pom，因为api自定义了dto。
2.RefactorHelloService接口继承HelloService接口。用注解FeignClient
3.ConsumerController写实际方法。

1）feign的继承特性，将接口定义从controller中剥离：
feign-hello-service-api、feign-hello-service-provide、feign-hello-service-consumer三个模块一起使用。
api定义接口和对象，provide服务提供者（实现接口），consumer实现（接口继承api的接口）。
一定要保证高可用注册中心peer1、peer2启动，服务提供者启动类，消费类启动
页面访问页面输入http://localhost:9001/feign-consumer3
2）feign的继承特性，继承了ribbon，看这个模块中的ribbon全局和指定HELLO-SERVICE的设置
3) feign的继承特性，重试机制：看这个项目的String hello()方法，重试几次后才报错。
（跟自己设置的MaxAutoRetries=1，MaxAutoRetriesNextServer=2有关系）
4) feign的服务降级：feign无法像@HystrixCommand注解的fallback参数那样指定具体的服务降级方法。
但是feign提供了另外一种简单的定义方式：HelloServiceFallback实现RefactorHelloService接口，并且注解指明fallback。
注意：
   （1）默认降级是关闭的feign.hystrix.enabled要设置为true。
   （2）api的HelloService接口，上面不能有RequestMapping注解，不然会出现错误：Ambiguous mapping. Cannot map xxx method.
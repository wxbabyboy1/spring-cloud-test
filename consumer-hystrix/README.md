断路器：
在微服务架构中，存在着那么多的服务单元，如果一个单元出现故障，很容易因依赖关系而引发故障的蔓延，最终导致整个
系统的瘫痪。为了解决这样的问题，产生了断路器等一系列的服务保护机制。

1.一个是pom
2.启动类开启断路注解EnableCircuitBreaker
3.方法加上断路注解HystrixCommand，指明失败保护方法fallbackMethod
4.将ribbon-consumer项目中类似的restTemplate相关方法放到service里，controller里调用service。
5.注意：
  1）前面要启动高可用注册中心：peer1和peer2
  2）前面要服务提供者注册：要用java -jar的形式启动provide项目，两个端口1111，1112。咱们在配置文件里服务名是HELLO-SERVICE
  3）这个项目来消费这个HELLO-SERVICE
  4）可关闭peer1或者peer2（命令行启动的8081，8082），此时断路器的fallbackMethod就会输出error了。
  5)另外，模拟服务堵塞（长时间未响应）的情况。调用方法helloWait，服务默认有超时，多刷新几次就会出来正确的信息（大多数是error）。
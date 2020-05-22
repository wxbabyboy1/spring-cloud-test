1.注意@Bean、@LoadBalanced注解
2.ConsumerController里访问HELLO-SERVICE服务
3.启动类
4.页面输入http://localhost:9000/ribbon-consumer，能看到消费了：Hello World!host:ZhaGuolong-PC,service_id:hello-service
注意：
1）前面要启动高可用注册中心：peer1和peer2
2）前面要服务提供者注册：要用java -jar的形式启动provide项目，两个端口1111，1112。咱们在配置文件里服务名是HELLO-SERVICE
3）这个项目的ribbon来消费这个HELLO-SERVICE
5.可以在ribbon-consumer的控制台，看到 c.n.l.DynamicServerListLoadBalancer      : DynamicServerListLoadBalancer for client HELLO-SERVICE initialized: DynamicServerListLoadBalancer:{NFLoadBalancer:name=HELLO-SERVICE,current list of Servers=[ZhaGuolong-PC:8081, ZhaGuolong-PC:8082]
这是输出了HELLO-SERVICE的服务列表情况，Ribbon按照此信息进行轮询。
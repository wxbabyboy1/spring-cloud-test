1）springboot和rabbitmq整合：简单的快速发送、接收消息例子
1.先安装rabbitmq，用户名springcloud，密码123456
2.代码创建生产者Sender、接收者receiver、配置config、主类helloApplication，测试类HelloApplicationTests
3.在rabbitmq的web页面，建立queue，名称hello。
4.启动主类。
5.启动测试类。
能看到测试类输出：Sender:helloThu Jun 18 13:53:46 CST 2020
主类输出：Receiver:helloThu Jun 18 13:53:46 CST 2020

2)手动刷新config远程仓库配置。
将config远程仓库和rabbitmq整合，在config-client项目：
1.加入依赖：spring-cloud-starter-bus-amqp
2.加入rabbit的配置，在bootstrap.properties里。
3.分别启动eureka-server-peer1、eureka-server-peer2、
config-server、config-client（两个，一个7002，一个7003）的主类。
发现config-client的输出多了：/bus/refresh],methods=[POST]
4.然后访问config-client的from请求，返回didispace-dev.properties的from属性。
接着，修改config-repo/didispace-dev.properties中的from属性值，并发送post请求到其中的一个/bus/refresh。
http://localhost:7002/bus/refresh
这样可以手动刷新
(如果post出现401，需要将management.security.enabled设置为false，不要用户名密码)
最后再分别访问启动的两个config-client的/from请求，此时两个请求都会返回最新的from属性值。


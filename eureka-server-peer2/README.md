高可用注册中心，同时启动peer1和peer2注册中心
1.hostname为peer2，端口1112，高可用指向peer1，端口1111
2.在host，比如windows的/etc/hosts中配置：
127.0.0.1 peer1
127.0.0.1 peer2
3.同时启动peer1，peer2，访问http://localhost:1111/，和http://localhost:1112/
可以看见DS Replicas分别有peer1、peer2
4.服务提供者，修改eureka.client.serviceUrl.defaultZone  : http://peer1:1111/eureka/,http://peer2:1112/eureka/
启动，但是这是单个服务提供住注册
5.如果想要一个服务多个端口，那maven pacakage下，得到jar包，找到路径，
在不同命令行输入：
java -jar server-provide-1.5.2.RELEASE.jar --server.port=8081
java -jar server-provide-1.5.2.RELEASE.jar --server.port=8082
此时注册了一个服务，2个端口。
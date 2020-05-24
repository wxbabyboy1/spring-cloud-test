这个api定义了dto的User对象
定义了接口HelloService
然后被feign-hello-service-provide依赖，实现HelloService这个接口，和User对象。

1）feign的继承特性，将接口定义从controller中剥离：
feign-hello-service-api、feign-hello-service-provide、feign-hello-service-consumer三个模块一起使用。
api定义接口和对象，provide服务提供者（实现接口），consumer实现（接口继承api的接口）。
一定要保证高可用注册中心peer1、peer2启动，服务提供者启动类，消费类启动
页面访问页面输入http://localhost:9001/feign-consumer3
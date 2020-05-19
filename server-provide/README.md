注册中心启动后（eureka-server这个module），页面输入：http://localhost:1111
页面显示注册中心页面。此时没有服务提供住进行注册，注册中心是空的。
server-provide这个module启动，刷新页面，注册中心上有服务注册了：HELLO-SERVICE

作为服务提供者的核心：

pom的spring-cloud-starter-eureka

启动类的注解@EnableDiscoveryClient


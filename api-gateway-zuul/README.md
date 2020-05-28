zuul转发配置：
1.启动类加入EnableZuulProxy、SpringCloudApplication注解
2.pom加入spring-cloud-starter-zuul
3.配置文件指明访问路径path和转发url，
页面访问：http://localhost:5555/api-a-url/feign-consumer3，转发到http://localhost:5555/api-a-url/feign-consumer3
4.pom加入spring-cloud-starter-eureka，配置加上api-b、api-c，以及eureka配置
一定要保证高可用注册中心peer1、peer2启动，feign-hello-service-provide服务提供者启动类，feign-hello-service-consumer消费类启动
注册中心有hello-service、feign-consumer、api-gateway
页面访问页面输入：
http://localhost:5555/api-b/hello4?name=1
http://localhost:5555/api-c/feign-consumer3
可以发现服务被转发了。

zuul的过滤：
1.添加自定义过滤器AccessFilter，并且在启动类中加入accessFilter方法加载这个过滤器
页面访问页面输入：
http://localhost:5555/api-b/hello4?name=1
http://localhost:5555/api-c/feign-consumer3
发现返回401错误。
加入accessToken=token后，页面输入：
http://localhost:5555/api-a-url/feign-consumer3?accessToken=token
http://localhost:5555/api-b/hello4?name=1&accessToken=token
服务被转发。
2.默认路由：
输入下面：
http://localhost:5555/hello-service/hello4?name=1
发现直接转发了。因为默认情况下，注册中心上的所有服务都被创建了默认路由。
如果要禁止这种默认路由，需要设置zuul.ignored-services=hello-service，
此时刷新页面，发现无法转发了（因为设置了zuul.ignored-services，等号右边可以为*,那代表禁止所有默认路由）。




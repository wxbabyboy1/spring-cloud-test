zuul转发配置：
1.启动类加入EnableZuulProxy、SpringCloudApplication注解
2.pom加入spring-cloud-starter-zuul
3.配置文件指明访问路径path和转发url，
页面访问：http://localhost:5555/api-a-url/feign-consumer3，转发到http://localhost:5555/api-a-url/feign-consumer3
4.pom加入spring-cloud-starter-eureka，配置加上api-b、api-c，以及eureka配置
一定要保证高可用注册中心peer1、peer2启动，feign-hello-service-provide服务提供者启动类，feign-hello-service-consumer消费类启动，zuul启动类启动
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
3.自定义路由映射规则
启动类自定义PatternServiceRouteMapper的构造方法（我没试验）
4.路径匹配，比如/user-service/**和/user-service/ext/**，
有可能/user-service/ext/hello会被/user-service/**匹配到，因为application.properties无法保证有序，
所以要用application.yml来保证有序的路由规则。
5.忽略表达式：
配置：zuul.routes.ignored-patterns=/**/hello7/**
此时访问下面：
http://localhost:5555/api-b/hello7?accessToken=token
就会无法路由到了。后台日志打出：No route found for uri: /api-b/hello7
6.路由前缀：（书中提到不同版本可能存在一些bug，我没实现）
7.forward本地跳转：
zuul.routes.url=forward:/tt
其中tt是本地方法，页面访问http://localhost:5555/api-d-url?a=18可以跳转到本地(连自定义过滤器都没走)
8.过滤器的执行周期pre、routing、post、以及三者报错的时候都会进入的error。
自定义了一个ThrowExceptionFilter模拟error。
自定义ErrorFilter，将ThrowExceptionFilter的错误捕获。
9.捕获异常有两种，一种是try-catch，一种是error过滤器。对于pre、route、post来说，
是这么处理的:
如果是post，那ErrorFilter里error.*参数就不会被SendErrorFilter来处理。
因为SendErrorFilter里有error.*参数。
try{
    preRoute();
} catch(ZuulException e){
    error(e);
    postRoute();
    return;
}
try{
    route();
} catch(ZuulException e){
    error(e);
    postRoute();
    return;
}
try{
    postRoute();
} catch(ZuulException e){
    error(e);
    return;
}
所以要解决post后error.*参数不会被SendErrorFilter来处理的问题：
定义了ErrorExtFilter（这里有component注解）和DidiFilterProcessor，前者是将上下文中存储的异常实例读取并判断是否来自post，
后者是继承核心处理类将异常实例存储，被前者来读取。
并且要在启动类中加入FilterProcessor.setProcessor(new DidiFilterProcessor());
配合ThrowExceptionFilter类中设置post来测试。
10.如果不采用重写过滤器的方式，依然想要使用SendErrorFilter来处理异常返回的话，如果定制返回的响应结果呢？
通过getErrorAttributes方法来定义，参考类ErrorMvcAutoConfiguration、DidiErrorAttributes，
以及启动类加入：
@Bean
public DefaultErrorAttributes errorAttributes(){
    return new DidiErrorAttributes();
}
	

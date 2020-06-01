config-client客户端，调用config-server服务端读取远处git仓库的配置文件
1.pom依赖spring-boot-starter-web、spring-cloud-starter-config
2.配置bootstrap.properties，设置读取config-server服务端
3.TestController和TestController2，一个是通过注解from读取，一个是通过环境变量读取
注意，这两个类都是读取from配置，所以不能同时打开，有一个要注释掉。
4.启动config-server、config-client的启动类
访问http://localhost:7002/from
可以修改bootstrap.properties，读取不同配置
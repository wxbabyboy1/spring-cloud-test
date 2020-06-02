config-server服务端，在git上建立仓库。然后本地服务端启动，浏览器可以访问到
1.pom引入依赖：spring-cloud-config-server
2.启动类加入注解EnableConfigServer
3.git上建立仓库（我创建了spring-cloud-test-config-server作为仓库），并配置不同类型的文件，比如didispace-dev.properties等。
4.在这个项目指明uri、username、password、search-paths
5.启动类，按照下面规则，在浏览器访问
Spring Cloud Config 有它的一套访问规则，我们通过这套规则在浏览器上直接访问就可以。
/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties
其中：（比如git仓库上的didispace-dev.properties文件）
{application} 就是应用名称(比如didispace)，对应到配置文件上来，就是配置文件的名称部分，例如我上面创建的配置文件。
{profile} 就是配置文件的版本(比如prod)，我们的项目有开发版本、测试环境版本、生产环境版本，对应到配置文件上来就是以 application-{profile}.yml 加以区分，例如application-dev.yml、application-sit.yml、application-prod.yml。
{label} 表示 git 分支(比如config-label-test)，默认是 master 分支，如果项目是以分支做区分也是可以的，那就可以通过不同的 label 来控制访问不同的配置文件了。
比如：
http://localhost:7001/didispace/prod
http://localhost:7001/didispace/prod/master
http://localhost:7001/didispace/prod/config-label-test
http://localhost:7001/didispace-qas.yml
http://localhost:7001/config-label-test/didispace-qas.yml
http://localhost:7001/didispace-prod.properties
http://localhost:7001/config-label-test/didispace-prod.properties
同时在日志看到从git获取配置信息后，复制了一份在本地存储。
在本地暂存，可以有效防止当git仓库出现故障而引起无法加载配置信息的情况。
我们可以通过断开网络，再起发起http://localhost:7001/didispace/prod/config-label-test请求，
虽然控制台提示无法从远处获取，但依然会返回配置信息（本地）
6.访问本地的git仓库测试：
uri要加上(一定要是git仓库，带有.git的)file:
指明根目录search-paths
我在这里弄了个feifei-qas.yml
访问浏览器：http://localhost:7001/feifei/qas
成功。
7.多仓库
8.svn仓库，（我觉得用不到了。。）
9.开启本地资源，不使用git或svn，需要配置spring.profiles.active=native
和spring.cloud.config.server.native.searchLocations指定（我试过不用classpath，不生效）

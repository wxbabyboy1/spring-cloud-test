快速入门示例：
1.加入依赖：spring-boot-starter-web、spring-boot-starter-test、spring-cloud-starter-stream-rabbit
2.建立SinkReceiver消费者、StreamHelloApplication启动类。
3.启动rabbitmq，启动StreamHelloApplication主类。可以看到：delegate=amqp://guest@127.0.0.1:5672/, localPort= 63918
4.在web页面connections，Queue input.anonymous.e9ejUaLFSbWOcNrQZSfF7w，Payload发送一个消息：send a message
就可以在控制台看到Received:[B@b525ff1

核心概念：inputs、Binder、outputs。其中绑定器Binder是Spring Cloud Stream中非常重要的概念。
对于将来升级或更换消息中间件，由于暴露统一的Channel通道，只需要更改它们对应的Binder绑定器而不需要修改Spring Boot的应用逻辑。
RabbitMQ和Kafka提供了默认的Binder实现。

这个项目没有application.yml或者application.yml，因为默认提供了RabbitMQ的自动化配置，
也可以创建application.yml或者application.yml，在里面配置input通道和rabbitmq的配置。

stream中的消息通信方式是：发布—订阅模式。
当一条消息被投递到消息中间件之后，它会通过共享的Topic主题进行广播，
比如Rabbitmq的exchange，kafka的topic。
可以在rabbitmq的web页面，exchanges下看到bindings。

消费组
消息分区

Sink定义了@Input，Source定义了@Output，
而Processor通过集成Source和Sink的方式同时定义了一个输入通道和一个输出通道。

注册绑定接口：
1.建立接口SinkSender，改造SinkReceiver的EnableBinding注解为@EnableBinding({Sink.class, SinkSender.class})，
写一个测试类HelloApplicationTests发送一个消息。
运行测试类，能看到Received:From SinkSender

注册消息通道：
2.写一个测试类HelloApplicationTests2可以实现同SinkSender一样目的操作，测试类里的MessageChannel。
打开SinkReceiver类的第一个注解EnableBinding。
运行测试类，可以看到Received:From MessageChannel

如果创建很多个不同名的MessageChannel实例，那就要保证一致，
比如sender_example包里的MySource、OutputSender类（注解Qualifier指出用哪个MySource.class的MessageChannel）。

Spring Integration原生支持：
3.通过Spring Integration原生的注解实现实现同SinkSender一样目的操作。
建立新类SinkSender2(接收还用SinkReceiver)、HelloApplicationTests3。
启动HelloApplicationTests3，能在控制台看到：
Received:Tue Jun 30 11:31:26 CST 2020
这里：Poller指明频率，毫秒
按理来说应该有Received:Tue Jun 30 11:31:26 CST 2020这样的很多个，但我实验就一个出来。
替换注解StreamListener为ServiceActivator，增加注解Transformer方法，此时转换接收格式为时间格式化。

消息转换
注解StreamListener和注解ServiceActivator都实现了对输入消息通道的监听，但注解StreamListener相比注解ServiceActivator更强大，
注解StreamListener内置了一系列的消息转换功能。
（我实验没有成功。。）注解ServiceActivator需要transform注解转换，但注解StreamListener自动转换了，默认在接收和发送消息时对应的消息格式类型都是JSON格式。
4.修改SinkSender2类，改成传送对象User。

消息反馈
有时候在处理完输入消息之后，需要反馈一个消息给对方，可以通过@SendTo注解指定返回内容的输出通道。
5.建立两个module，stream-hello-app1和stream-hello-app2，引入相关依赖，分别建立类App1和App2以及相关启动类。
App1对input输入通道监听，接收消息后，加工后通过@SendTo发给output通道。
App2是App1中input通道的生产者和output通道的消费者。
同时运行App1的启动类和App2的启动类，启动App2的test方法。
此时控制台看到：
Received:Tue Jun 30 17:30:29 CST 2020
Received:From Input Channel Return -- Tue Jun 30 17:30:29 CST 2020
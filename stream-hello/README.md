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




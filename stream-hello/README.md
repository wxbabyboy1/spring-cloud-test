1.加入依赖：spring-boot-starter-web、spring-boot-starter-test、spring-cloud-starter-stream-rabbit
2.建立SinkReceiver消费者、HelloApplication启动类。
3.启动主类。可以看到：delegate=amqp://guest@127.0.0.1:5672/, localPort= 63918
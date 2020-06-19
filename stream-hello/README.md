1.加入依赖：spring-boot-starter-web、spring-boot-starter-test、spring-cloud-starter-stream-rabbit
2.建立SinkReceiver消费者、启动类。
3.启动主类。可以看到：delegate=amqp://guest@127.0.0.1:5672/, localPort= 63918
4.在web页面connections，Queue input.anonymous.e9ejUaLFSbWOcNrQZSfF7w，Payload发送一个消息：send a message
就可以在控制台看到Received:[B@b525ff1
1）springboot和rabbitmq整合：简单的快速发送、接收消息例子
1.先安装rabbitmq，用户名springcloud，密码123456
2.代码创建生产者Sender、接收者receiver、配置config、主类helloApplication，测试类HelloApplicationTests
3.在rabbitmq的web页面，建立queue，名称hello。
4.启动主类。
5.启动测试类。
能看到测试类输出：Sender:helloThu Jun 18 13:53:46 CST 2020
主类输出：Receiver:helloThu Jun 18 13:53:46 CST 2020



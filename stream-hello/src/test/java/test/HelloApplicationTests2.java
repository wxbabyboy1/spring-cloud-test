package test;


import com.zhagl.test.StreamHelloApplication;
import com.zhagl.test.receiver.SinkSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

//较新版的Spring Boot取消了@SpringApplicationConfiguration这个注解，用@SpringBootTest就可以了
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StreamHelloApplication.class)
@WebAppConfiguration
public class HelloApplicationTests2 {

    @Autowired
    private MessageChannel input;

    @Test
    public void contextLoads() {
        input.send(MessageBuilder.withPayload("From MessageChannel").build());
    }
}

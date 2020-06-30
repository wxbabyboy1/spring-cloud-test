package test;


import com.zhagl.test.StreamHelloApplication;
import com.zhagl.test.receiver.SinkSender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

//较新版的Spring Boot取消了@SpringApplicationConfiguration这个注解，用@SpringBootTest就可以了
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StreamHelloApplication.class)
@WebAppConfiguration
public class HelloApplicationTests3 {

    @Autowired
    private SinkSender2 sinkSender2;

    @Test
    public void contextLoads() {
        sinkSender2.timeMessageSource();
    }
}

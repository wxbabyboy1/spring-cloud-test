package test;


import com.zhagl.test.App2;
import com.zhagl.test.StreamHelloApp2Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

//较新版的Spring Boot取消了@SpringApplicationConfiguration这个注解，用@SpringBootTest就可以了
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StreamHelloApp2Application.class)
@WebAppConfiguration
public class HelloApplicationTests {

    @Autowired
    private App2 app2;

    @Test
    public void contextLoads() {
        app2.timeMessageSource();
    }
}

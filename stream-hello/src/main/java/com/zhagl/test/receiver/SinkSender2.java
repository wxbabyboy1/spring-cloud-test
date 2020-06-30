package com.zhagl.test.receiver;

import com.zhagl.test.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

@EnableBinding(value = {SinkSender2.SinkOutput.class})
public class SinkSender2{
    private static Logger logger = LoggerFactory.getLogger(SinkSender2.class);

//    @Bean
//    @InboundChannelAdapter(value = SinkOutput.OUTPUT, poller = @Poller(fixedDelay = "2000"))
//    public MessageSource<Date> timeMessageSource(){
//        return () -> new GenericMessage<>(new Date());
//    }

    @Bean
    @InboundChannelAdapter(value = SinkOutput.OUTPUT, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<User> timeMessageSource(){
//        return () -> new GenericMessage<>("{\"name\":\"didi\", \"age\":30}");
        return () -> new GenericMessage<>(new User("didi", 30));
    }

    public interface SinkOutput {
        String OUTPUT = "input";

        @Output(SinkOutput.OUTPUT)
        MessageChannel output();
    }
}

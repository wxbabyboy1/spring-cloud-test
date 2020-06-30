package com.zhagl.test.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;


//@EnableBinding(Sink.class)
@EnableBinding({Sink.class, SinkSender.class})
public class SinkReceiver {
    private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

    @StreamListener(Sink.INPUT)
    public void receive(Object payload){
        logger.info("Received:"+payload);
    }

    /** 下面两个是一套
    @ServiceActivator(inputChannel = Sink.INPUT)
    public void receive(Object payload){
        logger.info("Received:"+payload);
    }

    @Transformer(inputChannel = Sink.INPUT, outputChannel = Sink.INPUT)
    public Object transform(Date message){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message);
    }  */
}

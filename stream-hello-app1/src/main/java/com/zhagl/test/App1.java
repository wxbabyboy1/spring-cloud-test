package com.zhagl.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.ServiceActivator;

@EnableBinding(value = Processor.class)
public class App1 {

    private static Logger logger = LoggerFactory.getLogger(App1.class);

//    @StreamListener(Processor.INPUT)
//    @SendTo(Processor.OUTPUT)
    @ServiceActivator(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
    public Object receiveFromInput(Object payload){
        logger.info("Received:" + payload);
        return "From Input Channel Return -- " + payload;
    }
}

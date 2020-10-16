package com.tqq.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author ： tqq
 * @date ： 2020/10/15 11:15
 * @Description:
 */
@EnableBinding(Sink.class)
public class MsgReceiver {
    public final static Logger logger = LoggerFactory.getLogger(MsgReceiver.class);
    @StreamListener(Sink.INPUT)
    public void receive(Object payload){
        logger.info("Received:"+payload);

    }
}

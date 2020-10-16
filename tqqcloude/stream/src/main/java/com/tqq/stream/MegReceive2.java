package com.tqq.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author ： tqq
 * @date ： 2020/10/15 12:13
 * @Description:
 */
@EnableBinding(MyChannel.class)
public class MegReceive2 {
    public final static Logger logger = LoggerFactory.getLogger(MegReceive2.class);

    @StreamListener(MyChannel.INPUT)
    public void receive(Object payload){
        logger.info("received2:"+payload);
    }
}

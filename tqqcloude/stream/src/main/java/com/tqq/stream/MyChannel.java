package com.tqq.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author ： tqq
 * @date ： 2020/10/15 12:08
 * @Description:
 */
public interface MyChannel {
    String INPUT = "tqq-input";
    String OUTPUT = "tqq-output";

    @Output(OUTPUT)
    MessageChannel output();
    @Input(INPUT)
    SubscribableChannel input();
}

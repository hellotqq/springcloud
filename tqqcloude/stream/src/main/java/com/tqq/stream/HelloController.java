package com.tqq.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ： tqq
 * @date ： 2020/10/15 12:15
 * @Description:
 */
@RestController
public class HelloController {
    @Autowired
    MyChannel myChannel;
    @GetMapping("/hello")
    public void hello(){
        myChannel.output().send(MessageBuilder.withPayload("hello spring cloud stream!").build());
    }
}

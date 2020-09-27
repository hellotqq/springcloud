package com.tqq.consulprovider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ： tqq
 * @date ： 2020/9/27 9:56
 * @Description:
 */
@RestController
public class HelloController {
    @Value("${server.port}")
    Integer port;
    @GetMapping("/hello")
    public String HelloController(){
        return "hello>>"+port;
    }
}

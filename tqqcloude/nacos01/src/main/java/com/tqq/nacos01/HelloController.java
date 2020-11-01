package com.tqq.nacos01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ： tqq
 * @date ： 2020/11/1 10:04
 * @Description:
 */
@RestController
public class HelloController {
    @Value("${server.port}")
    Integer port;
    @GetMapping("/hello")
    public String hello(){
        return  "hello"+port;
    }
}

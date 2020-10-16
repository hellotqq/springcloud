package com.tqq.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ： tqq
 * @date ： 2020/9/30 9:37
 * @Description:
 */
@RestController
@RefreshScope
public class HelloController {
    @Value("${tqq}")
    String tqq;
    @GetMapping("/hello")
    public String hello(){
        return tqq;
    }
}

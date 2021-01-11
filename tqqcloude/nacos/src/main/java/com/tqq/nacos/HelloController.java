package com.tqq.nacos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ： tqq
 * @date ： 2020/11/1 9:40
 * @Description:
 */
@RestController
@RefreshScope
public class HelloController {
    @Value("${name}")
    String name;

    @GetMapping("/hello")
   public String hello(){
        System.out.println(name);
        return name;
    }
}

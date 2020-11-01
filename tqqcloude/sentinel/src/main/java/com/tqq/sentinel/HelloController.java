package com.tqq.sentinel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ： tqq
 * @date ： 2020/11/1 17:24
 * @Description:
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello sentinel";
    }
}

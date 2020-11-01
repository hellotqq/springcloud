package com.tqq.nacos02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ： tqq
 * @date ： 2020/11/1 10:18
 * @Description:
 */
@RestController
public class HelloController {
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/hello")
    public String hello(){
        return restTemplate.getForObject("http://nacos01/hello",String.class);
    }
}

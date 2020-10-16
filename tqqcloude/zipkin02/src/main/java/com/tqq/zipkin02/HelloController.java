package com.tqq.zipkin02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ： tqq
 * @date ： 2020/10/16 12:02
 * @Description:
 */
@RestController
public class HelloController {
    public final static Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/hello")
    public void hello(){
        String s = restTemplate.getForObject("http://localhost:8080/hello?name={1}", String.class, "tqq");
        logger.info(s);

    }
}

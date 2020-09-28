package com.tqq.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

/**
 * @author ： tqq
 * @date ： 2020/9/27 15:05
 * @Description:
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "error")
    public String hello(){
        int i =  1/ 0;

        return restTemplate.getForObject("http://provider/hello",String.class);
    }
    @HystrixCommand(fallbackMethod = "error")
    public Future<String> hello2(){
        return new AsyncResult<String>(){
            @Override
            public String invoke() {
                return restTemplate.getForObject("http://provider/hello",String.class);
            }
        };
    }
    public String error(Throwable t){
        return "error"+t.getMessage();
    }
}

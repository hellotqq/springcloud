package com.tqq.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author ： tqq
 * @date ： 2020/9/27 15:07
 * @Description:
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;
    @GetMapping("/hello")
    public  String hello(){
        return helloService.hello();
    }
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/hello2")
    public  void hello2(){
        HelloCommand helloCommand = new HelloCommand(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("tqq")), restTemplate);
        String execute = helloCommand.execute();//直接执行
        System.out.println(execute);
        HelloCommand helloCommand2 = new HelloCommand(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("tqq")), restTemplate);
        try {
            Future<String> queue = helloCommand2.queue();
            String s =  queue.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    @GetMapping("/hello3")
    public void hello3(){
        Future<String> hello2 = helloService.hello2();
        try {
            String s = hello2.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

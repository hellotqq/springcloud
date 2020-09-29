package com.tqq.openfreign1;

import com.tqq.commoms.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author ： tqq
 * @date ： 2020/9/28 11:00
 * @Description:
 */
@RestController
public class HelloController {
    @Autowired
    Hello1Service helloService;

    @GetMapping("/hello")
    public String hello(){
        return helloService.hello();
    }
    @GetMapping("/hello2")
    public String hello2() throws UnsupportedEncodingException {
        String s = helloService.hello2("田壮壮");
        System.out.println(s);
        User user = new User();
        user.setId(1);
        user.setUsername("tqq");
        user.setPassword("123");
        User u = helloService.addUser2(user);
        System.out.println(u);
        helloService.deleteUser2(1);
        helloService.getUserByName(URLEncoder.encode("田强强","UTF-8"));
        return helloService.hello();
    }

}

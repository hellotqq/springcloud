package com.tqq.openfreign1;

import com.tqq.commoms.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author ： tqq
 * @date ： 2020/9/28 10:58
 * @Description:
 */
@FeignClient("provider")
public interface HelloService {
    @GetMapping("/hello")
    String hello();//这里的方法名无所谓
    @GetMapping("/hello2")
    String hello2(@RequestParam("name") String name);
    @PostMapping("/user2")
    User addUser(@RequestBody User user);
    @DeleteMapping("/user2/{id}")
    void deleteUserById(@PathVariable("id") Integer id);
    @GetMapping("/user3")
    void getUserByName(@RequestHeader("name") String name);
}

package com.tqq.provider;

import com.tqq.api.IUserService;
import com.tqq.commoms.User;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

/**
 * @author ： tqq
 * @date ： 2020/9/25 14:21
 * @Description:
 */
@RestController
public class HelloController implements IUserService {
    @Value("${server.port}")
    Integer port;
    @Override
    public String hello(){
        return "hello tqq:"+port;
    }
    @Override
    public String hello2(String name){
        System.out.println(new Date()+">>>"+name);
        return "hello"+name;
    }
    @PostMapping("/user1")
    public User addUser1(User user){
        return  user;
    }
    @Override
    public User addUser2(@RequestBody  User user){
        return  user;
    }
    @PutMapping("/user1")
    public void updateUser1(User user){
        System.out.println(user);
    }
    @PutMapping("/user2")
    public void updateUser2(@RequestBody  User user){
        System.out.println(user);
    }
    @DeleteMapping("/user1")
    public void deleteUser1(Integer id){
        System.out.println(id);
    }
    @Override
    public void deleteUser2(@PathVariable Integer id){
        System.out.println(id);
    }
    @Override
    public void getUserByName(@RequestHeader("name") String name) throws UnsupportedEncodingException {
        System.out.println(URLDecoder.decode(name,"UTF-8"));
    }
}

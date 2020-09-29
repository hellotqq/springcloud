package com.tqq.openfreign1;

import com.tqq.commoms.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;

/**
 * @author ： tqq
 * @date ： 2020/9/28 16:21
 * @Description:
 */
@Component
@RequestMapping("/tqq")
public class HelloServiceFallBack implements Hello1Service {
    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello2(String name) {
        return "error2";
    }

    @Override
    public User addUser2(User user) {
        return null;
    }

    @Override
    public void deleteUser2(Integer id) {

    }

    @Override
    public void getUserByName(String name) throws UnsupportedEncodingException {

    }
}

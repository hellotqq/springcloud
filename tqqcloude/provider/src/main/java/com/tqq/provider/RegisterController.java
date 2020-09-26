package com.tqq.provider;

import com.tqq.commoms.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.POST;

/**
 * @author ： tqq
 * @date ： 2020/9/26 22:31
 * @Description:
 */
@Controller
public class RegisterController {
    @PostMapping("/register")
    public String register(User user){
        return "redirect:http://provider/loginPage?username="+user.getUsername();
    }
    @GetMapping("/loginPage")
    @ResponseBody
    public String loginPage(String username){
        return "loginPage:"+username;
    }
}

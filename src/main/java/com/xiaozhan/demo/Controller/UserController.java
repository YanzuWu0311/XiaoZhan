package com.xiaozhan.demo.Controller;

import com.xiaozhan.demo.Entities.MyResult;
import com.xiaozhan.demo.Entities.User;
import com.xiaozhan.demo.Entities.Video;
import com.xiaozhan.demo.Service.IUserService;
import com.xiaozhan.demo.Service.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @ResponseBody
    @PostMapping("/login")
    public MyResult login(@RequestBody User user){
        return userService.login(user);
    }
    @ResponseBody
    @PostMapping("/register")
    public MyResult register(@RequestBody User user){
        return userService.register(user);
    }
    @ResponseBody
    @GetMapping("/bannedList")
    public List<User> getBanned(){
        List<User> list = userService.getBannedUser();
        return list;
    }

}

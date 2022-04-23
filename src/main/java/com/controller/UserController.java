package com.controller;


import com.bean.User;
import com.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(value="/user",method = {RequestMethod.GET,RequestMethod.POST})
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/greeting")
    public String greeting() {
        System.out.println("connect successfully");
        return "Hello world";
    }

    @PostMapping("/selectUser")
    public void selectUser(@RequestParam(value = "id") int uid) {
        User user = userService.getUserById(uid);
        System.out.println(user.toString());
    };





}

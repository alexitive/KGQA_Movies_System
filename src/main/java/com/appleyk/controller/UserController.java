package com.appleyk.controller;


import com.appleyk.model.User;
import com.appleyk.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/greeting")
    @ResponseBody
    public String greeting() {
        return "connect successfully";
    }

    @GetMapping("/getuser")
    public User getUser(@RequestParam(value = "id") int id) throws IOException {
        User user = userService.getUserById(id);
        return user;
    };

    /**
     *
     * @return 1-登录验证成功 0-登录失败
     */
    @GetMapping("/login")
    public int logIn(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password) throws IOException {

        try{
            userService.openSql();
        }
        catch (Exception exception) {
            return 0;
        }

        return userService.Login(name, password);

    }

}

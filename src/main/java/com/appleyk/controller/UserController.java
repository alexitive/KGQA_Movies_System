package com.appleyk.controller;


import com.appleyk.model.User;
import com.appleyk.result.LoginResponse;
import com.appleyk.service.QuestionService;
import com.appleyk.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    QuestionService questService;

    @Autowired
    LoginResponse loginResponse;

    @GetMapping("/greeting")
    @ResponseBody
    public String greeting(@RequestParam(value = "userName") String userName,
                           @RequestParam(value = "password") String password) {

        return "connect successfully";
    }

    @GetMapping("/getuser")
    public User getUser(@RequestParam(value = "id") int id) throws IOException {
//    public User getUser() throws IOException {
//        int id = 1;
        User user = userService.getUserById(id);
        return user;
    };

    /**
     * 登录验证
     * @return 1-登录验证成功 0-登录失败
     */
    @GetMapping("/login")
    public LoginResponse logIn(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) throws IOException {
//        Map<String, Integer> map = new HashMap<>();
//        map.put("token", userService.Login(username, password));
//        return map; // {key: token value: 1} 前端识别json
        loginResponse.setToken(userService.Login(username, password));
        loginResponse.setUser(userService.getUserByAccount(username, password));
        System.out.println(loginResponse.toString());
        return loginResponse;
    }

    /**
     * 用户注册
     * @param username 用户名
     * @param password 密码
     * @return 1-注册成功 0-注册失败
     */
    @GetMapping("/signup")
    public Map<String, Integer> signUp(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) throws IOException {
        Map<String, Integer> map = new HashMap<>();

        try{
            userService.openSql();
        }
        catch (Exception exception) {
            map.put("token", 0);
            return map;
        }

        map.put("token", userService.signUp(username, password));
        return map;
    }

    /**
     * 修改密码
     * @param name
     * @param oldpassword
     * @param newpassword
     * @return 1-修改成功 0-修改失败
     */
    @GetMapping("/changepassword")
    public int changepassword(@RequestParam(value = "name") String name,
                              @RequestParam(value = "oldpassword") String oldpassword,
                              @RequestParam(value = "newpassword") String newpassword) {
        return userService.UpdateUserInfo(name, oldpassword, newpassword);
    }

    @GetMapping("/changecomment")
    public int changcomment(@RequestParam(value = "name") String name,
                            @RequestParam(value = "password") String password,
                            @RequestParam(value = "comment") String comment) {
        return userService.ChangeComment(name, password, comment);
    }

    @GetMapping("/getAllUser")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    // 前端检查当前操作用户的权限
//    @GetMapping()
//    public int setAuthority(User user, int newauthority) {
//
//
//    }

    @RequestMapping("/query")
    public Map<String, String> query(@RequestParam(value = "question") String question) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("answer", questService.answer(question));
        return map;
    }

}

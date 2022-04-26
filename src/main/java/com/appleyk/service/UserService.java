package com.appleyk.service;

import com.appleyk.model.User;
import org.springframework.stereotype.Component;

import java.io.IOException;


public interface UserService {

    public User getUserById(int id) throws IOException;

    /**
     *
     * @return 1-登录验证成功 0-登录失败
     */
    public int Login(String name, String password) throws IOException;

}

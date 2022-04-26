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

    /**
     * 用户注册
     * @param name
     * @param password
     * @return 1-注册成功 0-注册失败
     */
    public int signUp(String name, String password) throws IOException;

    /**
     * 用户修改密码
     * @param name
     * @param oldpassword
     * @param newpassword
     * @return
     */
    public int UpdateUserInfo(String name, String oldpassword, String newpassword);

    /**
     * 修改个性签名
     * @param name
     * @param password
     * @param comment
     * @return
     */
    public int ChangeComment(String name, String password, String comment);
}

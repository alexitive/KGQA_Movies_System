package com.appleyk.service.impl;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.appleyk.model.User;
import com.appleyk.mapper.UserMapper;
import com.appleyk.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service // 标记为service
public class UserServiceImpl implements UserService {


    private UserMapper userMapper;

    /**
     * 打开sqlSession
     * @throws IOException
     */
    public void openSql() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true); // true - 自动提交事务
        this.userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Override
    public User getUserByAccount(String name, String password) {
        try {
            openSql();
            return userMapper.getUserByAccount(name, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAllUser() {
        try{
            openSql();
            return userMapper.getAllUser();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过id查询用户
     * @param id
     * @return
     * @throws IOException
     */
    @Override
    public User getUserById(int id) throws IOException {
        openSql();
        User user = userMapper.getUserById(id);
        System.out.println(user.toString());
        return user;
    }

    /**
     * 用户登录
     * @return
     */
    @Override
    public int Login(String name, String password) throws IOException {
        User user = new User();
        try {
            openSql();
            user = userMapper.getUserByAccount(name, password);
        }catch (Exception e) {
            System.out.println("用户登录失败");
            return 0;
        }
        if(user != null) {
            System.out.println("用户登录成功");
            return 1;
        }
        System.out.println("用户登录失败");
        return 0;
    }

    /**
     * 用户注册
     * @param name
     * @param password
     * @return 1-注册成功 0-注册失败
     * @throws IOException
     */
    @Override
    public int signUp(String name, String password) throws IOException {
        try{
            openSql();
            User user = new User();
            user.setName(name);
            user.setPassword(password);
//            if(userMapper.getUserByName(name) != null) return 0;
            userMapper.insertUser(user);
            System.out.println(user);
        }
        catch (Exception e) {
            System.out.println("用户已存在");
            return 0;
        }
        if(userMapper.getUserByAccount(name, password) != null) {
            System.out.println("注册成功");
            return 1; // 数据库中存在此用户
        }
        System.out.println("注册失败");
        return 0;
    }

    /**
     * 修改用户密码
     * @param name
     * @param oldpassword
     * @param newpassword
     * @return 1-修改成功 0-修改失败
     */
    @Override
    public int UpdateUserInfo(String name, String oldpassword, String newpassword) {
        try {
            openSql();
            User user =  userMapper.getUserByName(name);
            System.out.println(user);
            System.out.println("oldpassword:" + oldpassword);
            System.out.println("newpassword:" + newpassword);
            if(user.getPassword().equals(oldpassword)) {
                user.setPassword(newpassword);
                userMapper.updateUserInfo(user);
                System.out.println("修改成功");
                return 1;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("出现异常，修改失败1");
            return 0;
        }
        System.out.println("修改失败2");
        return 0;
    }


    @Override
    public int ChangeComment(String name, String password, String comment) {
        try{
            openSql();
            User user =  userMapper.getUserByName(name);
            user.setComment(comment);
            userMapper.updateUserInfo(user);
            System.out.println("修改成功");
            return 1;
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("出现异常，修改失败");
        }
        return 0;
    }
}

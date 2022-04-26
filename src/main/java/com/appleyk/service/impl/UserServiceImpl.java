package com.appleyk.service.impl;

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
        openSql();
        System.out.println(name);
        System.out.println(password);
        User user = null;
        user = userMapper.getUserByAccount(name, password);
        System.out.println(user);
        if(user != null) {
            System.out.println("return 1");
            return 1;
        }
        System.out.println("reruan 0");
        return 0;
    }
}

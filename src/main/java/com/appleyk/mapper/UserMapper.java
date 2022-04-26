package com.appleyk.mapper;


import com.appleyk.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMapper {

    /**
     * mybatis映射关系：表--实体类--mapper接口--映射文件
     */

    /**
     * 根据用户名字获取id
     * @param name
     * @return
     */
    public int getIdByName(String name);

    /**
     * 通过ID查询用户数据
     * @param id
     * @return 用户对象
     */
    public User getUserById(int id);


    /**
     * 通过用户名和密码获取用户，用于用户登录
     * @param name
     * @param password
     * @return 用户对象
     */
    public User getUserByAccount(String name, String password);

    /**
     * 获取系统所有用户
     * @return
     */
    public List<User> getAllUser();

    /**
     * 新增用户
     * @param user
     */
    public void insertUser(User user);

    /**
     * 用户信息更新
     */
    public void updateUserInfo(User user);

    /**
     * 删除用户
     */
    public void deleteUser(User user);

    /**
     * 设置用户权限
     */
    public void setUserAuthority(int id, int authority);

}

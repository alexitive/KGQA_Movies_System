package com.appleyk.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

//sqlsessionFactory
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;
    static {

        try {
            //使用mybatis获取sqlsessionfactory对象
            String resource = "mybatis-config.xml";
            File file = new File(resource);
            System.out.println(file.exists());
            InputStream inputStream =  Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SqlSession getSqlSession(){
       return sqlSessionFactory.openSession(true);
    }

}

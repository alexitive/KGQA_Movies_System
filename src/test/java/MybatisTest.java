import com.appleyk.model.User;
import com.appleyk.mapper.UserMapper;
import org.junit.Test;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    @Autowired
    UserMapper userMapper;


    @Test
    public void testsetUserAuthority() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true); // true - 自动提交事务
        userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.setUserAuthority(6, 1);

    }

    @Test
    public void testdeleteUser() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true); // true - 自动提交事务
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.getUserByAccount("amy", "xfxfxf");
        userMapper.deleteUser(user);

    }

    @Test
    public void testupdateUserInfo() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true); // true - 自动提交事务
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

//        User user = new User("amy", "amy209821","i am amy");
//        userMapper.insertUser(user);
//        user.setCommment("who am i???");
//        userMapper.updateUserInfo(user);

        User user = userMapper.getUserByAccount("amy", "amy209821");
        System.out.println(user.toString());
        int uid = userMapper.getIdByName("amy");
        user.setPassword("xfxfxf");
        user.setComment("who am i");
        userMapper.updateUserInfo(user);

    }

    @Test
    public void testinserUser() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true); // true - 自动提交事务
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User("钱辰", "qc209821","who am i");
        userMapper.insertUser(user);

        System.out.println(userMapper.getUserByAccount("钱辰", "qc209821"));

    }


    @Test
    public void testgetAllUser() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true); // true - 自动提交事务
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getAllUser();
        userList.forEach(user -> System.out.println(user));
    }

    @Test
    public void testgetUserByAccount() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true); // true - 自动提交事务
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByAccount("张三", "567890");
        System.out.println(user.toString());
    }



    @Test
    public void testMybatis() throws IOException {
        // 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取mapper接口对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.getUserById(8);
        // 提交事务
//        sqlSession.commit();
        System.out.println(user.toString());
    }




}

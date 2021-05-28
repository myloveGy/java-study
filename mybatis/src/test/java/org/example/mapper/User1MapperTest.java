package org.example.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.User;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class User1MapperTest {

    private User1Mapper userMapper;

    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(User1Mapper.class);
    }

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("testUpdate");
        user.setPassword("123456789");
        user.setUpdatedAt(new Date());
        user.setCreatedAt(new Date());
        user.setUserId(9);
        System.out.println(userMapper.insert(user));
    }

    @Test
    public void update() {
        User user = new User();
        user.setUsername("testUpdate123");
        user.setPassword("123456789");
        user.setUpdatedAt(new Date());
        user.setCreatedAt(new Date());
        user.setUserId(7);
        System.out.println(userMapper.update(user));
    }

    @Test
    public void findById() {
        System.out.println(userMapper.findById(1));
    }

    @Test
    public void delete() {
        System.out.println(userMapper.delete(1000));
    }

    @Test
    public void findOrderById() {
        User user = userMapper.findOrderById(1);
        System.out.println(user);
        System.out.println(user.getOrders());
    }

    @Test
    public void findRoleById() {
        User user = userMapper.findRoleById(1);
        System.out.println(user.getRoles());
    }
}
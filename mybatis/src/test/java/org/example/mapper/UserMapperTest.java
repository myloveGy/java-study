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
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserMapperTest {

    private UserMapper userMapper;

    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void findAll() {
        List<User> all = userMapper.findAll();
        System.out.println(all);
    }

    @Test
    public void findOne() {
        User one = userMapper.findOne(1);
        System.out.println(one);
        assertEquals(0, one.getUserId().compareTo(1));
    }

    @Test
    public void findOrderByUserId() {
        List<User> one = userMapper.findOrderByUserId(1);
        for (User user : one) {
            System.out.println(user);
            System.out.println(user.getOrders());
        }
    }

    @Test
    public void findRoleByUserId() {
        List<User> list = userMapper.findRoleByUserId(1);
        for (User user : list) {
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("test123");
        user.setPassword("jinxing.liu");
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        Integer insert = userMapper.insert(user);
        System.out.println(insert);

    }
}
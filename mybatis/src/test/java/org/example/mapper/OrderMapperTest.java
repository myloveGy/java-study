package org.example.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.Order;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class OrderMapperTest {

    private OrderMapper orderMapper;

    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    @Test
    public void findAll() {
        List<Order> all = orderMapper.findAll(null);
        System.out.println(all);
    }

    @Test
    public void findOne() {
        Order one = orderMapper.findOne(1);
        System.out.println(one);
        assertEquals(0, one.getOrderId().compareTo(1));
    }

    @Test
    public void findUserById() {
        Order userById = orderMapper.findUserById(1);
        System.out.println(userById.getUser());

    }
}
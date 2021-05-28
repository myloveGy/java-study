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

public class Order1MapperTest {

    private Order1Mapper order1Mapper;

    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        order1Mapper = sqlSession.getMapper(Order1Mapper.class);
    }

    @Test
    public void findAll() {
        List<Order> all = order1Mapper.findAll();
        for (Order order : all) {
            System.out.println(order);
            System.out.println(order.getUser());
        }
    }

    @Test
    public void findByOrderId() {
        Order order = order1Mapper.findByOrderId(12);
        System.out.println(order);
        System.out.println(order.getUser());
    }
}
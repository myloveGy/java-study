package com.study.my.dao;

import com.study.my.domain.BookUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BookUserMapperTest {

    @Test
    public void findAll() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BookUserMapper bookUserMapper = sqlSession.getMapper(BookUserMapper.class);
        List<BookUser> all = bookUserMapper.findAll();
        System.out.println(all);
    }

    @Test
    public void findOne() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BookUserMapper bookUserMapper = sqlSession.getMapper(BookUserMapper.class);
        BookUser user = bookUserMapper.findOne();
        System.out.println(user);
    }

    @Test
    public void findById() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BookUserMapper bookUserMapper = sqlSession.getMapper(BookUserMapper.class);
        BookUser user = bookUserMapper.findById(5);
        System.out.println(user);
    }

}
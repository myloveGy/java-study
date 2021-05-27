package com.study.my.dao;

import com.study.my.domain.BookUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BookUserMapper1Test {

    @Test
    public void findByCondition() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BookUser bookUser = new BookUser();
        bookUser.setUsername("jinxing.liu");
        bookUser.setId(6);
        BookUserMapper1 bookUserMapper1 = sqlSession.getMapper(BookUserMapper1.class);
        List<BookUser> all = bookUserMapper1.findByCondition(bookUser);
        System.out.println(all);
    }

    @Test
    public void findByIds() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BookUserMapper1 bookUserMapper1 = sqlSession.getMapper(BookUserMapper1.class);

        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(5);
        List<BookUser> listUser = bookUserMapper1.findByIds(list);
        System.out.println(listUser);
    }
}
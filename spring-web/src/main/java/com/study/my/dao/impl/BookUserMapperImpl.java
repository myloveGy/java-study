package com.study.my.dao.impl;

import com.study.my.dao.BookUserMapper;
import com.study.my.domain.BookUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BookUserMapperImpl implements BookUserMapper {

    @Override
    public List<BookUser> findAll() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行SQL语句
        List<BookUser> users = sqlSession.selectList("userMapper.findAll");
        sqlSession.close();
        return users;
    }

    @Override
    public BookUser findOne() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行SQL语句
        BookUser user = sqlSession.selectOne("userMapper.findOne", 5);

        sqlSession.close();

        return user;
    }

    @Override
    public BookUser findById(int id) {
        return null;
    }
}

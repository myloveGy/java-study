package org.example.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.Role;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class RoleMapperTest {

    private RoleMapper roleMapper;

    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        roleMapper = sqlSession.getMapper(RoleMapper.class);
    }

    @Test
    public void findAll() {
        Role role = new Role();
        role.setRoleName("%测试%");
        List<Role> all = roleMapper.findAll(role);
        System.out.println(all);
    }

    @Test
    public void findOne() {
        Role one = roleMapper.findOne(3);
        System.out.println(one);
        assertEquals(new Integer(3), one.getRoleId());

    }
}
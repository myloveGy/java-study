package com.demo.my.dao.impl;

import com.demo.my.config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class AccountDaoImplTest {

    @Resource(name="accountDao")
    private AccountDaoImpl accountDao;

    @Test
    public void increase() {
        assertEquals(false, accountDao.increase("123", 100L));
        assertEquals(true, accountDao.increase("username", 100L));
    }

    @Test
    public void decrease() {
        assertEquals(false, accountDao.decrease("123", 100L));
        assertEquals(true, accountDao.decrease("username", 100L));
    }
}
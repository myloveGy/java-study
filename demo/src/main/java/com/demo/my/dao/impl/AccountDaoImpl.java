package com.demo.my.dao.impl;

import com.demo.my.dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean increase(String name, Long money) {
        return jdbcTemplate.update("UPDATE `account` SET `money` = `money` + ? WHERE `name` = ?", money, name) > 0;
    }

    @Override
    public boolean decrease(String name, Long money) {
        return jdbcTemplate.update("UPDATE `account` SET `money` = `money` - ? WHERE `name` = ?", money, name) > 0;
    }
}

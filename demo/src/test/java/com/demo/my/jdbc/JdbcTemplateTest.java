package com.demo.my.jdbc;

import com.demo.my.config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class JdbcTemplateTest {

    @Resource(name = "dataSource")
    private DataSource dataSource;

    @Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 设置数据源 知道数据库在哪
        jdbcTemplate.setDataSource(dataSource);
        int row = jdbcTemplate.update("INSERT INTO `account` (`name`, `money`) VALUES  (?, ?)", "jinxing.liu123", 100);
        System.out.println(row);
    }

    @Test
    public void testUpdate() {
        int update = jdbcTemplate.update("INSERT INTO `account` (`name`, `money`) VALUES (?, ?)", "jinxing.liu", 200);
        System.out.println(update);
    }

    @Test
    public void testDelete() {
        int update = jdbcTemplate.update("DELETE FROM `account` WHERE `name` = ?", "jinxing.liu123");
        System.out.println(update);
        if (update > 0) {
            System.out.println("删除成功");
        }
    }

    @Test
    public void testQueryAll() {
        List<Account> accountList = jdbcTemplate.query("SELECT * FROM `account`", new BeanPropertyRowMapper<>(Account.class));
        System.out.println(accountList);
    }

    @Test
    public void testQueryOne() {
        Account account = jdbcTemplate.queryForObject("SELECT * FROM `account` WHERE `id` = ?", new BeanPropertyRowMapper<>(Account.class), 100);
        System.out.println(account);
    }

    @Test
    public void testQueryCount() {
        Long count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM `account`", Long.class);
        System.out.println(count);
    }
}
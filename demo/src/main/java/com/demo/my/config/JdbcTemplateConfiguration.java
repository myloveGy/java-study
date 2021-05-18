package com.demo.my.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class JdbcTemplateConfiguration {

    @Resource(name="dataSource")
    private DataSource dataSource;

    @Bean(name="jdbcTemplate")
    public JdbcTemplate getJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
}

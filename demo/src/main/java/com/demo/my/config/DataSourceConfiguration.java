package com.demo.my.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

// <context:property-placeholder location="classpath:jdbc.properties"/>
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfiguration {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean("dataSource")
    public DataSource getDataSource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/java-study");
        System.out.println(driver.equals("com.mysql.jdbc.Driver"));
        System.out.println(url.equals("jdbc:mysql://localhost:3306/java-study"));
        System.out.println(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}

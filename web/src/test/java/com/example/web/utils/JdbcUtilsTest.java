package com.example.web.utils;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

public class JdbcUtilsTest {

    @Test
    public void testConnection() {
        Connection connection = JdbcUtils.getConnection();
        assertNotNull(connection);
    }

    @Test
    public void testClose() {
        Connection connection = JdbcUtils.getConnection();
        JdbcUtils.close(connection);
    }

}
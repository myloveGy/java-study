package com.example.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionUtil {

    /**
     * 获取rabbitmq连接
     *
     * @return 连接
     *
     * @throws IOException      io错误
     * @throws TimeoutException 超时错误
     */
    public static Connection getConnection() throws IOException, TimeoutException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        // 主机地址：默认localhost
        connectionFactory.setHost("localhost");
        // 连接端口：默认5672
        connectionFactory.setPort(5672);
        // 默认虚拟组件名称： 默认为/
        connectionFactory.setVirtualHost("/study");
        // 连接用户名称： 默认guest
        connectionFactory.setUsername("guest");
        // 连接用户密码: 默认guest
        connectionFactory.setPassword("guest");
        // 创建连接
        return connectionFactory.newConnection();
    }
}


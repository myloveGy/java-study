package com.example;

import com.example.util.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Consumer {

    public static void main(String[] args) throws Exception {

        Connection connection = ConnectionUtil.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(Producer.QUEUE_NAME, true, false, false, null);

        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                // 路由key
                System.out.println("路由Key: " + envelope.getRoutingKey());
                // 交换机
                System.out.println("交换机: " + envelope.getExchange());
                // 消息ID
                System.out.println("消息ID: " + envelope.getDeliveryTag());
                // 收到消息内容
                System.out.println("消息内容: " + new String(body, StandardCharsets.UTF_8));
            }
        };

        channel.basicConsume(Producer.QUEUE_NAME, true, consumer);
    }

}

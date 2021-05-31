package com.example.pubsub;

import com.example.util.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Consumer2 {

    public static void main(String[] args) throws Exception {
        // 建立连接
        Connection connection = ConnectionUtil.getConnection();
        // 创建频道
        Channel channel = connection.createChannel();

        // 声明队列
        /**
         * 参数1：队列名称
         * 参数2：是否定义持久化队列
         * 参数3：是否独占本次连接
         * 参数4：是否在不使用的时候自动删除队列
         * 参数5：队列其他参数
         */
        channel.queueDeclare(Producer.QUEUE_NAME2, true, false, false, null);

        // 创建消费者；并设置消息处理
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                // 接收到的消息内容
                System.out.println("消息内容：" + new String(body, StandardCharsets.UTF_8));

                // 收到确认消息
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };

        /**
         * 监听消息
         * 参数1：队列名称
         * 参数2：是否自动确认消息、设置为ture表示消息收到自动向mq回复收到，mq接收到回复会删除消息，设置为false则需要手动确认
         * 参数3：消息接收到后回调
         */
        channel.basicConsume(Producer.QUEUE_NAME2, false, consumer);
    }
}

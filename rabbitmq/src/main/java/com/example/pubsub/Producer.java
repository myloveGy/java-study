package com.example.pubsub;

import com.example.util.ConnectionUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.nio.charset.StandardCharsets;

public class Producer {

    public static String EXCHANGE_NAME = "study_fanout";

    public static String QUEUE_NAME1 = "fanout_queue1";
    public static String QUEUE_NAME2 = "fanout_queue2";

    public static void main(String[] args) throws Exception {
        // 1、建立连接
        Connection connection = ConnectionUtil.getConnection();
        // 2、建立频道
        Channel channel = connection.createChannel();
        // 3、建立交换机
        /**
         * 参数1：交换机名称
         * 参数2：交换机类型
         *      DIRECT("direct"): 定向
         *      FANOUT("fanout"): 广播
         *      TOPIC("topic"): 通配符的方式
         *      HEADERS("headers"): 参数匹配
         * 参数3：是否持久化
         * 参数4：是否自动删除
         * 参数5：内部使用
         * 参数6：其他参数
         */
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT, true, false, false, null);
        // 4、创建队列
        channel.queueDeclare(QUEUE_NAME1, true, false, false, null);
        channel.queueDeclare(QUEUE_NAME2, true, false, false, null);
        // 5、绑定队列和交换机
        /**
         * 参数1：队列名称
         * 参数2：交换机名称
         * 参数3：路由key
         */
        channel.queueBind(QUEUE_NAME1, EXCHANGE_NAME, "");
        channel.queueBind(QUEUE_NAME2, EXCHANGE_NAME, "");
        // 6、发送消息
        for (int i = 1; i <= 30; i++) {
            String message = "你好！发布订阅模式: " + i;
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("发送消息: " + message);
        }

        // 7、关闭资源
        channel.close();
        connection.close();
    }
}

import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderForQueryTest {

    @Test
    public void test() throws Exception {
        Connection connection = MySQLHelper.getConnection();

        String sql = "SELECT * FROM `order` WHERE `order_id` = ? LIMIT 1";

        PreparedStatement statement = connection.prepareStatement(sql);

        // 绑定参数
        statement.setObject(1, 1);

        // 获取查询对象
        ResultSet result = statement.executeQuery();

        // 是否有数据
        if (result.next()) {
            int orderId = (int)result.getObject(1);
            String orderName = (String) result.getObject(2);
            Date orderDate = (Date) result.getObject(3);
            Order order = new Order(orderId, orderName, orderDate);
            System.out.println(order);
        }

        MySQLHelper.close(connection, result);
    }

    @Test
    public void testQuery() throws Exception {
        Order order = OrderQuery.query("SELECT `order_id` AS `orderId`, `order_name` AS `orderName`, `order_date` AS `orderDate` FROM `order` WHERE `order_id` = ? LIMIT 1", 1);
        System.out.println(order);
    }

}

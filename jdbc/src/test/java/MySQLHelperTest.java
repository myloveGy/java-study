import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MySQLHelperTest {

    @Test
    public void test() throws Exception {
        // 新增
        assertEquals(1, MySQLHelper.update("INSERT INTO `user_table` (`user`, `password`, `balance`) VALUES (?, ?, ?)", "jinxing.liu", "123456", 100));

        // 修改
        assertEquals(1, MySQLHelper.update(
                "UPDATE `user_table` SET `user` = ?, `balance` = ? WHERE `user` = ?",
                "jinxing", 200, "jinxing.liu"
        ));

        // 删除
        assertEquals(1, MySQLHelper.update("DELETE FROM `user_table` WHERE `user` = ?", "jinxing"));
    }

    @Test
    public void testFind() throws Exception {

        // 查询订单
        Order order = new MySQLHelper().find(
                Order.class,
                "SELECT `order_id` AS `orderId`, `order_name` AS `orderName`, `order_date` AS `orderDate` FROM `order` WHERE `order_id` = ? LIMIT 1",
                1
        );
        System.out.println(order);

        // 查询customer
        Customer customer = new MySQLHelper().find(
                Customer.class,
                "SELECT `id`, `name`, `email`, `birth` FROM `customers` WHERE `id` = ?",
                1
        );

        System.out.println(customer);
    }

    @Test
    public void testFindAll() throws Exception {

        // 查询订单
        List<Order> order = new MySQLHelper().findAll(
                Order.class,
                "SELECT `order_id` AS `orderId`, `order_name` AS `orderName`, `order_date` AS `orderDate` FROM `order` WHERE `order_id` = ? LIMIT 1",
                1
        );
        System.out.println(order);

        // 查询customer
        List<Customer> customer = new MySQLHelper().findAll(
                Customer.class,
                "SELECT `id`, `name`, `email`, `birth` FROM `customers` WHERE `id` IN (?, ?)",
                1, 2
        );

        System.out.println(customer);
    }

}
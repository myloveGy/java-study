import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerForQueryTest {

    @Test
    public void test() throws Exception {
        Connection connection = MySQLHelper.getConnection();

        String sql = "SELECT * FROM `customers` WHERE `id` = ? LIMIT 1";

        PreparedStatement statement = connection.prepareStatement(sql);

        // 绑定参数
        statement.setObject(1, 19);

        // 获取查询对象
        ResultSet result = statement.executeQuery();

        // 是否有数据
        if (result.next()) {
            System.out.println(result.getInt(1));
            System.out.println(result.getString(2));
            System.out.println(result.getString(3));
            System.out.println(result.getDate(4));

            Customer customer = new Customer(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getDate(4)
            );

            System.out.println(customer);
        }

        MySQLHelper.close(connection, result);
    }

    @Test
    public void testQuery() throws Exception {
        Customer customer = CustomerQuery.query("SELECT `id`, `name`, `email`, `birth` FROM `customers` WHERE `id` = ?", 1);
        System.out.println(customer);
    }
}

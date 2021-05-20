import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * 新增数据
 * <p>
 * 1. 使用Statement
 */
public class BatchInsertTest {

    @Test
    public void test1() throws Exception {
        Connection connection = MySQLHelper.getConnection();
        for (int i = 0; i < 2000; i++) {
            connection.createStatement().execute("INSERT INTO `order` (`order_name`, `order_date`) VALUES ('statement-test-" + i + "', '2021-05-18')");
        }
    }

    @Test
    public void test2() throws Exception {
        Connection connection = MySQLHelper.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO `order` (`order_name`, `order_date`) VALUES (?, ?)");
        for (int i = 0; i < 2000; i++) {
            statement.setObject(1, "name-test-" + i);
            statement.setObject(2, "2021-05-18");
            System.out.println(statement.executeUpdate());
        }
    }

    @Test
    public void test3() throws Exception {
        Long start = System.currentTimeMillis();
        Connection connection = MySQLHelper.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO `order` (`order_name`, `order_date`) VALUES (?, ?)");
        for (int i = 0; i < 2000; i++) {
            statement.setObject(1, "name-test-" + i);
            statement.setObject(2, "2021-05-18");
            statement.addBatch();
            if (i % 500 == 0) {
                statement.executeBatch();
                statement.clearBatch();
            }
        }

        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void test4() throws Exception {
        var start = System.currentTimeMillis();
        Connection connection = MySQLHelper.getConnection();

        connection.setAutoCommit(false);
        PreparedStatement statement = connection.prepareStatement("INSERT INTO `order` (`order_name`, `order_date`) VALUES (?, ?)");
        for (int i = 0; i < 2001; i++) {
            statement.setObject(1, "name-test-" + i);
            statement.setObject(2, "2021-05-18");
            statement.addBatch();
            if (i % 500 == 0) {
                statement.executeBatch();
                statement.clearBatch();
            }
        }

        connection.commit();
        connection.setAutoCommit(true);

        System.out.println(System.currentTimeMillis() - start);
    }
}

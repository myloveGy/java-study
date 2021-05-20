import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TransactionTest {

    @Test
    public void test() throws Exception {
        Connection connection = MySQLHelper.getConnection();

        // 关闭自动提交
        connection.setAutoCommit(false);

        try {
            // 执行SQL一
            PreparedStatement statement = connection.prepareStatement("UPDATE `user_table` SET `balance` = `balance` - 100 WHERE `user` = ?");
            statement.setObject(1, "CC");
            System.out.println(statement.executeUpdate());

            // 执行SQL二
            PreparedStatement statement1 = connection.prepareStatement("UPDATE `user_table` SET `balance` = `balance` + 100 WHERE `user` = ?");
            statement1.setObject(1, "DD");
            System.out.println(statement1.executeUpdate());

            // 提交事务
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            connection.setAutoCommit(true);
        }

    }
}

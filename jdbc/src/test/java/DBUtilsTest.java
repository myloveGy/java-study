import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;

public class DBUtilsTest {

    @Test
    public void update() throws Exception {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = MySQLHelper.getConnection();
        int update = queryRunner.update(connection, "DELETE FROM `customers` WHERE `id` = ?", 22);
        System.out.println(update);
    }

    @Test
    public void query() throws Exception {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = MySQLHelper.getConnection();
        BeanHandler<Customer> customerBeanHandler = new BeanHandler<>(Customer.class);
        Customer customer = queryRunner.query(connection, "SELECT `id`, `name`, `email`, `birth` FROM `customers` WHERE `id` = ?", customerBeanHandler, 26);
        System.out.println(customer);
    }

    @Test
    public void insert() throws Exception {
        ScalarHandler handler = new ScalarHandler<>();
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = MySQLHelper.getConnection();
        Object insert =  queryRunner.insert(connection,"INSERT INTO `customers` (`name`, `email`, `birth`) VALUES (?, ?, ?)", handler, "jinxing", "1@qq.com", "2021-05-19");
        System.out.println(insert);
        System.out.println(insert.getClass().getTypeName());
    }
}

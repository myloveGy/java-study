import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {

    @Test
    public void testConnection() throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();

        Properties configInfo = new Properties();
        configInfo.setProperty("user", "root");
        configInfo.setProperty("password", "123456");

        Connection connection = driver.connect("jdbc:mysql://localhost:3306/java-study", configInfo);
        System.out.println(connection);
    }

    @Test
    public void test() {

    }
}

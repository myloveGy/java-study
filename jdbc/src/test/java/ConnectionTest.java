import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {

    @Test
    public void testConnection1() throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();

        Properties configInfo = new Properties();
        configInfo.setProperty("user", "root");
        configInfo.setProperty("password", "123456");

        Connection connection = driver.connect("jdbc:mysql://localhost:3306/java-study", configInfo);
        System.out.println(connection);
    }

    @Test
    public void testConnection2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
        // 1、获取Driver实现类：使用反射
        Class driverClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) driverClass.getDeclaredConstructor().newInstance();
        Properties configInfo = new Properties();
        configInfo.setProperty("user", "root");
        configInfo.setProperty("password", "123456");

        Connection connection = driver.connect("jdbc:mysql://localhost:3306/java-study", configInfo);
        System.out.println(connection);
    }

    @Test
    public void testConnection3() throws Exception {
        // 1、获取Driver实现类：使用反射
        Class driverClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) driverClass.getDeclaredConstructor().newInstance();

        // 2、注册驱动
        DriverManager.registerDriver(driver);

        // 3、获取连接
        Connection root = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-study", "root", "123456");
        System.out.println(root);
    }

    @Test
    public void testConnection4() throws Exception {
        // 1、获取Driver实现类：使用反射
        Class.forName("com.mysql.jdbc.Driver");

        // 2、获取连接
        Connection root = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-study", "root", "123456");
        System.out.println(root);
    }
}

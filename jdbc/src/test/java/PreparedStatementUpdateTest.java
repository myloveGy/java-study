import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * 数据库： CRUD 操作
 */
public class PreparedStatementUpdateTest {

    /**
     * 向customers添加一条数据
     */
    @Test
    public void testInsert() throws Exception {
        Connection connection = getConnection();

        // 预编译SQL语句
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `customers` (`name`, `email`, `birth`) VALUES (?, ?, ?)");

        // 绑定参数
        preparedStatement.setString(1, "悟空");
        preparedStatement.setString(2, "wukong@gmail.com");
        Date parse = new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-01");
        preparedStatement.setDate(3, new java.sql.Date(parse.getTime()));

        // 执行新增操作
        System.out.println(preparedStatement.executeUpdate());

        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        System.out.println(generatedKeys.next());
        System.out.println(generatedKeys.getInt(1));

        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testUpdate() throws Exception {

        Connection connection = getConnection();

        // 预编译SQL语句
        PreparedStatement statement = connection.prepareStatement("UPDATE `customers` SET `name` = ?, `email` = ? WHERE `id` = ?");

        // 绑定参数
        statement.setString(1, "jinxing.liu");
        statement.setString(2, "821901008@qq.com");
        statement.setInt(3, 20);

        // 执行SQL
//        System.out.println(statement.execute());
        System.out.println(statement.executeUpdate());
    }

    @Test
    public void testDelete() throws Exception {
        Connection connection = getConnection();

        // 预编译SQL语句
        PreparedStatement statement = connection.prepareStatement("DELETE FROM `customers` WHERE `id` = ?");

        // 绑定参数
        statement.setInt(1, 20);

        // 执行SQL
        System.out.println(statement.executeUpdate());
    }

    /**
     * 获取连接对象
     * @return MySQL Connection
     * @throws Exception 抛出错误
     */
    private Connection getConnection() throws Exception {
        // 1、读取配置文件
        InputStream inputStream = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        System.out.println(properties.getProperty("driver"));
        System.out.println(properties.getProperty("url"));
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));

        // 2、获取Driver实现类：使用反射
        Class.forName(properties.getProperty("driver"));

        // 3、获取连接
        return DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
    }
}

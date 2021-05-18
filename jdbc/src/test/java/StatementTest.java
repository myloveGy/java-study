import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class StatementTest {

    /**
     * 存在SQL注入
     *
     * @param args 参数信息
     * @throws Exception 抛出错误
     */
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名称");
        String username = scanner.next();
        System.out.println("请输入密码");
        String password = scanner.next();

        String sql = "SELECT * FROM `user_table` WHERE `user` = '" + username + "' AND `password` = '" + password + "'";
        System.out.println(sql);
        UserTable user = get(sql, UserTable.class);
        System.out.println(user);
    }

    public static <T> T get(String sql, Class<T> objectClass) throws Exception {
        T t = null;

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
        Connection root = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));

        Statement statement = root.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        // 获取结果
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        if (resultSet.next()) {
            t = objectClass.getDeclaredConstructor().newInstance();
            for (int i = 0; i < columnCount; i++) {
                String name = metaData.getColumnLabel(i + 1);
                Object value = resultSet.getObject(name);

                Field field = objectClass.getDeclaredField(name);
                field.setAccessible(true);
                field.set(t, value);
            }
        }

        return t;
    }
}

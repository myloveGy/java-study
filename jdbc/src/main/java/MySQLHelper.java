import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MySQLHelper {

    /**
     * 获取连接对象
     *
     * @return MySQL Connection
     *
     * @throws Exception 抛出错误
     */
    public static Connection getConnection() throws Exception {
        // 1、读取配置文件
        InputStream inputStream = MySQLHelper.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        // 2、获取Driver实现类：使用反射
        Class.forName(properties.getProperty("driver"));

        // 3、获取连接
        return DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
    }

    /**
     * MySQL 新增、修改、删除
     *
     * @param sql  执行的SQL
     * @param args 绑定的参数
     * @return 受影响的行
     *
     * @throws Exception 抛出错误
     */
    public static int update(String sql, Object... args) throws Exception {

        // 获取连接
        Connection connection = getConnection();

        // 预处理SQL
        PreparedStatement statement = connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            statement.setObject(i + 1, args[i]);
        }

        // 返回受影响的行
        return statement.executeUpdate();
    }

    public <T> T find(Class<T> classObject, String sql, Object... args) throws Exception {
        // 获取连接
        Connection connection = getConnection();

        // 预处理SQL
        PreparedStatement statement = connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            statement.setObject(i + 1, args[i]);
        }

        // 返回受影响的行
        ResultSet result = statement.executeQuery();

        // 获取结果集合的元数据
        ResultSetMetaData metaData = result.getMetaData();

        // 获取列数
        int columnCount = metaData.getColumnCount();

        if (result.next()) {
            T instance = classObject.getDeclaredConstructor().newInstance();
            for (int i = 0; i < columnCount; i++) {
                Object columnValue = result.getObject(i + 1);
                String columnName = metaData.getColumnLabel(i + 1);
                Field field = classObject.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(instance, columnValue);
            }

            return instance;
        }

        return null;
    }

    public <T> List<T> findAll(Class<T> classObject, String sql, Object... args) throws Exception {
        // 获取连接
        Connection connection = getConnection();

        // 预处理SQL
        PreparedStatement statement = connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            statement.setObject(i + 1, args[i]);
        }

        // 返回受影响的行
        ResultSet result = statement.executeQuery();

        // 获取结果集合的元数据
        ResultSetMetaData metaData = result.getMetaData();

        // 获取列数
        int columnCount = metaData.getColumnCount();

        List<T> list = new ArrayList<>();

        while (result.next()) {
            T instance = classObject.getDeclaredConstructor().newInstance();
            for (int i = 0; i < columnCount; i++) {
                Object columnValue = result.getObject(i + 1);
                String columnName = metaData.getColumnLabel(i + 1);
                Field field = classObject.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(instance, columnValue);
            }

            list.add(instance);
        }

        return list;
    }

    public static ResultSet query(String sql, Object... args) throws Exception {
        // 获取连接
        Connection connection = getConnection();

        // 预处理SQL
        PreparedStatement statement = connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            statement.setObject(i + 1, args[i]);
        }

        // 返回受影响的行
        return statement.executeQuery();
    }

    public static void close(Connection db, PreparedStatement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        try {
            if (db != null) {
                db.close();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void close(Connection db, ResultSet result) {
        try {
            if (result != null) {
                result.close();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        try {
            if (db != null) {
                db.close();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}

package dao;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BaseDAO<T> {

    private Class<T> clazz = null;

    {
            // 获取子类的泛型
            Type genericSuperclass = this.getClass().getGenericSuperclass();
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;

            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();// 获取父类的泛型
            clazz = (Class<T>) actualTypeArguments[0];
    }

    /**
     * 获取连接对象
     *
     * @return MySQL Connection
     *
     * @throws Exception 抛出错误
     */
    public static Connection getConnection() throws Exception {
        // 1、读取配置文件
        InputStream inputStream = BaseDAO.class.getClassLoader().getResourceAsStream("jdbc.properties");
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
     */
    public int update(String sql, Object... args) {
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = getConnection();
            preparedStatement = bind(connection, sql, args);
            return preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            close(null, preparedStatement);
        }

        return 0;
    }

    public T find(String sql, Object... args) {

        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            Connection connection = getConnection();
            // 预处理SQL
            statement = bind(connection, sql, args);

            // 返回受影响的行
            result = statement.executeQuery();

            // 获取结果集合的元数据
            ResultSetMetaData metaData = result.getMetaData();

            // 获取列数
            int columnCount = metaData.getColumnCount();

            if (result.next()) {
                return toObject(result, columnCount, metaData);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            close(null, statement, result);
        }

        return null;
    }

    public List<T> findAll(String sql, Object... args) {
        ArrayList<T> list = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            Connection connection = getConnection();

            // 预处理SQL
            statement = bind(connection, sql, args);

            // 返回受影响的行
            resultSet = statement.executeQuery();

            // 获取结果集合的元数据
            ResultSetMetaData metaData = resultSet.getMetaData();

            // 获取列数
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                list.add(toObject(resultSet, columnCount, metaData));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            close(null, statement, resultSet);
        }

        return list;
    }

    private T toObject(ResultSet resultSet, int count, ResultSetMetaData metaData) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();
            for (int i = 0; i < count; i++) {
                Object columnValue = resultSet.getObject(i + 1);
                String columnName = metaData.getColumnLabel(i + 1);
                Field field = clazz.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(instance, columnValue);
            }

            return instance;
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;

    }

    /**
     * 查询单个字段信息
     *
     * @param sql  执行的SQL
     * @param args 绑定的参数
     */
    public <E> E findBy(String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet result = null;
        try {
            Connection connection = getConnection();
            ps = bind(connection, sql, args);
            result = ps.executeQuery();
            if (result.next()) {
                return (E) result.getObject(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(null, ps, result);
        }

        return null;
    }

    private static PreparedStatement bind(Connection connection, String sql, Object... args) throws SQLException {
        var prepareStatement = connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            prepareStatement.setObject(i + 1, args[i]);
        }

        return prepareStatement;
    }

    public static void close(Connection connection, PreparedStatement statement) {
        closeStatement(statement);
        closeConnection(connection);
    }

    public static void close(Connection connection, PreparedStatement statement, ResultSet result) {
        closeResultSet(result);
        closeStatement(statement);
        closeConnection(connection);
    }

    private static void closeStatement(PreparedStatement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}

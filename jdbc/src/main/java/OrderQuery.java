import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class OrderQuery {
    /**
     * 查询数据
     *
     * @param sql  查询的SQL
     * @param args 绑定的参数
     * @return 返回null|Order
     *
     * @throws Exception 抛出错误
     */
    public static Order query(String sql, Object... args) throws Exception {

        ResultSet result = MySQLHelper.query(sql, args);

        // 获取结果集合的元数据
        ResultSetMetaData metaData = result.getMetaData();

        // 获取列数
        int columnCount = metaData.getColumnCount();

        if (result.next()) {
                Order order = new Order();
                for (int i = 0; i < columnCount; i++) {

                    Object columnValue = result.getObject(i + 1);

                    // 获取列的列名称
                    String columnName = metaData.getColumnName(i + 1);

                    // 获取列的别名
                    String columnLabel = metaData.getColumnLabel(i + 1);

                    Field field = Order.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(order, columnValue);
                }

                return order;
        }

        return null;
    }
}

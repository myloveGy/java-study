import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class CustomerQuery {
    /**
     * 查询数据
     *
     * @param sql  查询的SQL
     * @param args 绑定的参数
     * @return 返回null|Customer
     *
     * @throws Exception 抛出错误
     */
    public static Customer query(String sql, Object... args) throws Exception {

        ResultSet result = MySQLHelper.query(sql, args);

        // 获取结果集合的元数据
        ResultSetMetaData metaData = result.getMetaData();

        // 获取列数
        int columnCount = metaData.getColumnCount();

        if (result.next()) {
            Customer customer = new Customer();
            for (int i = 0; i < columnCount; i++) {
                Object columnValue = result.getObject(i + 1);
                String columnName = metaData.getColumnName(i + 1);
                Field field = Customer.class.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(customer, columnValue);
            }

            return customer;
        }

        return null;
    }
}

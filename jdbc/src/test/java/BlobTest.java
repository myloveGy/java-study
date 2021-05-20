import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BlobTest {

    @Test
    public void test() throws Exception {

        // 获取连接
        Connection connection = MySQLHelper.getConnection();

        // 预处理SQL
        PreparedStatement statement = connection.prepareStatement("INSERT INTO `customers` (`name`, `email`, `birth`, `photo`) VALUES (?, ?, ?, ?)");

        // 绑定参数
        statement.setObject(1, "jinxing.liu");
        statement.setObject(2, "jinxing.liu@qq.com");
        statement.setObject(3, "2020-01-02");
        statement.setObject(4, new FileInputStream("./src/main/resources/test.jpg"));

        // 执行SQL
        System.out.println(statement.executeUpdate());

        // 关闭链接
        MySQLHelper.close(connection, statement);
    }

    @Test
    public void testQuery() throws Exception {

        // 获取连接
        Connection connection = MySQLHelper.getConnection();

        // 预处理SQL
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM `customers` WHERE `id` = ? LIMIT 1");

        // 绑定参数
        statement.setObject(1, 24);

        ResultSet result = statement.executeQuery();
        if (result.next()) {
            Blob photo = result.getBlob("photo");
            InputStream stream = photo.getBinaryStream();
            FileOutputStream fos = new FileOutputStream("./src/main/resources/my-test.jpg");
            byte[] bytes = new byte[1024];
            int length;
            while ((length = stream.read(bytes)) != -1) {
                fos.write(bytes, 0, length);
            }

            fos.close();
            stream.close();
        }
    }
}

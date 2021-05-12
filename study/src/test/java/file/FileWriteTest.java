package file;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteTest {

    @Test
    public void test() throws IOException {
        File file = new File("mysql.properties");

        // 实例化写入流
        FileWriter fileWriter = new FileWriter(file, true);

        // 覆盖写入
        fileWriter.write("user=root\n");
        fileWriter.write("password=123456\n");

        // 关闭流
        fileWriter.close();
    }

    @Test
    public void copy() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            File srcFile = new File("jdbc.properties");
            File destFile = new File("username.txt");

            fileReader = new FileReader(srcFile);
            fileWriter = new FileWriter(destFile);

            int length;
            char[] chars = new char[10];
            while ((length = fileReader.read(chars)) != -1) {
                fileWriter.write(chars, 0, length);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

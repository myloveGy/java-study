package file;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReadTest {

    @Test
    public void test() {
        File file = new File("jdbc.properties");
        try {
            // 创建读取流
            FileReader fileReader = new FileReader(file);

            // 读取文件内容
            int data;

            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }

            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() throws IOException {
        File file = new File("jdbc.properties");

        // 创建读取流
        FileReader fileReader = new FileReader(file);

        // 读取文件
        char[] chars = new char[5];
        int len;
        while ((len = fileReader.read(chars)) != -1) {
            for (int i = 0; i < len; i++) {
                System.out.print(chars[i]);
            }
        }

        fileReader.close();
    }
}

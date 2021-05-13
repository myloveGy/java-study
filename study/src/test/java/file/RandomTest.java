package file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomTest {

    @Test
    public void test() {
        RandomAccessFile srcFile = null;
        RandomAccessFile dostFile = null;
        try {
            srcFile = new RandomAccessFile(new File("data.txt"), "r");
            dostFile = new RandomAccessFile(new File("data_copy.txt"), "rw");

            byte[] chars = new byte[1024];
            int length;
            while ((length = srcFile.read(chars)) != -1) {
                dostFile.write(chars, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (srcFile != null) {
                try {
                    srcFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (dostFile != null) {
                try {
                    dostFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // 执行完成需要删除
        System.out.println((new File("data_copy.txt")).delete());
    }
}

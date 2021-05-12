package file;

import org.junit.Test;

import java.io.File;
import java.util.Date;

public class FileTest {

    @Test
    public void test() {
        File file = new File("jdbc.properties");
        System.out.println(file.getAbsolutePath());
        System.out.println(file);
        System.out.println(file.exists());
        System.out.println(new Date(file.lastModified()));

        // 可读、可写
        System.out.println(file.canRead());
        System.out.println(file.canWrite());

        // 是文件、还是目录
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
    }

    @Test
    public void testCreate() {
        File file = new File("username.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("创建成功");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            file.delete();
            System.out.println("删除成功");
        }
    }
}

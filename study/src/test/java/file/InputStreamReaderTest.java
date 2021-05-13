package file;

import org.junit.Test;

import java.io.*;

public class InputStreamReaderTest {

    @Test
    public void test() throws IOException {
        FileInputStream fis = new FileInputStream("username.txt");

        InputStreamReader isr = new InputStreamReader(fis);

        char[] chars = new char[1024];
        int length;
        while ((length = isr.read(chars)) != -1) {
            String str = new String(chars, 0, length);
            System.out.print(str);
        }

        isr.close();
    }

    @Test
    public void test2() throws IOException {
        FileInputStream fis = new FileInputStream("username.txt");
        FileOutputStream fos = new FileOutputStream( "username_gbk.txt");

        InputStreamReader isr = new InputStreamReader(fis);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "gbk");

        char[] chars = new char[1024];
        int length;
        while ((length = isr.read(chars)) != -1) {
            osw.write(chars, 0, length);
        }

        isr.close();
        osw.close();
    }
}

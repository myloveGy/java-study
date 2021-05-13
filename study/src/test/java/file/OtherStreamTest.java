package file;

import org.junit.Test;

import java.io.*;

public class OtherStreamTest {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("请输入字符串");
        while (true) {
            String str = br.readLine();
            if ("e".equalsIgnoreCase(str) || "exit".equalsIgnoreCase(str)) {
                System.out.println("程序结束");
                break;
            }

            System.out.println(str.toUpperCase());
        }
    }

    @Test
    public void test() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
        dos.writeBoolean(true);
        dos.writeUTF("jinxing.liu");
        dos.writeInt(100);
        dos.flush();
        dos.close();
    }

    @Test
    public void test1() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
        System.out.println(dis.readBoolean());
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        dis.close();
    }
}

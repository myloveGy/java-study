package network;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TcpTest {

    @Test
    public void client() {
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            Socket socket = new Socket(inetAddress, 8088);
            OutputStream os = socket.getOutputStream();
            os.write("你好，我是客户端".getBytes(StandardCharsets.UTF_8));
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8088);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();

//        byte[] bytes = new byte[1024];
//        int length;
//        while ((length = inputStream.read(bytes)) != -1) {
//            String str = new String(bytes, 0, length);
//            System.out.println(str);
//        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int length;
        while ((length = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, length);
        }

        System.out.println(outputStream.toString());

        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}

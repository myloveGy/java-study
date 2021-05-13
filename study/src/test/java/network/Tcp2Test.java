package network;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Tcp2Test {
    @Test
    public void client() {
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            Socket socket = new Socket(inetAddress, 8088);
            OutputStream os = socket.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream("test.jpg");

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fileInputStream.read(bytes)) != -1) {
                os.write(bytes, 0, length);
            }

            fileInputStream.close();
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

        FileOutputStream fileOutputStream = new FileOutputStream("service.jpg");
        byte[] bytes = new byte[1024];
        int length;
        while ((length = inputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, length);
        }

        fileOutputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}

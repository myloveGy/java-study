package network;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

public class UdpTest {

    @Test
    public void send() throws IOException {
        DatagramSocket socket = new DatagramSocket();
        byte[] data = "我是UDP".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 9090);
        socket.send(packet);
        socket.close();
        System.out.println("发送信息完成");
    }

    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(), 0, packet.getLength()));
    }
}

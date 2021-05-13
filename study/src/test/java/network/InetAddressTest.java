package network;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

    @Test
    public void test() {
        try {
            InetAddress inetAddress = InetAddress.getByName("www.jd.com");
            System.out.println(inetAddress);

            // 获取本机地址
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println(localhost);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

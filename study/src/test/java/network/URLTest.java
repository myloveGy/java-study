package network;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL网络编程
 * 1. 统一资源定位符
 * 2. 格式
 * http://locahost:8080/user/get?user_id=123
 * 协议    主机名   端口   资源列表    参数列表
 */
public class URLTest {

    @Test
    public void test() throws MalformedURLException {
        String urlString = "http://locahost:8080/user/get?user_id=123";
        URL url = new URL(urlString);
        System.out.println(url.getProtocol());  // 协议
        System.out.println(url.getHost());      // 主机名
        System.out.println(url.getPort());      // 端口
        System.out.println(url.getPath());      // 文件路径
        System.out.println(url.getFile());      // 文件名称
        System.out.println(url.getQuery());     // 查询名称
    }

    @Test
    public void download() throws IOException {
        URL url = new URL("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fdingyue.nosdn.127.net%2Fsm1Df28WYHgXFguRZCtC6GW2RqhuykBGyla504EP72sxi1535352755287compressflag.jpg&refer=http%3A%2F%2Fdingyue.nosdn.127.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1623483144&t=10550eac8631dd34bd1b114d0a3a29d8");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.connect();
        InputStream stream = urlConnection.getInputStream();
        FileOutputStream outputStream = new FileOutputStream("jin_sha.jpeg");

        byte[] bytes = new byte[1024];
        int length;
        while ((length = stream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, length);
        }

        outputStream.close();
        stream.close();
        System.out.println("下载完成");
        urlConnection.disconnect();
    }
}

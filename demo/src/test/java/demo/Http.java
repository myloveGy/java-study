package demo;

import com.demo.my.util.HttpClient;
import com.demo.my.util.Response;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Http {


    public void getData(Object... params) {
        System.out.println("length = " + params.length);
    }

    @Test
    public void test2() {
        Object o[] = {1, 2, 3};
        this.getData(o);
        System.out.println(o.length);
    }

    @Test
    public void test3() {

        Map data = new HashMap();

        Map keyword1 = new HashMap();
        keyword1.put("value", "98gadf");
        data.put("keyword1", keyword1);

        Map keyword2 = new HashMap();
        keyword1.put("value", "9fghfsgdf");
        data.put("keyword2", keyword1);


        Response response = HttpClient.builder()
                .setUrl("http://local.verystar.net/data/")
                .addPathVariable("post")
                .addHeader("User-Agent", "Chrome")
                .addHeader("Content-Type", "application/json")
                .addPostData("username", "jinxing.liu")
                .addPostData("age", 12)
                .addPostData("data", data)
                .post();

        if (response.getResponseCode() == 200) {
            System.out.println(response.getContent());
        }
    }

    @Test
    // 测试
    public void test() {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        HttpURLConnection connection;

        try {
            URL url = new URL("http://local.verystar.net/data/");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);

            // 设置连接超时时间和读取超时时间
            connection.setConnectTimeout(30000);
            connection.setReadTimeout(10000);

            // 设置使用json 请求
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");

            // 获取输出流
            out = new OutputStreamWriter(connection.getOutputStream());
            String jsonData = "{\"username\":\"jinxing.liu\"}";
            out.write(jsonData);
            out.flush();
            out.close();

            if (200 == connection.getResponseCode()) {
                in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
                String line;
                while ((line = in.readLine()) != null) {
                    result.append(line);
                }
            } else {
                System.out.println("ResponseCode is an error code:" + connection.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
               if (out != null) {
                   out.close();
               }

               if (in != null) {
                   in.close();
               }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        System.out.println(result.toString());
    }
}

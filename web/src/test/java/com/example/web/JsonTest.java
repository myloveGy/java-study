package com.example.web;

import com.example.web.pojo.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JsonTest {

    @Test
    public void test() {
        User user = new User();
        user.setUsername("jinxing.liu");
        user.setEmail("jinxing.liu@qq.com");
        user.setPassword("123456");
        user.setCreatedAt("2021-01-02 15:50:59");
        user.setId(1);

        // json encode
        Gson gson = new Gson();
        String userJson = gson.toJson(user);
        assertEquals("{\"id\":1,\"username\":\"jinxing.liu\",\"password\":\"123456\",\"email\":\"jinxing.liu@qq.com\",\"status\":0,\"createdAt\":\"2021-01-02 15:50:59\"}", userJson);

        // json decode
        User u = gson.fromJson("{\"id\":2,\"username\":\"jinxing.liu\",\"password\":\"123456\",\"email\":\"jinxing.liu@qq.com\",\"status\":0,\"createdAt\":\"2021-01-02 15:50:59\"}", User.class);
        System.out.println(u);

        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(u);

        String listJson = gson.toJson(list);
        System.out.println(listJson);

        // 解析
       List<User> jsonList = gson.fromJson(
                "[{\"id\":1,\"username\":\"jinxing.liu\",\"password\":\"123456\",\"email\":\"jinxing.liu@qq.com\",\"status\":0,\"createdAt\":\"2021-01-02 15:50:59\"},{\"id\":2,\"username\":\"jinxing.liu\",\"password\":\"123456\",\"email\":\"jinxing.liu@qq.com\",\"status\":0,\"createdAt\":\"2021-01-02 15:50:59\"}]",
                new TypeToken<List<User>>(){}.getType()
      );

       jsonList.forEach(System.out::println);
    }
}

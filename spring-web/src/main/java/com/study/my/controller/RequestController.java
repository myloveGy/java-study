package com.study.my.controller;

import com.study.my.domain.User;
import com.study.my.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RequestController {

    /**
     * 请求参数解析到变量
     * @param name 名称
     * @param age 年龄
     * @return 响应JSON
     */
    @RequestMapping("/request")
    @ResponseBody
    public Object request(String name, int age) {
        List<String> list = new ArrayList<>();
        list.add("jinxing.liu");
        list.add("username");
        list.add(name);
        list.add(age + "");
        return list;
    }

    /**
     * 请求参数解析到对象
     * @param user 解析对象
     * @return 响应JSON
     */
    @RequestMapping("/request1")
    @ResponseBody
    public Object request1(User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "success");
        map.put("data", user);
        return map;
    }

    /**
     * 解析List<>请求参数
     * @param vo 请求参数
     * @return 响应JSON
     */
    @RequestMapping("/request2")
    @ResponseBody
    public Object request2(VO vo) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "success");
        map.put("data", vo);
        return map;
    }

    /**
     * 请求参数 @RequestParam 使用注解
     * @param name 名称
     * @param email 邮箱
     * @return 响应JSON
     */
    @RequestMapping("/request3")
    @ResponseBody
    public Object request3(
            @RequestParam(value = "username", required = false, defaultValue = "test1001") String name,
            @RequestParam(required = false, defaultValue = "821901008@qq.com") String email
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "success");
        Map<String, String> list = new HashMap<>();
        list.put("name", name);
        list.put("email", email);
        map.put("data", list);
        return map;
    }
}

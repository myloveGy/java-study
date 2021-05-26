package com.study.my.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.my.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class StringController {

    @RequestMapping("/string")
    public void string(HttpServletResponse response) throws IOException {
        response.getWriter().println("success");
    }

    /**
     * 直接返回字符串信息
     *
     * @return 字符串
     */
    @RequestMapping("/string1")
    @ResponseBody
    public String string1() {
        return "{\"code\": 200, \"message\": \"success\"}";
    }

    @RequestMapping("/string2")
    @ResponseBody
    public String string2() throws JsonProcessingException {
        User user = new User();
        user.setUsername("jinxing.liu");
        user.setAge(30);

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(user);
    }

    @RequestMapping("/string3")
    @ResponseBody
    public User string3() {
        return new User("jinxing.liu", 30);
    }
}

package com.study.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RestfulController {

    @RequestMapping(value = "/restful/{name}")
    @ResponseBody
    public Object index(@PathVariable(value = "name", required = false) String name) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "success");
        map.put("data", name);
        return map;
    }

    @RequestMapping("/restful/custom")
    @ResponseBody
    public Object custom(Date date) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "success");
        map.put("data", date.toString());
        return map;
    }

    /**
     * 获取header 和 cookie
     * @param userAgent user-agent
     * @param sessionId session-id
     * @return JSON
     */
    @RequestMapping("/restful/header")
    @ResponseBody
    public Object header(@RequestHeader(value = "User-Agent",required = false) String userAgent, @CookieValue(value="JSESSIONID") String sessionId) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "success");
        map.put("user-agent", userAgent);
        map.put("cookie-session", sessionId);
        return map;
    }
}

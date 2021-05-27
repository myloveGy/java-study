package com.study.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {

    @RequestMapping("/upload")
    @ResponseBody
    public Object upload(MultipartFile file, String username, String email) throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "success");
        map.put("data", file.getOriginalFilename());
        map.put("username", username);
        map.put("email", email);
        return map;
    }
}

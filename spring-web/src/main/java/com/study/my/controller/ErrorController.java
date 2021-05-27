package com.study.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

    @RequestMapping("/error")
    public void show() {
        Integer i = 1/0;
        System.out.println(i);
    }
}

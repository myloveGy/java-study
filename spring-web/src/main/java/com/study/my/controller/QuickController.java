package com.study.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuickController {

    @RequestMapping("/quick")
    public String save() {
        System.out.println("Controller save running....");
        return "redirect:/success.jsp";
    }

    @RequestMapping(value = "/quick2")
    public ModelAndView save2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", "jinxing.liu");
        modelAndView.setViewName("success.jsp");
        return modelAndView;
    }

    @RequestMapping("/quick3")
    public ModelAndView quick3(ModelAndView view) {
        view.setViewName("index.jsp");
        view.addObject("username", "jinxing.liu");
        return view;
    }
}

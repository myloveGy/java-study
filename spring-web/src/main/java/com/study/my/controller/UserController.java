package com.study.my.controller;

import com.study.my.domain.MyBatisUser;
import com.study.my.service.MyBatisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MyBatisUserService myBatisUserService;

    @RequestMapping("/list")
    public ModelAndView list(ModelAndView view) throws Exception {
        view.addObject("list", myBatisUserService.findAll());
        view.setViewName("/user/list.jsp");
        return view;
    }

    @RequestMapping("/create")
    public String create(MyBatisUser user) throws Exception {
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        System.out.println(user);
        myBatisUserService.insert(user);
        return "redirect:/success.jsp";
    }
}

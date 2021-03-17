package com.demo.my;

import com.demo.my.config.SpringConfiguration;
import com.demo.my.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = {SpringConfiguration.class})
public class UserControllerTest {

    @Resource(name = "userService")
    private UserService userService;

    @Test
    public void test() {
        userService.save();
    }
}

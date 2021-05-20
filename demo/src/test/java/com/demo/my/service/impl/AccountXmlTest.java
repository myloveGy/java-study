package com.demo.my.service.impl;

import com.demo.my.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccountXmlTest {

    @Resource(name="accountService")
    private AccountService accountService;

    @Test
    public void test() throws Exception {
        accountService.transfer("test", "jinxing.liu", 100L);
    }
}

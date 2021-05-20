package com.demo.my.service.impl;

import com.demo.my.config.SpringConfiguration;
import com.demo.my.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class AccountServiceImplTest {
    @Resource(name = "accountService")
    private AccountService accountService;

    @Test
    public void transfer() throws Exception {
        boolean test = accountService.transfer("test", "username", 100L);
        assertTrue(test);
    }
}
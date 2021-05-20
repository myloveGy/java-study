package com.demo.my.service.impl;

import com.demo.my.dao.AccountDao;
import com.demo.my.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public boolean transfer(String outName, String inName, Long money) throws Exception {

        // 先减少金额
        if (!accountDao.decrease(outName, money)) {
            throw new Exception("转账失败: 转账人金额不足");
        }

        int i = 1 / 0;

        // 然后增加金额
        if (!accountDao.increase(inName, money)) {
            throw new Exception("转账失败: 接收人接收失败");
        }

        return true;
    }
}

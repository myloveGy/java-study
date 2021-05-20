package com.demo.my.dao;

public interface AccountDao {
    /**
     * 增加金额
     * @param name 名称
     * @param money 金额
     * @return 是否成功
     */
    boolean increase(String name, Long money);

    /**
     * 减少金额
     * @param name 名称
     * @param money 金额
     * @return 是否成功
     */
    boolean decrease(String name, Long money);
}

package com.study.my.dao;

import com.study.my.domain.BookUser;

import java.util.List;

public interface BookUserMapper1 {
    
    List<BookUser> findByCondition(BookUser bookUser);

    List<BookUser> findByIds(List<Integer> ids);

    List<BookUser> findAll();
}

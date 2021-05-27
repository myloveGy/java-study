package com.study.my.dao;

import com.study.my.domain.BookUser;

import java.io.IOException;
import java.util.List;

public interface BookUserMapper {

    List<BookUser> findAll() throws IOException;

    BookUser findOne() throws IOException;

    BookUser findById(int id) throws IOException;;
}

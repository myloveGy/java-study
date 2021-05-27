package com.study.my.dao.impl;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class BookUserMapperImplTest {

    @Test
    public void findAll() throws IOException {
        System.out.println(new BookUserMapperImpl().findAll());
    }

    @Test
    public void findOne() throws IOException {
        System.out.println(new BookUserMapperImpl().findOne());
    }
}
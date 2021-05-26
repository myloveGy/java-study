package com.example.web.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class Base64UtilsTest {

    @Test
    public void encode() {
        String str = Base64Utils.encode("你好");
        System.out.println(str);
        assertEquals("5L2g5aW9", str);
    }

    @Test
    public void decode() {
        String str = Base64Utils.decode("5L2g5aW9");
        System.out.println(str);
        assertEquals("你好", str);
    }
}
package com.example.web.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Utils {

    public static String encode(String content) {
        return new String(Base64.getEncoder().encode(content.getBytes(StandardCharsets.UTF_8)));
    }

    public static String decode(String content) {
        return new String(Base64.getDecoder().decode(content.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
    }
}

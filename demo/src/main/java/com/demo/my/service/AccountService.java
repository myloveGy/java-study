package com.demo.my.service;

public interface AccountService {
    boolean transfer(String outName, String inName, Long money) throws Exception;
}

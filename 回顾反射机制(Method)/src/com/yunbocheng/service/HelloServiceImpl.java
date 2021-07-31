package com.yunbocheng.service;

public class HelloServiceImpl implements HelloService{
    @Override
    public void HelloWord(String name) {
        System.out.println("您好 :" + name);
    }
}

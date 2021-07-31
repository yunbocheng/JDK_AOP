package com.yunbocheng.service;

public class HelloServiceImpl2 implements HelloService{
    @Override
    public void HelloWord(String name) {
        System.out.println("====你好" + name);
    }
}

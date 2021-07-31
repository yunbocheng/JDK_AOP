package com.yunobocheng.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 必须实现InvocationHandler接口，来完成代理类要做的功能。
 * 1. 调用目标方法
 * 2. 共功能增强
 */
public class MySellHandler implements InvocationHandler {
    private Object target = null;

    // 动态代理：目标对象是活动的，不是固定的，需要传入进来。
    // 传入的是谁就给谁创建代理

    public MySellHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object res = null;
        // 静态代理中 ：向厂家发送订单，告诉厂家，我买了u盘，厂家发货
        // float price = factory.sell(amount); //厂家的价格
        res = method.invoke(target,args); // 执行目标方法

        // 静态代码：商家需要加价格，也就是代理需要增加价格
        // price = price + 25; // 增强功能，代理类在完成目标类方法调用后，增强了功能。
        if (res != null){
            Float price = (Float) res;
            price = price + 25;
            res = price;
        }

        // 在目标类的方法调用后，你做其他功能，都是增强的意思。
        // 增加后的价格
        return res;
    }
}

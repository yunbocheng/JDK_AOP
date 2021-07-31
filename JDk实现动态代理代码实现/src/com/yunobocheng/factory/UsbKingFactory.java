package com.yunobocheng.factory;

import com.yunobocheng.servince.UsbSell;

/**
 * 目标类
 */
public class UsbKingFactory implements UsbSell {

    @Override
    public float sell(int amount) {
        // 目标方法
        System.out.println("目标类中，执行了sell目标方法");
        return 85.0f;
    }
}

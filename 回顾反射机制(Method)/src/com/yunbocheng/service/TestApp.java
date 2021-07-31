package com.yunbocheng.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestApp {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        /*以下是使用普通方法实现接口中的HelloWord方法*/
        HelloServiceImpl helloService = new HelloServiceImpl();
        helloService.HelloWord("张三"); // 您好 :张三

        /*接下来使用反射机制实现HelloWord的方法。核心就是 Method(类中的方法)*/
        /*使用HelloServiceImpl(接口实现类)创建一个接口对象，用于下边使用这个对象调用这个接口中的HelloWord方法*/
        HelloService target1 = new HelloServiceImpl();
        // 获取HelloWord名称对于的Method类对象
        // 这段代码的含义是 ：使用HelloService这个接口，获取到这个接口中的HelloWord方法
        // 将这个方法赋给 method，此时method就相当于这个接口中的 HelloWord方法
        Method method = HelloService.class.getMethod("HelloWord", String.class);
        // 通过Method可以执行 HelloWord方法调用。
        /*
        * invoke是Method类中的一个方法。表示执行方法的调用。
        * 参数：
        * 1. Object，表示对象的，要执行这个对象的方法，此时就是 target对象。
        * 2. Object...args  方法执行的参数值 (相当于上边的 张三 )
        * 返回值：
        * Object：方法执行后的返回值，
        * 这里执行的方法是 HelloWord 在接口中定义这个方法的时候，返回的数据类型为void。
        * */
        // 以下代码表达的意思 ：
        // 执行target对象(这里是HelloWord接口对象)中的HelloWord方法，参数是李四
        // 注意：此时method代表的是 HelloWord这个方法，target代表的是包含这个方法的对象
        // "李四" 为这个方法的参数
        Object ret1 = method.invoke(target1,"李四"); // 您好 :李四

        /*使用HelloServiceImpl2(接口实现类)创建一个接口对象，用于下边使用这个对象调用这个接口中的HelloWord方法*/
        HelloService target2 = new HelloServiceImpl2();
        Object ret2 = method.invoke(target2,"王五"); // ====你好王五

        /*通过以上代码测试可知：
        * 在使用接口的实现类(HelloServiceImpl 或者HelloServiceImpl2 )
        * 创建新的 接口对象 的时候，使用的哪个接口的实现类invoke就调用哪个接口实现类中的方法
        * 此时的这个接口对象就是 invoke中的第一个参数，而method就是这个接口实现类中的方法
        * */
    }
}

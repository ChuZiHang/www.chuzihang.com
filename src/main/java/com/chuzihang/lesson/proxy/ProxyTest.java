package com.chuzihang.lesson.proxy;

import com.chuzihang.lesson.proxy.cglib.HelloServiceCgLib;
import com.chuzihang.lesson.proxy.jdk.HelloServiceProxy;

/**
 * Created by Q_先生 on 2018/12/27.
 */
public class ProxyTest {

    public static void main(String[] args) {
        HelloServiceProxy helloServiceProxy = new HelloServiceProxy();
        HelloService proxy = (HelloService) helloServiceProxy.bind(new HelloServiceImpl());
        proxy.sayHello("张三");


        HelloServiceCgLib helloServiceCgLib = new HelloServiceCgLib();
        HelloService proxy1 = (HelloService) helloServiceCgLib.getInstance(new HelloServiceImpl());
        proxy1.sayHello("李四");
    }

}

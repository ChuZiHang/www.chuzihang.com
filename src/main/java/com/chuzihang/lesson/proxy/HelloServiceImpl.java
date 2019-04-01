package com.chuzihang.lesson.proxy;

/**
 * Created by Q_先生 on 2018/12/27.
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }
}

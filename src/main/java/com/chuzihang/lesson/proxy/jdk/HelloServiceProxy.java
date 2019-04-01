package com.chuzihang.lesson.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Q_先生 on 2018/12/27.
 */
public class HelloServiceProxy implements InvocationHandler {

    /**
     * 真实服务对象
     */
    private Object target;

    public Object bind(Object target) {
        this.target = target;
        // 取得代理对象
        // jdk 代理需要提供接口
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(), this);
    }

    /**
     * 通过代理对象调用方法首先进入这个方法
     * @param proxy -- 代理对象
     * @param method -- 被调用的方法
     * @param args  -- 方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("###########我是JDK代理############");
        Object result = null;
        // 反射方法前调用
        System.out.println("我准备说HEllo。。。。");
        // 执行方法
        result = method.invoke(target,args);
        // 反射方法后调用
        System.out.println("我说HEllo了");
        return result;
    }
}

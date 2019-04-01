package com.chuzihang.lesson.proxy.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Q_先生 on 2018/12/27.
 */
public class HelloServiceCgLib implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("###########我是CGLIB代理############");
        // 反射方法前调用
        System.out.println("我准备说Hello。。。。");
        // 执行方法
        Object result = methodProxy.invokeSuper(o, objects);
        // 反射方法后调用
        System.out.println("我说Hello了");

        return result;
    }
}

package com.chuzihang.lesson.concurrency.example.singleton;

import com.chuzihang.lesson.concurrency.annoations.ThreadSafe;

/**
 * @ClassName SingletonExample3
 * @Description 懒汉式
 * @Author Q_先生
 * @Date 2018/11/2 14:34
 **/
@ThreadSafe
public class SingletonExample3 {

    //构造私有化
    private SingletonExample3() {
    }
    //1. memory = allocate()分配对象的内存空间
    //2. 初始化对象
    //3. 设置instances指向刚刚分配的内存

    //单例对象 + volatile + 双重检测机制 -> 禁止指令重排
    private volatile static SingletonExample3 instance = null;

    //静态工厂方法
    public static SingletonExample3 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample3.class) {
                if (instance == null) {
                    instance = new SingletonExample3();
                }
            }
        }
        return instance;
    }
}

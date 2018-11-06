package com.chuzihang.lesson.concurrency.example.singleton;

import com.chuzihang.lesson.concurrency.annoations.NotRecommend;
import com.chuzihang.lesson.concurrency.annoations.ThreadSafe;

/**
 * @ClassName SingletonExample1
 * @Description 懒汉式
 * @Author Q_先生
 * @Date 2018/11/2 14:17
 **/
@ThreadSafe
@NotRecommend
public class SingletonExample1 {

    //构造私有化
    private SingletonExample1() {

    }

    //单例对象
    private static SingletonExample1 instance = null;

    public synchronized static SingletonExample1 getInstance() {
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }

}

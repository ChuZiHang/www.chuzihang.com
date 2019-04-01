package com.chuzihang.lesson.concurrency.example.singleton;

import com.chuzihang.lesson.concurrency.annoations.Recommend;
import com.chuzihang.lesson.concurrency.annoations.ThreadSafe;

/**
 * @ClassName SingletonExample4
 * @Description 饿汉式
 * @Author Q_先生
 * @Date 2018/11/2 14:35
 **/
@ThreadSafe
@Recommend
public class SingletonExample4 {
    //构造私有化
    private SingletonExample4() {

    }

    //单例对象
    static {
        instance = new SingletonExample4();
    }

    private static SingletonExample4 instance = null;

    public static SingletonExample4 getInstance() {
        return Singleton.INSTANCE.getInstace();
    }

    private enum Singleton {
        /*
         * @Author Q_先生
         */
        INSTANCE;

        private SingletonExample4 singleton;

        //JVM保证这个方法绝对只能调用一次
        Singleton() {
            singleton = new SingletonExample4();
        }

        public SingletonExample4 getInstace() {
            return singleton;
        }
    }
}

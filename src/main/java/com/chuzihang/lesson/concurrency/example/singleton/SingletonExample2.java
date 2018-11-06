package com.chuzihang.lesson.concurrency.example.singleton;

/**
 * @ClassName SingletonExample2
 * @Description 饿汉式
 * @Author Q_先生
 * @Date 2018/11/2 14:32
 **/
public class SingletonExample2 {

    //构造私有化
    private SingletonExample2() {

    }

    private static SingletonExample2 instance = null;

    //单例对象
    static {
        instance = new SingletonExample2();
    }


    public static SingletonExample2 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
    }

}

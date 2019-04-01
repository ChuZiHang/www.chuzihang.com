package com.chuzihang.lesson.designpatterns.abstractFactoryPattern;

/**
 * Created by Q_先生 on 2019/1/2.
 */
public class SummerTextField implements TextField {
    @Override
    public void display() {
        System.out.println("显示浅蓝色边框文本框");
    }
}

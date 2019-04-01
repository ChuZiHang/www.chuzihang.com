package com.chuzihang.lesson.designpatterns.abstractFactoryPattern;

/**
 * Created by Q_先生 on 2019/1/2.
 */
public class SpringButton implements Button {
    @Override
    public void display() {
        System.out.println("显示浅绿色的按钮");
    }
}

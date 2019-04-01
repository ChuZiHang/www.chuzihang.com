package com.chuzihang.lesson.designpatterns.simplefactorypattern;

/**
 * Created by Q_先生 on 2019/1/2.
 */
public class LineChart implements Chart{

    public LineChart() {
        System.out.println("创建折线图");
    }

    @Override
    public void display() {
        System.out.println("显示折线图");
    }
}

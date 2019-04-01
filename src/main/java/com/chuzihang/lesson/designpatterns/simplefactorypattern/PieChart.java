package com.chuzihang.lesson.designpatterns.simplefactorypattern;

/**
 * Created by Q_先生 on 2019/1/2.
 */
public class PieChart implements Chart {

    public PieChart() {
        System.out.println("创建饼状图");
    }

    @Override
    public void display() {
        System.out.println("显示饼状图");
    }
}

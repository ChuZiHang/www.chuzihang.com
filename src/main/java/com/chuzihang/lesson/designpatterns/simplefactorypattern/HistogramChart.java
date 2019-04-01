package com.chuzihang.lesson.designpatterns.simplefactorypattern;

/**
 * Created by Q_先生 on 2019/1/2.
 * 柱状图类：具体产品类
 */
public class HistogramChart implements Chart {

    public HistogramChart() {
        System.out.println("创建柱状图");
    }

    @Override
    public void display() {
        System.out.println("显示柱状图");
    }
}

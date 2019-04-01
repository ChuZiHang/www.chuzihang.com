package com.chuzihang.lesson.designpatterns.simplefactorypattern;

/**
 * Created by Q_先生 on 2019/1/2.
 */
public class Test {

    public static void main(String[] args) {
        Chart chart = ChartFactory.getChart("pie");
        chart.display();
    }
}

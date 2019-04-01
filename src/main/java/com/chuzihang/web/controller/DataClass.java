package com.chuzihang.web.controller;

/**
 * Created by Q_先生 on 2018/11/26.
 */
public class DataClass {
    public int i = 100;
}

class ObClass {
    public static void main(String[] args) {
        ObClass ob = new ObClass();
        ob.amethod();
    }

    public void amethod() {
        int i = 99;
        DataClass v = new DataClass();
        v.i = 99;
        another(v, i);
        System.out.println("v.i==============" + v.i);
        System.out.println("i================" + i);
    }

    public void another(DataClass v, int i) {
        i = 10;
        v.i = 200;
        DataClass vh = new DataClass();
        v = vh;
        System.out.println(v.i + " " + i);
    }
}

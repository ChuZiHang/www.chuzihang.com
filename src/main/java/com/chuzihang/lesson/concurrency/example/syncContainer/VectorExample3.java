package com.chuzihang.lesson.concurrency.example.syncContainer;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Vector;

/**
 * @ClassName VectorExample3
 * @Description TODO
 * @Author Q_先生
 * @Date 2018/11/2 15:18
 **/
@Slf4j
public class VectorExample3 {

    //java.util.ConcurrentModificationException
    public static void test1(Vector<Integer> v1) {
        for (Integer i : v1) {
            if (i.equals(3)) {
                v1.remove(i);
            }
        }
        log.info("list:{}", v1.size());
    }

    //java.util.ConcurrentModificationException
    public static void test2(Vector<Integer> v1) {
        Iterator<Integer> iterator = v1.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next.equals(3)) {
                v1.remove(next);
            }
        }
        log.info("list:{}", v1.size());
    }

    public static void test3(Vector<Integer> v1) {
        for (int i = 0; i < v1.size(); i++) {
            if (v1.get(i).equals(3)) {
                v1.remove(i);
            }
        }
        log.info("list:{}", v1.size());
    }

    public static void main(String[] args) {
        Vector<Integer> v1 = new Vector<>();
        v1.add(1);
        v1.add(2);
        v1.add(3);
        test3(v1);
    }
}

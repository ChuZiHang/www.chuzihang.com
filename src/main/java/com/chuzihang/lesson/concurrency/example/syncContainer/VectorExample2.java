package com.chuzihang.lesson.concurrency.example.syncContainer;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.Vector;
import java.util.stream.Stream;

/**
 * @ClassName VectorExample2
 * @Description TODO
 * @Author Q_先生
 * @Date 2018/11/2 15:11
 **/
@Slf4j
@NotThreadSafe
public class VectorExample2 {

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            Stream.iterate(0, n -> n + 1)
                    .limit(10)
                    .forEach(i -> vector.add(i));
            Runnable r1 = () -> {
                Stream.iterate(0, n -> n + 1)
                        .limit(10)
                        .forEach(i -> vector.remove(i));
            };
            Runnable r2 = () -> {
                Stream.iterate(0, n -> n + 1)
                        .limit(10)
                        .forEach(i -> vector.get(i));
            };

            new Thread(r1).run();
            new Thread(r2).run();
        }
    }

}

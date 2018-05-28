package com.chuzihang.lesson.java8.stream;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * Created by qw on 2018/5/25.
 */
public class TestForkJoin {

    public void test1() {
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0L, 10000000000L);
        Long sum = pool.invoke(task);
        System.out.println(sum);

        Instant end = Instant.now();

        System.out.println("耗费的时间为: " + Duration.between(start, end).toMillis());
    }

    public void test2() {
        Instant start = Instant.now();
        long sum = 0L;

        for (long i = 0L; i <= 10000000000L; i++) {
            sum += i;
        }

        System.out.println(sum);
        Instant end = Instant.now();

        System.out.println("耗费的时间为: " + Duration.between(start, end).toMillis());
    }

    public void test3() {
        Instant start = Instant.now();
        long sum = LongStream.rangeClosed(0L, 10000000000L)
                .parallel()
                .sum();
        System.out.println(sum);
        Instant end = Instant.now();

        System.out.println("耗费的时间为: " + Duration.between(start, end).toMillis());
    }

    public static void main(String[] args) {
        TestForkJoin testForkJoin = new TestForkJoin();
//        testForkJoin.test1(); // 2079
//        testForkJoin.test2(); // 3559
        testForkJoin.test3(); // 1759
    }

}

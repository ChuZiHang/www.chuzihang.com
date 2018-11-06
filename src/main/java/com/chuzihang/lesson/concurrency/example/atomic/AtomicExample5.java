package com.chuzihang.lesson.concurrency.example.atomic;

import com.chuzihang.lesson.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @ClassName AtomicExample3
 * @Description TODO
 * @Author Q_先生
 * @Date 2018/11/2 13:36
 **/
@Slf4j
@ThreadSafe
public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    @Getter
    public volatile int count = 100;

    private static AtomicExample5 atomicExample5 = new AtomicExample5();

    public static void main(String[] args) {
        if (updater.compareAndSet(atomicExample5, 100, 120)) {
            log.info("update success,{}", atomicExample5.getCount());
        }
        if (updater.compareAndSet(atomicExample5, 100, 120)) {
            log.info("update success,{}", atomicExample5.getCount());
        } else {
            log.error("update error{}", atomicExample5.getCount());
        }
    }
}

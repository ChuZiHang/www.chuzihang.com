package com.chuzihang.lesson.concurrency.example.lock;

import com.chuzihang.lesson.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

/**
 * @ClassName LockExample1
 * @Description TODO
 * @Author Q_先生
 * @Date 2018/11/2 15:53
 **/
@Slf4j
@ThreadSafe
public class LockExample1 {

    /*
     * 1. ReentrantLock(可重入锁) 和 synchronized的区别
     *   可重入性
     *  锁的实现-JDK&JVM
     *  性能的区别:synchronized的优化后两者性能差不多
     *  功能的区别
     * 2. ReentrantLock特有的功能
     *   可以指定是公平锁还是非公平锁
     *  提供了一个condition类,可以分组唤醒需要唤醒的线程
     *  提供中断等待锁的线程的机制,lock.lockInterruptibly()
     */

    public static int clientTotal = 5000;

    public static int threadTotal = 200;

    public static int count = 0;

    public final static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量
        final Semaphore semaphore = new Semaphore(threadTotal);
        //计数器闭锁
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        Stream.iterate(0, n -> n + 1)
                .limit(clientTotal)
                .forEach(e -> {
                    executorService.execute(() -> {
                        try {
                            semaphore.acquire();
                            add();
                            semaphore.release();
                        } catch (Exception e1) {
                            log.error("exception", e);
                        }
                        countDownLatch.countDown();
                    });
                });
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}", count);
    }

    public static void add() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
}

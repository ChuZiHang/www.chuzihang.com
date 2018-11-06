package com.chuzihang.lesson.concurrency.example.atomic;

import com.chuzihang.lesson.concurrency.annoations.NotRecommend;
import com.chuzihang.lesson.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.LongAdder;

/**
 * @ClassName AtomicExample3
 * @Description TODO
 * @Author Q_先生
 * @Date 2018/11/2 13:36
 **/
@Slf4j
@ThreadSafe
public class AtomicExample3 {
    public static int clientTotal = 5000;//请求中数

    public static int threadTotal = 200;//同时并发执程总数

    public static LongAdder count = new LongAdder();

    //模拟并发执行
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("interruptedException", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}", count);
    }

    //计数方法
    private static void add() {
        count.increment();//先执行增加操作，再获取值
    }
}

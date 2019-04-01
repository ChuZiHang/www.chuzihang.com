package com.chuzihang.lesson.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName SynchronizedExample1
 * @Description TODO
 * @Author Q_先生
 * @Date 2018/11/2 14:55
 **/
@Slf4j
public class SynchronizedExample1 {



    /**
     * synchronized:
     * 	修饰代码块:作用于调用的对象
     * 	修饰方法:作用于调用的对象
     * 	修饰静态方法:作用于所有对象
     * 	修饰类:作用于所有对象
     * synchronized-Lock-Atomic
     * 	synchronized:不可中断锁,适合竞争不激烈,可读性好
     * 	Lock:可中断锁,多样化同步,竞争激烈时能维持常态
     * 	Atomic:竞争激烈时能维持常态,比Lock性能好,只能同步一个值
     *
     * 	可见性:
     *     一个线程对主内存的修改,可以及时的被其他线程观察到
     * 导致共享变量不可见的原因:
     *     1. 线程交叉执行
     *     2. 重新排序结合线程交叉执行
     *     3. 共享变量更新后的值没有在工作内存和主内存及时的更新
     * 可见性:JMM 关于synchronized的两条规定
     *     1. 线程解锁前,必须把共享变量刷新回主内存
     *     2. 线程加锁前,将清空工作内存中的值,重新从主内存中读取最新的值
     * 可见性:volatile
     *     通过加入内存屏障和进制重排序优化来实现
     *     1. 在读取变量时,会在读操作之前加入一条load指令,将主内存中的值重新加载到工作区
     *     2. 在写变量时,会在写操作之后加入一条store指令,将工作内存中的值刷新回主内存
     *     volatile:不具有原子性
     *         1. 适合做状态标记量
     */


    //修饰一个代码块
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} - {}", j, i);
            }
        }
    }

    //修饰一个方法
    public synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} - {}", j, i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example2.test1(1);
        });
        executorService.execute(() -> {
            example1.test1(2);
        });
    }
}

package com.algorithm.highFreqQ.PrintABC;

import java.util.concurrent.locks.Lock;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/12/ 12:04
 */
// 按序打印ABC
public class PrintTest{
    private Lock lock;
    private final int limit;
    private volatile int count;

    public PrintTest(int count, int limit) {
        this.count = count;
        this.limit = limit;
    }


    public void run(int state) {
        while (count < limit) {
            lock.lock();
            while (count % 3 == state) {
                System.out.println(Thread.currentThread().getName() + " print " + ++count);
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        PrintTest printTest = new PrintTest(0, 30);
        new Thread(()->{
            printTest.run(0);
        }).start();
        new Thread(()->{
            printTest.run(1);
        }).start();
        new Thread(()->{
            printTest.run(2);
        }).start();
    }
}

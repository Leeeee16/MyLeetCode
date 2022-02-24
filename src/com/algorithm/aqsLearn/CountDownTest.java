package com.algorithm.aqsLearn;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/17/ 16:02
 */
public class CountDownTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        System.out.println("in " + Thread.currentThread().getName() + "...");
        System.out.println("before latch.await()...");

        for (int i = 1; i <= 3; i++) {
            new Thread("T" + i) {
                @Override
                public void run() {
                    System.out.println("enter Thread " + getName() + "...");
                    System.out.println("execute countdown...");
                    System.out.println("exit Thread" + getName() + ".");
                    latch.countDown();
                }
            }.start();
        }
        latch.await();

        System.out.println("in " + Thread.currentThread().getName() + "...");
        System.out.println("after latch.await()...");
    }
}

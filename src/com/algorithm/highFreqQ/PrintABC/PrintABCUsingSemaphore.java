package com.algorithm.highFreqQ.PrintABC;

import java.util.concurrent.Semaphore;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/11/ 16:15
 */
public class PrintABCUsingSemaphore {
    private int times;
    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);

    public PrintABCUsingSemaphore(int times) {
        this.times = times;
    }

    public static void main(String[] args) {
        PrintABCUsingSemaphore printABCUsingSemaphore = new PrintABCUsingSemaphore(10);
        new Thread(() -> printABCUsingSemaphore.print("A", semaphoreA, semaphoreB)).start();
        new Thread(() -> printABCUsingSemaphore.print("B", semaphoreB, semaphoreC)).start();
        new Thread(() -> printABCUsingSemaphore.print("C", semaphoreC, semaphoreA)).start();
    }

    private void print(String name, Semaphore current, Semaphore next) {
        for (int i = 0; i < times; i++) {
            try {
                // A获取信号，A信号量减1
                current.acquire();
                System.out.println(Thread.currentThread().getName() + "：" + name);
                // A释放信号给B，B信号量加1
                next.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

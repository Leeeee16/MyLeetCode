package com.algorithm.highFreqQ.PrintOddEven;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/11/ 16:50
 */
public class OddEvenPrinter {

    private final Object monitor = new Object();
    private final int limit;
    private volatile int count;

    public OddEvenPrinter(int initCount, int times) {
        this.count = initCount;
        this.limit = times;
    }

    public static void main(String[] args) {
        OddEvenPrinter oddEvenPrinter = new OddEvenPrinter(0,10);
        new Thread(oddEvenPrinter::print,"odd").start();
        new Thread(oddEvenPrinter::print,"even").start();
    }

    private void print() {
        synchronized (monitor) {
            while (count < limit) {
                try {
                    System.out.printf("线程[%s]打印数字:%d%n", Thread.currentThread().getName(), ++count);
                    monitor.notifyAll();
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            monitor.notifyAll();
        }
    }
}

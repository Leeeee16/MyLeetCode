package com.algorithm.highFreqQ.PrintABC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/11/ 16:07
 */
public class PrintABCUsingLock {
    // 要打印的次数
    private int times;
    private int state;
    private Lock lock = new ReentrantLock();

    public PrintABCUsingLock(int times) {
        this.times = times;
    }

    public static void main(String[] args) {
        PrintABCUsingLock printABC = new PrintABCUsingLock(10);
        new Thread(printABC::printA).start();
        new Thread(printABC::printB).start();
        new Thread(printABC::printC).start();
    }

    public void printA() {
        print("A",0);
    }

    public void printB() {
        print("B",1);
    }

    public void printC() {
        print("C",2);
    }

    private void print(String name, int targetState) {
        for (int i = 0; i < times;) {
            lock.lock();
            if (state % 3 == targetState) {
                state++;
                i++;
                System.out.print(name + " ");
            }
            lock.unlock();
        }
    }
}

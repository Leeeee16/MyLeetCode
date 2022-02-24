package com.algorithm.highFreqQ.PrintABC;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/12/ 10:47
 */
public class PrintABCUsingLockSupport {

    private static final int TIMES = 10;

    private static Thread threadA;
    private static Thread threadB;
    private static Thread threadC;

    public static void main(String[] args) {
        threadA = new Thread(()->{
            for (int i = 0; i < TIMES; i++) {
                System.out.println(Thread.currentThread().getName() + "：A");
                // 唤醒下一个进程
                LockSupport.unpark(threadB);
                // 当前进程阻塞
                LockSupport.park();
            }
        });
        threadB = new Thread(()->{
            for (int i = 0; i < TIMES; i++) {
                // 先阻塞，等待被唤醒
                LockSupport.park();
                System.out.println(Thread.currentThread().getName() + "：B");
                LockSupport.unpark(threadC);
            }
        });
        threadC = new Thread(()->{
            for (int i = 0; i < TIMES; i++) {
                LockSupport.park();
                LockSupport.unpark(threadA);
                System.out.println(Thread.currentThread().getName() + "：C");
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
    }

}

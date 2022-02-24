package com.algorithm.highFreqQ.PrintABC;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/12/ 10:57
 */
public class PrintLetterAndNum {
    private static Thread threadA;
    private static Thread threadNum;

    public static void main(String[] args) {
        threadNum = new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                System.out.println(Thread.currentThread().getName() + "：" + (i + 1));
                LockSupport.unpark(threadA);
                LockSupport.park();
            }
        });
        threadA = new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName() + "：" + (char)('A' + i));
                LockSupport.unpark(threadNum);
            }
        });
        threadNum.start();
        threadA.start();
    }
}

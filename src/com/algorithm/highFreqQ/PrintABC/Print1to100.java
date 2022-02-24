package com.algorithm.highFreqQ.PrintABC;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/25/ 22:36
 */
public class Print1to100 {
    volatile int flag = 0;

    public void runThread() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            int i = 0;
            while (i <= 99) {
                if (flag == 0) {
                    System.out.println("t1 " + i + " flag = " + flag);
                    i += 2;
                    flag = 1;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            int i = 1;
            while (i <= 99) {
                if (flag == 1) {
                    System.out.println("t2 " + i + " flag = " + flag);
                    i += 2;
                    flag = 2;
                }
            }
        });
        Thread t3 = new Thread(() -> {
            int i = 3;
            while (i <= 99) {
                if (flag == 2) {
                    System.out.println("t3 " + i + " flag = " + flag);
                    i += 2;
                    flag = 0;
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }

    public static void main(String[] args) throws InterruptedException {
        Print1to100 print1to100 = new Print1to100();
        print1to100.runThread();
    }
}

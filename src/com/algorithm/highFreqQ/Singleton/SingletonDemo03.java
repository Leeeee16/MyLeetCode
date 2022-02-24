package com.algorithm.highFreqQ.Singleton;

/**
 * @Description: 懒汉式，双重锁 Double checkLock(DCL)，
 * @author: lqy
 * @date: 2021/04/03/ 9:50
 */
public class SingletonDemo03 {

    public static void main(String[] args) {
        Singleton3 s1 = Singleton3.getInstance();
        Singleton3 s2 = Singleton3.getInstance();
        System.out.println(s1 == s2);
        System.out.println();
    }
}

class Singleton3 {
    private static Singleton3 singleton3;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        if (singleton3 == null) {
            synchronized (Singleton3.class) {
                if (singleton3 == null) {
                    singleton3 = new Singleton3();
                }
            }
        }
        return singleton3;
    }
}

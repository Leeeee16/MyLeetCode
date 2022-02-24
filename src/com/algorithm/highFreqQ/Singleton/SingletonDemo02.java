package com.algorithm.highFreqQ.Singleton;

/**
 * @Description: 线程安全，调用效率低，可以延时加载
 * @author: lqy
 * @date: 2021/04/03/ 9:47
 */
public class SingletonDemo02 {
    // 类初始化时，未初始化对象(即延时加载)
    private static SingletonDemo02 singletonDemo02;

    private SingletonDemo02() {
    }

    // 同步方法，调用效率低
    public static synchronized SingletonDemo02 getInstance() {
        if (singletonDemo02 == null) {
            singletonDemo02 = new SingletonDemo02();
        }
        return singletonDemo02;
    }
}

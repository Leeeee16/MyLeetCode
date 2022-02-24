package com.algorithm.highFreqQ.Singleton;

/**
 * @Description: 饿汉式，线程安全，调用效率高，不能延时加载
 * @author: lqy
 * @date: 2021/04/03/ 9:45
 */
public class SingletonDemo01 {
    private static SingletonDemo01 singletonDemo01 = new SingletonDemo01();

    public SingletonDemo01() {
    }

    public static SingletonDemo01 getInstance() {
        return singletonDemo01;
    }
}

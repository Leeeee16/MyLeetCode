package com.algorithm.highFreqQ.Singleton;

/**
 * @Description: 内部静态类，线程安全，调用效率高，可延时加载
 * @author: lqy
 * @date: 2021/04/03/ 9:55
 */
public class SingletonDemo04 {
    private static class SingletonHolder {
        private static SingletonDemo04 singletonDemo04;
    }

    private SingletonDemo04(){}

    public static SingletonDemo04 getInstance() {
        return SingletonHolder.singletonDemo04;
    }
}

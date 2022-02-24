package com.algorithm.highFreqQ.Singleton;

/**
 * @Description: 线程安全，调用效率高，不能延迟加载，可防止反射和反序列化调用
 * @author: lqy
 * @date: 2021/04/03/ 9:58
 */
public enum SingletonDemo05 {
    // 定义一个枚举元素，代表Singleton的一个实例
    INSTANCE;

    public void singletonOperation() {
        System.out.println("功能处理");
    }
}

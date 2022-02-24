package com.algorithm.dynamicProgramming.ZeroOneKnapsack.Solution4;

/**
 * 物品类
 */
public class ItemInfo {

    /**
     * 重量
     */
    private int weight;

    /**
     * 价值
     */
    private int value;

    public ItemInfo() {}

    public ItemInfo(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

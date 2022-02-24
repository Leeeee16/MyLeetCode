package com.algorithm.dynamicProgramming.ZeroOneKnapsack.Solution3;


import java.util.ArrayList;
import java.util.List;

public class Knap {
    int n;
    int capacity;
    int[] weight;
    double[] value;
    int maxValue = 0;
    int tempValue;
    int tempWeight;
    // 记录当前选择
    int[] way;
    // 记录最佳选择
    int[] bestWay;
    // 按物品性价比降序排列的物品列表
    List<Item> items;

    public Knap(int n, int capacity, int[] weight, double[] value) {
        this.n = n;
        this.capacity = capacity;
        this.weight = weight;
        this.value = value;
        this.way = new int[n];
        this.bestWay = new int[n];
        this.items = new ArrayList<>(n);
        init(weight, value);
    }

    // 物品类
    class Item {
        private int weight;
        private double value;
        // 单位重量的价值
        private final double unitValue;

        public Item(int weight, double value) {
            this.weight = weight;
            this.value = value;
            this.unitValue = value / weight;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public double getUnitValue() {
            return unitValue;
        }

    }

    private void init(int[] weight, double[] value) {
        for (int i = 0; i < n; i++) {
            items.add(new Item(weight[i], value[i]));
        }
        items.sort((o1, o2) -> Double.compare(o2.getUnitValue(), o1.getUnitValue()));
    }

    public void BackTrack(int t) {
        // 搜索到叶节点，更新最大价值和选择
        if (t > n - 1) {
            if (tempValue > maxValue) {
                maxValue = tempValue;
                for (int i = 0; i < n; i++)
                    bestWay[i] = way[i];
            }
            return;
        }
        // 搜索左边节点
        if (tempWeight + items.get(t).weight <= capacity) {
            tempWeight += items.get(t).weight;
            tempValue += items.get(t).value;
            way[t] = 1;
            BackTrack(t + 1);
            // 回溯，状态还原
            tempWeight -= items.get(t).weight;
            tempValue -= items.get(t).value;
            way[t] = 0;
        }
        // 不拿当前物品，向右搜索；判断右节点上界：上界大于maxValue，向右搜索；否则剪枝
        if (Bound(t + 1) >= maxValue) {
            BackTrack(t + 1);
        }
    }

    // 计算剩余物品的最高价值上界
    public double Bound(int k) {
        double maxLeft = tempValue;
        int leftWeight = capacity - tempWeight;
        // 贪心选择，每次将性价比最高的物品放入
        while (k <= n - 1 && leftWeight >= items.get(k).weight) {
            leftWeight -= items.get(k).weight;
            maxLeft += items.get(k).value;
            k++;
        }
        //剩余的空间：下一个物品的单位质量 * 剩余空间  得到价值上界
        if (k <= n - 1) {
            maxLeft += items.get(k).unitValue * leftWeight;
        }
        return maxLeft;
    }

    public void printItems(List<Item> items) {
        for (int i = 0; i < n; i++) {
            System.out.print("[" + items.get(i).weight + " ," + (int) items.get(i).value + "]" + "\t");
        }
        System.out.println();
    }
}



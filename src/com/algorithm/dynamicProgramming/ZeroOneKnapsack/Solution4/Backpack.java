package com.algorithm.dynamicProgramming.ZeroOneKnapsack.Solution4;

import java.util.ArrayList;
import java.util.Scanner;

/*
4 10
4 40
7 42
5 25
3 12
*/

/**
 * 背包
 */
public class Backpack {

    /**
     * 总容量
     */
    private int capacity;

    /**
     * 总数量
     */
    private int number;

    public BinaryTree binaryTree;

    /**
     * 初始化
     */
    public void initialization() {
        // 创建根节点
        Node head = new Node();
        head.setWeight(0);
        head.setValue(0);
        head.setLayer(0);
        head.setCurrentSolution("");
        // 根据每单位质量价值来从大到小排序
        binaryTree.getItemInfoList().sort((o1, o2) -> {
            Double a = (double) (o1.getValue() / o1.getWeight());
            Double b = (double) (o2.getValue() / o2.getWeight());
            return b.compareTo(a);
        });
        ItemInfo firstNode = binaryTree.getItemInfoList().get(0);
        head.setUp(capacity * (firstNode.getValue() * 1.0 / firstNode.getWeight()));
        binaryTree.setBackpack(this);
        // 创建树
        binaryTree.createdBinaryTree(head, 0);
        binaryTree.branchBound(head);
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        // 物品数量
        number = scanner.nextInt();
        // 背包容量
        capacity = scanner.nextInt();
        binaryTree.setItemInfoList(new ArrayList<>(number));
        // 将物品添加到List中
        for(int i = 0; i < number; i++) {
            int weight = scanner.nextInt();
            int value = scanner.nextInt();
            ItemInfo itemInfo = new ItemInfo(weight, value);
            binaryTree.getItemInfoList().add(itemInfo);
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

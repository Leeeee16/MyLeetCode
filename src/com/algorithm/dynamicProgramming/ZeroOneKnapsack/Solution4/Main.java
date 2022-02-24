package com.algorithm.dynamicProgramming.ZeroOneKnapsack.Solution4;

public class Main {

    public static void main(String[] args) {
        Backpack backpack = new Backpack();
        backpack.binaryTree = new BinaryTree();
        backpack.input();
        backpack.initialization();
        System.out.println("最大价值为：" + backpack.binaryTree.getMax());
        String bestSolution = backpack.binaryTree.getBestSolution();
        System.out.println("拿取的物品为：");
        for(int i = 0; i < bestSolution.length(); i++) {
            if(bestSolution.charAt(i) != '0') {
                ItemInfo itemInfo = backpack.binaryTree.getItemInfoList().get(i);
                System.out.println("[" + itemInfo.getWeight() + " " + itemInfo.getValue() + "]");
            }
        }
    }
/*
4 5
1 2
2 4
3 4
4 5
 */
}

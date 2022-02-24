package com.algorithm.BinaryTree.Important.LeetCode105;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution3 {
    // 用HashMap优化 寻找根节点在中序遍历结果的坐标
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen != inLen) {
            throw new RuntimeException("输入数据有误");
        }
        this.map = new HashMap<>(inLen);
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preLen - 1, inorder, 0, inLen - 1);
    }


    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                               int[] inorder, int inLeft, int inRight) {
        // 递归终止条件
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        // 先序遍历的第一个元素就是根
        int pivot = preorder[preLeft];
        TreeNode root = new TreeNode(pivot);
        // 找到根在中序结果的下标
        int pivotIndex = map.get(pivot);
        // 递归左和右，注意区间边界的计算
        root.left = buildTree(preorder, preLeft + 1, pivotIndex - inLeft + preLeft,
                inorder, inLeft, pivotIndex - 1);
        root.right = buildTree(preorder, pivotIndex - inLeft + preLeft + 1, preRight,
                inorder, pivotIndex + 1, preRight);
        return root;
    }

}

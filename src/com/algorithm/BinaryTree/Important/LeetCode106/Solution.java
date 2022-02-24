package com.algorithm.BinaryTree.Important.LeetCode106;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int postLen = postorder.length;
        if (inLen != postLen) {
            throw new RuntimeException("参数错误");
        }
        this.map = new HashMap<>(inLen);
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inLen - 1, postorder, 0, postLen - 1);
    }

    public TreeNode buildTree(int[] inorder, int inLeft, int inRight,
                              int[] postorder, int postLeft, int postRight) {
        // 递归停止条件
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        // 根节点的值,根节点是后续遍历结果的最后一个数
        int pivot = postorder[postRight];
        TreeNode root = new TreeNode(pivot);
        // 根节点在中序的位置
        int inPivot = map.get(pivot);
        // 左区间的长度
        int leftSize = inPivot - inLeft;
        root.left = buildTree(inorder, inLeft, inPivot - 1,
                postorder, postLeft, postLeft + leftSize - 1);
        root.right = buildTree(inorder, inPivot + 1, inRight,
                postorder, postLeft + leftSize, postRight - 1);
        return root;
    }
}

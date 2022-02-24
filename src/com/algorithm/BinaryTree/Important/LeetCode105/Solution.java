package com.algorithm.BinaryTree.Important.LeetCode105;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (len == 0) {
            return null;
        }

        return buildTree(preorder, 0, len - 1, inorder, 0, len - 1);

    }

    // 返回: 区间的根节点

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        // 根节点
        TreeNode root = new TreeNode(preorder[preLeft]);
        // 中序根节点下标
        int inMid = -1;
        // 将中序分成 左 右 两个区间
        for (int i = inLeft; i <= inRight; i++) {
            if (root.val == inorder[i]) {
                inMid = i;
            }
        }
        // 左区间的大小
        int leftSize = inMid - inLeft;
        // 注意下标的计算
        root.left = buildTree(preorder, preLeft + 1, preLeft + leftSize, inorder, inLeft, inMid - 1);
        root.right = buildTree(preorder, preLeft + leftSize + 1, preRight, inorder, inMid + 1, inRight);
        return root;
    }
}

package com.algorithm.binarySearchTree.basic.LeetCode98;


public class Solution {
    // 记录中序遍历前一个节点的值
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 判断当前节点的值 是否小于中序遍历前一个节点的值
        // 当前值 < 中序的前一个值：不满足
        // 当前值 >= 中序的前一个值：满足
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 遍历右子树
        return isValidBST(root.right);
    }
}

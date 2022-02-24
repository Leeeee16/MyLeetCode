package com.algorithm.binarySearchTree.basic.LeetCode450;

public class Solution {
    // 返回删除后的新二叉搜索树的根节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val == key) {
            // 删除
            // 找到的节点为叶节点
            if (root.left == null && root.right == null) {
                return null;
            }
            // 非叶节点，有一个子节点
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // 非叶节点，有两个子节点
            // 找到右子树的最小节点
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    // 返回当前子树的最小节点
    public TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}


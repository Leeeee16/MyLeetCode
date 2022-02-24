package com.algorithm.BinaryTree.Important.LeetCode105;

public class Solution2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen != inLen) {
            throw new RuntimeException("输入数据有误");
        }
        return buildTree(preorder, 0, preLen - 1, inorder, 0, inLen - 1);
    }

    /**
     * @param preorder 二叉树前序遍历结果
     * @param preLeft  二叉树前序遍历结果的左边界
     * @param preRight 二叉树前序遍历结果的右边界
     * @param inorder  二叉树中序遍历的结果
     * @param inLeft   二叉树中序遍历结果的左边界
     * @param inRight  二叉树中序遍历结果的右边界
     * @return 二叉树的根节点
     */
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
        int pivotIndex = inLeft;
        while (inorder[pivotIndex] != pivot) {
            pivotIndex++;
        }
        // 递归左和右，注意区间边界的计算
        root.left = buildTree(preorder, preLeft + 1, pivotIndex - inLeft + preLeft,
                inorder, inLeft, pivotIndex - 1);
        root.right = buildTree(preorder, pivotIndex - inLeft + preLeft + 1, preRight,
                inorder, pivotIndex + 1, preRight);
        return root;
    }
}

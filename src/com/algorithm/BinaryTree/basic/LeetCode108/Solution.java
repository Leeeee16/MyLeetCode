package com.algorithm.BinaryTree.basic.LeetCode108;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        return sortedHelper(nums, 0, len - 1);
    }

    private TreeNode sortedHelper(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        if(lo == hi) {
            return new TreeNode(nums[lo]);
        }
        int mid = lo + (hi - lo) / 2;
        TreeNode curNode = new TreeNode(nums[mid]);
        curNode.left = sortedHelper(nums, lo, mid - 1);
        curNode.right = sortedHelper(nums, mid + 1, hi);
        return curNode;
    }
}

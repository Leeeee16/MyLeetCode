package com.algorithm.BinaryTree.basic.LeetCode109;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        return dfs(nums, 0, nums.size() - 1);
    }

    private TreeNode dfs(List<Integer> nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = lo + (hi - lo) / 2;
        TreeNode curNode = new TreeNode(nums.get(mid));
        curNode.left = dfs(nums, lo, mid - 1);
        curNode.right = dfs(nums, mid + 1, hi);
        return curNode;
    }
}

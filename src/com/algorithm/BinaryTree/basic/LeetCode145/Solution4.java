package com.algorithm.BinaryTree.basic.LeetCode145;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/08/ 9:18
 */
class Solution4 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode cur = stack1.pop();
            if (cur.left != null) {
                stack1.push(cur.left);
            }
            if (cur.right != null) {
                stack1.push(cur.right);
            }
            stack2.push(cur);
        }
        while (!stack2.isEmpty()) {
            TreeNode cur = stack2.pop();
            res.add(cur.val);
        }
        return res;
    }
}

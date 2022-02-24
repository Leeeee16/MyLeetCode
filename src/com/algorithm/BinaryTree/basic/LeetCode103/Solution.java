package com.algorithm.BinaryTree.basic.LeetCode103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        boolean fromLeft = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> nodes = new ArrayList<>();
            int curSize = queue.size();

            // 每次循环处理上一轮入队的元素，即一层
            while (curSize > 0) {
                TreeNode cur = queue.poll();
                // 左右只需要改变插入这一层数组的位置
                if(fromLeft) {
                    nodes.add(cur.val);
                } else {
                    nodes.add(0, cur.val);
                }

                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                curSize--;
            }
            // 改变方向
            fromLeft = !fromLeft;
            res.add(nodes);
        }
        return res;
    }
}

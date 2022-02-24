package com.algorithm.jianzhi.jianzhi37;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/05/08/ 15:01
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 特判
        if (root == null) {
            return "";
        }
        // 保存序列化结果
        StringBuilder sb = new StringBuilder();
        // 深度优先遍历二叉树
        dfs(root, sb);
        return sb.toString();
    }

    // 先序
    private void dfs(TreeNode root, StringBuilder sb) {
        // 如果是null，则用"#"标记，并用","隔开
        if (root == null) {
            sb.append("#").append(",");
            return;
        }
        // 将当前节点存入sb
        sb.append(root.val).append(",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 特判
        if (data.length() == 0) {
            return null;
        }
        // 从序列化数据中分离出各个节点的值
        String[] split = data.split(",");
        // 存入一个队列
        Queue<String> queue = new LinkedList<>();
        for (String s : split) {
            queue.offer(s);
        }
        // 深度优先复原成二叉树
        return dfs(queue);
    }

    private TreeNode dfs(Queue<String> queue) {
        // 特判
        if (queue.isEmpty()) {
            return null;
        }
        // 取出队头元素
        String head = queue.poll();
        // 如果遇到"#"则为null
        if (head.equals("#")) {
            return null;
        }
        // 新建一个节点
        TreeNode node = new TreeNode(Integer.parseInt(head));
        // 向左向右继续递归
        node.left = dfs(queue);
        node.right = dfs(queue);
        return node;
    }


}

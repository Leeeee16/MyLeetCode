package com.algorithm.demo;

/**
 * @author: lqy
 * @create: 2020/10/15
 * @description: LeetCode116
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有next 指针都被设置为 NULL。
 */
public class LeetCode116 {
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        // 方法一：层次遍历，用到辅助队列 时空复杂度都为O(N)
        /*
        if (root == null) return root;
        // 初始化并加入根节点
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        // 外层迭代为层数
        while (!queue.isEmpty()) {
            // 记录当前队列大小
            int size = queue.size();
            // 遍历这一层所有节点
            for (int i = 0; i < size; i++) {
                Node node = queue.poll(); // 取出队首元素
                if (i < size - 1) {
                    node.next = queue.peek(); // 连接
                }
                //拓展下一层节点
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        // 返回根节点
        return root;
        */

        // 方法二：利用已经建立的next指针，时间O(N)，空间O(1)
        if(root == null) return root;
        Node leftmost = root;

        while(leftmost.left != null) {
            // 遍历这一层节点组成的链表，为下一层的节点更新next指针
            Node head = leftmost;
            while(head != null) {
                // 第一种连接，父节点左右子孩子连接
                head.left.next = head.right;
                // 第二种，父节点的右孩子  和  父节点兄弟的左孩子 连接
                if(head.next != null) {
                    head.right.next = head.next.left;
                }
                // 指针向后移动
                head = head.next;
            }
            // 去下一层的最左节点
            leftmost = leftmost.left;
        }
        return root;
    }


    public static void main(String[] args) {

    }

}

package com.algorithm.RBTree;

import java.util.LinkedList;

/**
 * @author: lqy
 * @create: 2020/11/27
 * @description: MyRBTree
 */
public class MyRBTree<T extends Comparable<T>> {
    // 根节点
    private RBTreeNode<T> root;

    public MyRBTree(RBTreeNode<T> root) {
        this.root = root;
    }

    public RBTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(RBTreeNode<T> root) {
        this.root = root;
    }


    /**
     * 通过value查找是否存在，找到则返回值为value的那个节点，没找到返回null
     *
     * @param value
     * @return
     */
    private RBTreeNode<T> find(T value) {
        if (value == null) {
            // 抛出异常，表示传递的参数异常或非法
            throw new IllegalArgumentException("find()的参数为null!");
        }
        RBTreeNode<T> x = root;
        int cmp;
        while (x != null) {
            cmp = value.compareTo(x.getValue());
            if (cmp < 0) {
                x = x.getLeft();
            } else if (cmp > 0) {
                x = x.getRight();
            } else {
                // 找到
                return x;
            }
        }
        // 没找到
        return null;
    }


    /**
     * 插入一个节点
     *
     * @param value：插入节点的value值
     */
    public void insert(T value) {
        RBTreeNode<T> t = new RBTreeNode<T>(value);
        insert(t);
    }

    /**
     * 插入一个节点
     * 同二叉搜索树
     *
     * @param node
     */
    public void insert(RBTreeNode<T> node) {
        node.setIsRed(true); // 插入红色节点

        int cmp;
        // 找到插入的位置，并找到添加位置的父节点
        RBTreeNode<T> parent = getInsertParent(node);
        node.setParent(parent);

        // 父节点为空，表示插入节点为根节点
        if (parent == null) {
            setRoot(node);
        } else {
            // 判断插入节点是父节点的左孩子还是右孩子
            cmp = node.getValue().compareTo(parent.getValue());
            if (cmp < 0) {
                parent.setLeft(node);
            } else {
                parent.setRight(node);
            }
        }
        // 修正红黑树
        InsertFixUp(node);
    }

    /**
     * 红黑树插入修正
     *
     * @param node
     */
    private void InsertFixUp(RBTreeNode<T> node) {
        RBTreeNode<T> parent = node.getParent();

        // 父节点存在且为红色
        while (parent != null && parent.isRed()) {
            RBTreeNode<T> ancestor = parent.getParent();
            // 1. 如果父节点是祖父节点的左孩子
            RBTreeNode<T> uncle = getUncle(node);
            if (parent == ancestor.getLeft()) {
                // Case1：父节点和叔叔节点均为红色
                // 父节点和叔叔节点变为黑色，祖父变红
                // 对祖父节点进行插入修正
                if (uncle != null && uncle.isRed()) {
                    parent.setBlack();
                    uncle.setBlack();
                    ancestor.setRed();
                    node = ancestor;
                    parent = node.getParent();
                    continue;
                }

                // Case3：叔叔节点为黑或空且插入节点为右孩子
                // 对父节点进行左旋
                if (parent.getRight() == node) {
                    RBTreeNode<T> tmp;
                    leftRotate(parent);
                    // 交换parent和node
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }

                // Case2：叔叔节点为黑或空且插入节点为左孩子
                // 父节点变黑 + 祖父节点变红 + 父节点右旋
                parent.setBlack();
                ancestor.setRed();
                rightRotate(ancestor);
            } else {
                // 1. 父节点为祖父节点的右孩子，与上面镜像处理
                // Case1
                if (uncle != null && uncle.isRed()) {
                    uncle.setBlack();
                    parent.setBlack();
                    ancestor.setRed();
                    node = ancestor;
                    parent = node.getParent();
                    continue;
                }
                // Case3
                if (parent.getLeft() == node) {
                    RBTreeNode<T> tmp;
                    rightRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }

                // Case2
                parent.setBlack();
                ancestor.setRed();
                leftRotate(ancestor);
            }
        }
        root.setBlack();
    }

    /**
     * 从红黑树删除一个节点
     *
     * @param value：删除节点的key
     */
    public void remove(T value) {
        if (value == null) {
            throw new IllegalArgumentException("remove参数为null");
        } else {
            RBTreeNode<T> node = find(value);
            if (node != null && value == node.getValue()) {
                remove(node);
            } else {
                System.out.println("不存在该节点");
            }
        }
    }

    /**
     * 删除一个节点
     *
     * @param node:待删除的节点
     */
    private void remove(RBTreeNode<T> node) {
        RBTreeNode<T> child;
        RBTreeNode<T> parent;
        boolean isRed;

        // 被删除节点左右孩子都不为空
        if (node.getLeft() != null && node.getRight() != null) {
            // 找后继节点
            RBTreeNode<T> replace = getSuccessor(node);
            // 将 后继节点 与 待删除节点node 交换
            // 判断node是否为root
            if (node.getParent() != null) {
                // node是父节点的左孩子
                if (node.getParent().getLeft() == node) {
                    node.getParent().setLeft(replace);
                } else {
                    node.getParent().setRight(replace);
                }
            } else {
                setRoot(replace);
            }

            child = replace.getRight();
            parent = replace.getParent();
            isRed = replace.isRed();

            if (parent == node) {
                parent = replace;
            } else {
                // 将replace的父节点和右孩子连接
                if (child != null) {
                    child.setParent(parent);
                }
                parent.setLeft(child);
                // replace连接node的右孩子
                replace.setRight(node.getRight());
                node.getRight().setParent(replace);
            }

            // replace和node父节点、左孩子连接
            replace.setParent(node.getParent());
            replace.setIsRed(node.isRed());
            replace.setLeft(node.getLeft());
            node.getLeft().setParent(replace);

            // 判断是否需要修正
            if (replace.isBlack()) {
                removeFixUp(child, parent);
            }
            node = null;
            return;
        }

        // 被删节点只有一个孩子
        // 将被删节点 与 孩子节点 交换
        if (node.getLeft() != null) {
            child = node.getLeft();
        } else {
            child = node.getRight();
        }

        parent = node.getParent();

        if (child != null) {
            child.setParent(parent);
        }

        if (parent != null) {
            if (parent.getLeft() == node) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        } else {
            setRoot(child);
        }

        // 如果删除的是黑节点，需要修正
        if (node.isBlack()) {
            removeFixUp(child, parent);
        }
        node = null;
    }

    /**
     * 红黑树的修复
     *
     * @param node：待修复的节点
     * @param parent：待修复节点的父节点
     */
    private void removeFixUp(RBTreeNode<T> node, RBTreeNode<T> parent) {
        // 兄弟节点
        RBTreeNode<T> brother;
        // node不为空 是黑色 且 不是root
        while (node == null || node.isBlack() && node != this.root) {
            // node是父节点的左孩子
            if (node == parent.getLeft()) {
                brother = parent.getRight();
                // Case1：兄弟节点是红色
                // 兄弟变黑，父节点变红，父节点左旋
                // 将Case1 转换为Case2、3、4处理
                if (brother.isRed()) {
                    brother.setBlack();
                    parent.setRed();
                    leftRotate(parent);
                    brother = parent.getRight();
                }
                // Case2：node 的兄弟节点为黑色，且兄弟节点的两个孩子节点也是黑色 或 空
                // 兄弟节点变红，对父节点进行调整
                if ((brother.getLeft() == null || brother.getLeft().isBlack())
                        && (brother.getRight() == null || brother.getRight().isBlack())) {
                    brother.setRed();
                    node = parent;
                    parent = node.getParent();
                } else {
                    // Case3：node的兄弟节点为黑色，且兄弟节点的右黑，左红
                    // 兄弟的左孩子变黑 + 兄弟变红 + 兄弟右旋
                    if (brother.getRight() == null || brother.getRight().isBlack()) {
                        brother.getLeft().setBlack();
                        brother.setRed();
                        rightRotate(brother);
                        brother = node.getParent().getRight();
                    }
                    // Case4：兄弟为黑，且兄弟右孩子为红色
                    // 兄弟节点变为父节点的颜色 + 父节点变黑 + 兄弟右孩子变黑 + 父节点左旋
                    // 将node设置为根
                    brother.setIsRed(node.getParent().isRed());
                    node.getParent().setBlack();
                    brother.getRight().setBlack();
                    leftRotate(node.getParent());
                    node = root;
                    break;
                }
            } else {
                brother = parent.getLeft();
                // Case1：兄弟节点是红色
                if (brother.isRed()) {
                    brother.setBlack();
                    parent.setRed();
                    rightRotate(parent);
                    brother = parent.getLeft();
                }
                // Case2：node 的兄弟节点为黑色，且兄弟节点的两个孩子节点也是黑色 或 空
                if ((brother.getLeft() == null || brother.getLeft().isBlack())
                        && (brother.getRight() == null || brother.getRight().isBlack())) {
                    brother.setRed();
                    node = parent;
                    parent = node.getParent();
                } else {
                    // Case3：node的兄弟节点为黑色，且兄弟节点的右黑，左红
                    if (brother.getLeft() == null || brother.getLeft().isBlack()) {
                        brother.getRight().setBlack();
                        brother.setRed();
                        leftRotate(brother);
                        brother = node.getParent().getLeft();
                    }
                    // Case4：兄弟为黑，且兄弟右孩子为红色
                    brother.setIsRed(node.getParent().isRed());
                    node.getParent().setBlack();
                    brother.getLeft().setBlack();
                    rightRotate(node.getParent());
                    node = root;
                    break;
                }
            }
        }
        node.setBlack();
    }

    /**
     * 获取当前节点的兄弟节点
     *
     * @param node
     * @return
     */
    private RBTreeNode<T> getBrother(RBTreeNode<T> node, RBTreeNode<T> parent) {
        parent = node == null ? parent : node.getParent();
        if (node == null) {
            return parent.getLeft() == null ? parent.getRight() : parent.getLeft();
        }
        if (parent.getLeft() == node) {
            return parent.getRight();
        } else {
            return parent.getLeft();
        }
    }

    /**
     * 获取当前节点的后继节点
     *
     * @param node
     * @return
     */
    private RBTreeNode<T> getSuccessor(RBTreeNode<T> node) {
        RBTreeNode<T> child = node.getRight();
        while (child.getLeft() != null) {
            child = child.getLeft();
        }
        return child;
    }

    /**
     * 获取当前节点的叔叔节点
     *
     * @param node
     * @return
     */
    private RBTreeNode<T> getUncle(RBTreeNode<T> node) {
        // 父节点
        RBTreeNode<T> parent = node.getParent();
        // 祖父节点
        RBTreeNode<T> ancestor = parent.getParent();
        if (ancestor == null) {
            return null;
        }
        if (parent == ancestor.getLeft()) {
            return ancestor.getRight();
        } else {
            return ancestor.getLeft();
        }
    }

    /**
     * 找到新节点 插入位置 的父节点
     *
     * @param node
     * @return
     */
    private RBTreeNode<T> getInsertParent(RBTreeNode<T> node) {
        int cmp;
        RBTreeNode<T> parent = null;
        RBTreeNode<T> x = getRoot();
        while (x != null) {
            parent = x;
            cmp = node.getValue().compareTo(x.getValue());
            if (cmp < 0) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }
        return parent;
    }

    /**
     * 左旋
     * 注意每个节点 孩子节点 父节点 都需要修改，双向连接
     *
     * @param node
     */
    public void leftRotate(RBTreeNode<T> node) {
        RBTreeNode<T> rChild = node.getRight();
        RBTreeNode<T> parent = node.getParent();
        node.setRight(rChild.getLeft());
        if (rChild.getLeft() != null) {
            rChild.getLeft().setParent(node); //
        }

        // node为rChild的左孩子,rChild为node的父节点
        rChild.setLeft(node);
        node.setParent(rChild);

        // 设置rChild的parent节点为 node 的parent
        rChild.setParent(parent);

        // node为root
        if (parent == null) {
            setRoot(rChild);
        } else {
            // 初始node的父节点 连接 rChild
            if (parent.getLeft() == node) {
                parent.setLeft(rChild);
            } else {
                parent.setRight(rChild);
            }
        }
    }

    /**
     * 右旋
     * 与左旋镜像
     *
     * @param node
     */
    public void rightRotate(RBTreeNode<T> node) {
        RBTreeNode<T> lChild = node.getLeft();

        RBTreeNode<T> parent = node.getParent();
        node.setLeft(lChild.getRight());
        if (lChild.getRight() != null) {
            lChild.getRight().setParent(node); //
        }

        // node为rChild的左孩子
        lChild.setRight(node);
        node.setParent(lChild);

        // 设置rChild的parent节点为 node 的parent
        lChild.setParent(parent);

        // node是否为root
        if (parent == null) {
            setRoot(lChild);
        } else {
            if (parent.getRight() == node) {
                parent.setRight(lChild);
            } else {
                parent.setLeft(lChild);
            }
        }
    }

    /**
     * 当前节点的value[颜色 父节点的value  父节点的左孩子还是右孩子]
     *
     * @param root
     */
    public void printTree(RBTreeNode<T> root) {
        LinkedList<RBTreeNode<T>> queue = new LinkedList<RBTreeNode<T>>();
        LinkedList<RBTreeNode<T>> queue2 = new LinkedList<RBTreeNode<T>>();
        if (root == null) {
            return;
        }
        queue.add(root);
        boolean firstQueue = true;

        while (!queue.isEmpty() || !queue2.isEmpty()) {
            LinkedList<RBTreeNode<T>> q = firstQueue ? queue : queue2;
            RBTreeNode<T> n = q.poll();

            if (n != null) {
                String pos = n.getParent() == null ? "" : (n == n.getParent().getLeft()
                        ? " L" : " R");
                String pstr = n.getParent() == null ? "" : n.getParent().getValue().toString();
                String cstr = n.isRed() ? "Red" : "Black";
                cstr = n.getParent() == null ? cstr : cstr + " ";
                System.out.print(n.getValue() + "[" + (cstr) + pstr + (pos) + "]" + "\t");
                if (n.getLeft() != null) {
                    (firstQueue ? queue2 : queue).add(n.getLeft());
                }
                if (n.getRight() != null) {
                    (firstQueue ? queue2 : queue).add(n.getRight());
                }
            } else {
                System.out.println();
                firstQueue = !firstQueue;
            }
        }
        System.out.println();
    }
}

// 红黑树节点类
class RBTreeNode<T extends Comparable<T>> {
    // 节点的值
    private T value;
    // 节点的左孩子
    private RBTreeNode<T> left;
    // 节点的右孩子
    private RBTreeNode<T> right;
    // 节点的父节点
    private RBTreeNode<T> parent;
    // 节点的颜色 红色 true  黑色 false
    private boolean isRed;

    public RBTreeNode() {
    }

    public RBTreeNode(T value) {
        this.value = value;
    }

    public RBTreeNode(T value, boolean isRed) {
        this.value = value;
        this.isRed = isRed;
    }

    public T getValue() {
        return value;
    }

    void setValue(T value) {
        this.value = value;
    }

    RBTreeNode<T> getLeft() {
        return left;
    }

    void setLeft(RBTreeNode<T> left) {
        this.left = left;
    }

    RBTreeNode<T> getRight() {
        return right;
    }

    void setRight(RBTreeNode<T> right) {
        this.right = right;
    }

    RBTreeNode<T> getParent() {
        return parent;
    }

    void setParent(RBTreeNode<T> parent) {
        this.parent = parent;
    }

    boolean isRed() {
        return isRed;
    }

    boolean isBlack() {
        return !isRed;
    }

    /**
     * 判断是否为叶节点
     *
     * @return
     */
    boolean isLeaf() {
        return left == null && right == null;
    }

    void setIsRed(boolean isRed) {
        this.isRed = isRed;
    }

    void setRed() {
        this.isRed = true;
    }

    void setBlack() {
        this.isRed = false;
    }

}


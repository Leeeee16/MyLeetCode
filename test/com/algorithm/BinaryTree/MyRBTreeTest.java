package com.algorithm.BinaryTree;

import com.algorithm.RBTree.MyRBTree;
import org.junit.Test;

public class MyRBTreeTest {

    @Test
    public void test1() {
        MyRBTree<Integer> rbTree = new MyRBTree<>(null);
        rbTree.insert(1);
        rbTree.insert(5);
        rbTree.insert(6);
        rbTree.insert(7);
        rbTree.insert(8);
        rbTree.insert(9);
        rbTree.insert(10);
        rbTree.insert(11);
        rbTree.insert(12);
        rbTree.insert(13);
        rbTree.insert(14);
        rbTree.insert(15);
        rbTree.printTree(rbTree.getRoot());
        System.out.println("****************************");
        rbTree.remove(14);
        rbTree.remove(9);
        rbTree.remove(5);

        rbTree.printTree(rbTree.getRoot());
    }

    @Test
    public void test2() {
        MyRBTree<Integer> rbTree = new MyRBTree<>(null);
        rbTree.insert(41);
        rbTree.insert(38);
        rbTree.insert(31);
        rbTree.insert(12);
        rbTree.insert(19);
        rbTree.insert(8);
        rbTree.printTree(rbTree.getRoot());
    }
}
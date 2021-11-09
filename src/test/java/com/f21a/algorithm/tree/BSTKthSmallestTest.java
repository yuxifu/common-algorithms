package com.f21a.algorithm.tree;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BSTKthSmallestTest {
    @Test
    public void testBSTKthSmallest() {
        /*
        Example 1:
        Input: root = [3,1,4,null,2], k = 1
        Output: 1

        Example 2:
        Input: root = [5,3,6,2,4,null,null,1], k = 3
        Output: 3
        */

        // example 1
        BinarySearchTree tree1 = new BinarySearchTree();
        tree1.insert(3);
        tree1.insert(1);
        tree1.insert(4);
        tree1.insert(2);
        int kSmallest11 = new BSTKthSmallest().kthSmallest1(tree1.root, 1);
        int kSmallest12 = new BSTKthSmallest().kthSmallest2(tree1.root, 1);
        assertEquals(1, kSmallest11);
        assertEquals(1, kSmallest12);

        // example 2
        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.insert(5);
        tree2.insert(3);
        tree2.insert(6);
        tree2.insert(2);
        tree2.insert(4);
        tree2.insert(1);
        int kSmallest21 = new BSTKthSmallest().kthSmallest1(tree2.root, 3);
        int kSmallest22 = new BSTKthSmallest().kthSmallest2(tree2.root, 3);
        assertEquals(3, kSmallest21);
        assertEquals(3, kSmallest22);
    }
}

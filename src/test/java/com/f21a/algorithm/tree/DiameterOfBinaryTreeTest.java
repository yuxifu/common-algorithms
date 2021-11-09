package com.f21a.algorithm.tree;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DiameterOfBinaryTreeTest {
    @Test
    public void testDiameterOfBinaryTree() {
        BinaryTreeSerializer serializer = new BinaryTreeSerializer();

        // example 1
        TreeNode tree1 = serializer.deserializePreOrder("1,2,4,null,null,5,null,null,3,null,null");
        int diameter1 = new DiameterOfBinaryTree().diameterOfBinaryTree(tree1);
        assertEquals(3, diameter1);

        // example 2
        TreeNode tree2 = serializer.deserializePreOrder("1,2,null,null");
        int diameter2 = new DiameterOfBinaryTree().diameterOfBinaryTree(tree2);
        assertEquals(1, diameter2);
    }
}

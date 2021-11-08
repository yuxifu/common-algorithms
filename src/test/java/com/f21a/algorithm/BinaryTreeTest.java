package com.f21a.algorithm;

import com.f21a.algorithm.tree.BinaryTree;
import com.f21a.algorithm.tree.TreeNode;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class BinaryTreeTest {
    @Test
    public void testPreOrderTraversal() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.buildTree(nums);
        List<TreeNode> result = tree.preOrderTraversal(root);
        assertEquals("1,2,4,5,3,6,7", BinaryTree.nodeListToString(result));
    }

    @Test
    public void testInOrderTraversal() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.buildTree(nums);
        List<TreeNode> result = tree.inOrderTraversal(root);
        assertEquals("4,2,5,1,6,3,7", BinaryTree.nodeListToString(result));
    }

    @Test
    public void testPostOrderTraversal() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.buildTree(nums);
        List<TreeNode> result = tree.postOrderTraversal(root);
        assertEquals("4,5,2,6,7,3,1", BinaryTree.nodeListToString(result));
    }
}

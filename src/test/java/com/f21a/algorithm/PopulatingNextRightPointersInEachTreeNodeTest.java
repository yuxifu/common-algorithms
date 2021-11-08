package com.f21a.algorithm;

import com.f21a.algorithm.tree.BinaryTree;
import com.f21a.algorithm.tree.PopulatingNextRightPointersInEachNode;
import com.f21a.algorithm.tree.TreeNode;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class PopulatingNextRightPointersInEachTreeNodeTest {
    @Test
    public void testRightPointerTraversalTest1() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        PopulatingNextRightPointersInEachNode tree = new PopulatingNextRightPointersInEachNode();
        TreeNode root = tree.buildTree(nums);
        tree.connect(root);
        List<TreeNode> result = tree.rightPointerTraversal(root);
        assertEquals("1,#,2,3,#,4,5,6,7,#", BinaryTree.nodeListToString(result));
    }

    @Test
    public void testRightPointerTraversalTest2() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        PopulatingNextRightPointersInEachNode tree = new PopulatingNextRightPointersInEachNode();
        TreeNode root = tree.buildTree(nums);
        tree.connect2(root);
        List<TreeNode> result = tree.rightPointerTraversal(root);
        assertEquals("1,#,2,3,#,4,5,6,7,#", BinaryTree.nodeListToString(result));
    }
}

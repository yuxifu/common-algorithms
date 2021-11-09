package com.f21a.algorithm.tree;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LowestCommonAncestorTest {
    @Test
    public void testSerializer() {

        /*
        Example 1:
        Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
        Output: 6
        Explanation: The LCA of nodes 2 and 8 is 6.

        Example 2:

        Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
        Output: 2
        Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

        Example 3:
        Input: root = [2,1], p = 2, q = 1
        Output: 2
        */

        BinaryTreeSerializer serializer = new BinaryTreeSerializer();

        // example 1
        TreeNode example1 = serializer.deserializePreOrder(
                "6,2,0,null,null,4,3,null,null,5,null,null,8,7,null,null,9,null,null");
        TreeNode output11 = new LowestCommonAncestor().lowestCommonAncestor(example1,
                new TreeNode(2), new TreeNode(8));
        assertEquals(6, output11.val);

        TreeNode output12 = new LowestCommonAncestor().lowestCommonAncestor2(example1,
                new TreeNode(2), new TreeNode(8));
        assertEquals(6, output12.val);

        // example 2
        TreeNode example2 = serializer.deserializePreOrder(
                "6,2,0,null,null,4,3,null,null,5,null,null,8,7,null,null,9,null,null");
        TreeNode output21 = new LowestCommonAncestor().lowestCommonAncestor(example2,
                new TreeNode(2), new TreeNode(4));
        assertEquals(2, output21.val);

        TreeNode output122 = new LowestCommonAncestor().lowestCommonAncestor2(example2,
                new TreeNode(2), new TreeNode(4));
        assertEquals(2, output122.val);

        // example 3
        TreeNode example3 = serializer.deserializePreOrder("2,1,null,null,null");
        TreeNode output31 = new LowestCommonAncestor().lowestCommonAncestor(example3,
                new TreeNode(2), new TreeNode(1));
        assertEquals(2, output31.val);

        TreeNode output132 = new LowestCommonAncestor().lowestCommonAncestor2(example3,
                new TreeNode(2), new TreeNode(1));
        assertEquals(2, output132.val);

        //check if the serializer works correctly
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(6);
        tree.insert(2);
        tree.insert(8);
        tree.insert(0);
        tree.insert(4);
        tree.insert(7);
        tree.insert(9);
        tree.insert(3);
        tree.insert(5);
        String serialized = serializer.serializePreOrder(tree.root);
        assertEquals("6,2,0,null,null,4,3,null,null,5,null,null,8,7,null,null,9,null,null,", serialized);
    }
}

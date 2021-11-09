package com.f21a.algorithm.tree;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class BinaryTreeSerializerTest {
    @Test
    public void testSerializer() {

        BinarySearchTree tree = new BinarySearchTree();
        /* create following BST
                  50
               /     \
              30      70
                \    /
                40  60  */
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(40);
        tree.insert(60);

        // inorder traversal
        List<TreeNode> nodes1 = new BinaryTree().preOrderTraversal(tree.root);
        String preOrderResult1 = BinaryTree.nodeListToString(nodes1);

        // serialize
        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        String serialized = serializer.serializePreOrder(tree.root);
        assertEquals("50,30,null,40,null,null,70,60,null,null,null,", serialized);

        // de-serialize
        TreeNode deserialized = serializer.deserializePreOrder(serialized);
        List<TreeNode> nodes2 = new BinaryTree().preOrderTraversal(deserialized);
        String preOrderResult2 = BinaryTree.nodeListToString(nodes2);

        assertEquals(preOrderResult1, preOrderResult2);
    }
}

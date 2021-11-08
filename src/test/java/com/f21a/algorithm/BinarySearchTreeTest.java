package com.f21a.algorithm;

import com.f21a.algorithm.tree.BinarySearchTree;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class BinarySearchTreeTest {
    @Test
    public void testPreOrderTraversal() {

        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST
                  50
               /     \
              30      70
             /  \    /  \
           20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // print inorder traversal of the BST
        List<Integer> result = tree.inOrderRec();
        assertEquals(Arrays.asList(20, 30, 40, 50, 60, 70, 80), result);
    }
}

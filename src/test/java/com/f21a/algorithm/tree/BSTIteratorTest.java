package com.f21a.algorithm.tree;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.*;

public class BSTIteratorTest {
    @Test
    public void testBSTIterator() {

        BinarySearchTree tree = new BinarySearchTree();
        /* Let us create following BST
                 7
               /  \
              3    15
                  /  \
                 9   20 */
        tree.insert(3);
        tree.insert(7);
        tree.insert(15);
        tree.insert(9);
        tree.insert(20);

        // print inorder traversal of the BST
        List<Integer> result = tree.inOrderRec();
        assertEquals(Arrays.asList(3, 7, 9, 15, 20), result);

        // test
        BSTIterator iterator = new BSTIterator(tree.root);

        int val3 = iterator.next();    // return 3
        assertEquals(3, val3);

        int val7 = iterator.next();    // return 7
        assertEquals(7, val7);

        boolean moreAfter7 = iterator.hasNext(); // return True
        assertTrue(moreAfter7);

        int val9 = iterator.next();    // return 9
        assertEquals(9, val9);

        boolean moreAfter9 = iterator.hasNext(); // return True
        assertTrue(moreAfter9);

        int val15 = iterator.next();    // return 15
        assertEquals(15, val15);

        boolean moreAfter15 = iterator.hasNext(); // return True
        assertTrue(moreAfter15);

        int val20 = iterator.next();    // return 20
        assertEquals(20, val20);

        boolean moreAfter20 = iterator.hasNext(); // return False
        assertFalse(moreAfter20);
    }
}

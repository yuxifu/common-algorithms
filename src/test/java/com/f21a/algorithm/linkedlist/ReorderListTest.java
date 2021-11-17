package com.f21a.algorithm.linkedlist;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class ReorderListTest {
    /*
    Example 1:
    Input: head = [1,2,3,4]
    Output: [1,4,2,3]

    Example 2:
    Input: head = [1,2,3,4,5]
    Output: [1,5,2,4,3]
     */
    @Test
    public void testMergeKSortedListExamples() {
        ListNode l1 = ListNode.buildLinkedList(new int[]{1, 2, 3, 4});
        new ReorderList().reorderList(l1);
        assertEquals(Arrays.asList(1, 4, 2, 3), ListNode.printLinkedList(l1));

        ListNode l2 = ListNode.buildLinkedList(new int[]{1, 2, 3, 4, 5});
        new ReorderList().reorderList(l2);
        assertEquals(Arrays.asList(1, 5, 2, 4, 3), ListNode.printLinkedList(l2));
    }
}

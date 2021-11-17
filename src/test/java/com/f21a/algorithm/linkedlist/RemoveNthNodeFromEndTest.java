package com.f21a.algorithm.linkedlist;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class RemoveNthNodeFromEndTest {

    /*
    Example 1:
    Input: head = [1,2,3,4,5], n = 2
    Output: [1,2,3,5]

    Example 2:
    Input: head = [1], n = 1
    Output: []

    Example 3:
    Input: head = [1,2], n = 1
    Output: [1]
     */
    @Test
    public void testMergeKSortedListExamples() {
        ListNode l1 = ListNode.buildLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode result1 = new RemoveNthNodeFromEnd().removeNthFromEnd(l1, 2);
        assertEquals(Arrays.asList(1, 2, 3, 5), ListNode.printLinkedList(result1));

        ListNode l2 = ListNode.buildLinkedList(new int[]{1});
        ListNode result2 = new RemoveNthNodeFromEnd().removeNthFromEnd(l2, 1);
        assertEquals(Arrays.asList(), ListNode.printLinkedList(result2));

        ListNode l3 = ListNode.buildLinkedList(new int[]{1, 2});
        ListNode result3 = new RemoveNthNodeFromEnd().removeNthFromEnd(l3, 1);
        assertEquals(Arrays.asList(1), ListNode.printLinkedList(result3));
    }
}

package com.f21a.algorithm.priorityqueue;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static junit.framework.TestCase.assertEquals;

public class MergeKSortedListsTest {
    /*
    Example 1:
    Input: lists = [[1,4,5],[1,3,4],[2,6]]
    Output: [1,1,2,3,4,4,5,6]
    Explanation: The linked-lists are:
    [
      1->4->5,
      1->3->4,
      2->6
    ]
    merging them into one sorted list:
    1->1->2->3->4->4->5->6

    Example 2:
    Input: lists = []
    Output: []

    Example 3:
    Input: lists = [[]]
    Output: []]
     */
    @Test
    public void testMergeKSortedListsExample1() {
        ListNode l1 = ListNode.buildLinkedList(new int[]{1, 4, 5});
        ListNode l2 = ListNode.buildLinkedList(new int[]{1, 3, 4});
        ListNode l3 = ListNode.buildLinkedList(new int[]{2, 6});
        ListNode merged = new MergeKSortedLists().mergeKLists(new ListNode[]{l1, l2, l3});
        assertEquals(Arrays.asList(1, 1, 2, 3, 4, 4, 5, 6), ListNode.printLinkedList(merged));
    }

    @Test
    public void testMergeKSortedListsExample2() {
        ListNode merged = new MergeKSortedLists().mergeKLists(new ListNode[]{});
        assertEquals(Collections.emptyList(), ListNode.printLinkedList(merged));
    }

    @Test
    public void testMergeKSortedListsExample3() {
        ListNode l1 = ListNode.buildLinkedList(new int[]{});
        ListNode merged = new MergeKSortedLists().mergeKLists(new ListNode[]{l1});
        assertEquals(Collections.emptyList(), ListNode.printLinkedList(merged));
    }
}

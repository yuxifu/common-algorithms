package com.f21a.algorithm.linkedlist;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LinkedListCycleTest {
    /*
    Example 1:
    Input: head = [3,2,0,-4], pos = 1
    Output: true
    Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

    Example 2:
    Input: head = [1,2], pos = 0
    Output: true
    Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

    Example 3:
    Input: head = [1], pos = -1
    Output: false
    Explanation: There is no cycle in the linked list.
     */
    @Test
    public void testLinkedListCycleExamples() {
        ListNode l1 = ListNode.buildLinkedList(new int[]{3, 2, 0, -4});
        ListNode.linkTailTo(l1, 2);
        assertEquals(true, new LinkedListCycle().hasCycle(l1));

        ListNode l2 = ListNode.buildLinkedList(new int[]{1, 2});
        ListNode.linkTailTo(l2, 1);
        assertEquals(true, new LinkedListCycle().hasCycle(l2));

        ListNode l3 = ListNode.buildLinkedList(new int[]{1});
        ListNode.linkTailTo(l3, -1);
        assertEquals(false, new LinkedListCycle().hasCycle(l3));
    }
}

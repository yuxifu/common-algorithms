package com.f21a.algorithm.linkedlist;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class ReverseLinkedListTest {
    @Test
    public void testMergeKSortedListExamples() {
        ListNode l1 = ListNode.buildLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode reversed1 = new ReverseLinkedList().reverseList(l1);
        assertEquals(Arrays.asList(5, 4, 3, 2, 1), ListNode.printLinkedList(reversed1));

        ListNode l2 = ListNode.buildLinkedList(new int[]{1, 2});
        ListNode reversed2 = new ReverseLinkedList().reverseList(l2);
        assertEquals(Arrays.asList(2, 1), ListNode.printLinkedList(reversed2));

        ListNode l3 = ListNode.buildLinkedList(new int[]{});
        ListNode reversed3 = new ReverseLinkedList().reverseList(l3);
        assertEquals(Arrays.asList(), ListNode.printLinkedList(reversed3));
    }

    @Test
    public void testMergeKSortedList2Examples() {
        ListNode l1 = ListNode.buildLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode reversed1 = new ReverseLinkedList().reverseList2(l1);
        assertEquals(Arrays.asList(5, 4, 3, 2, 1), ListNode.printLinkedList(reversed1));

        ListNode l2 = ListNode.buildLinkedList(new int[]{1, 2});
        ListNode reversed2 = new ReverseLinkedList().reverseList2(l2);
        assertEquals(Arrays.asList(2, 1), ListNode.printLinkedList(reversed2));

        ListNode l3 = ListNode.buildLinkedList(new int[]{});
        ListNode reversed3 = new ReverseLinkedList().reverseList2(l3);
        assertEquals(Arrays.asList(), ListNode.printLinkedList(reversed3));
    }
}

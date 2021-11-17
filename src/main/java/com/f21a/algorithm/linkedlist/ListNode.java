package com.f21a.algorithm.linkedlist;

import java.util.ArrayList;
import java.util.List;

// Definition for singly-linked list.
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode buildLinkedList(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode[] nodes = new ListNode[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            ListNode next = i == nums.length - 1 ? null : nodes[i + 1];
            nodes[i] = new ListNode(nums[i], next);
        }
        return nodes[0];
    }

    public static List<Integer> printLinkedList(ListNode head) {
        List<Integer> numList = new ArrayList<>();
        if (head == null) return numList;
        ListNode cur = head;
        while (cur != null) {
            numList.add(cur.val);
            cur = cur.next;
        }
        return numList;
    }

    public static void linkTailTo(ListNode head, int target) {
        // assume no cycle in the list
        ListNode targetNode = null;
        while (head != null) {
            if (head.val == target) {
                targetNode = head;
            }
            if (head.next == null) {
                head.next = targetNode;
                return;
            }
            head = head.next;
        }
    }
}

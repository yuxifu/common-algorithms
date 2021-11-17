package com.f21a.algorithm.priorityqueue;

import com.f21a.algorithm.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/* You are given an array of k linked-lists lists, each linked-list is sorted in
ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

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
Output: []

Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.

 */
public class MergeKSortedLists {

    /*
    Initially when the PQ is created, only first elements of each list is added to PQ, and not the entire
    linked list.

    Consider the following example:
    [
    1->4->5,
    1->3->4,
    2->6
    ]
    Here , the PQ will have 1,1,2 initially. And each while loop will remove 1 element from the queue using

    tail.next=queue.poll();
    tail=tail.next;

    However, the key point here is the node returned by queue.poll() will still have link to its next node.
    i.e queue.poll() will return 1 from the PQ and 1 still has a link to next element to 4 in list 1 .
    Then the below statements will add 4 to priority queue

    if (tail.next!=null)
    queue.add(tail.next);
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists)
            if (node != null)
                queue.add(node);

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

    //
    public ListNode mergeKLists2(ListNode[] lists) {
        // corner case
        if(lists == null || lists.length == 0) return null;

        ListNode head = merge(lists, 0, lists.length - 1);
        return head;
    }

    // return new head after merging list[left : right]
    public ListNode merge(ListNode[] lists, int left, int right){
        // base case
        if(left == right) return lists[left];

        int mid = left + (right - left)/2;
        ListNode l1 = merge(lists, left, mid); // merge [left : mid]
        ListNode l2 = merge(lists, mid + 1, right); // merge [mid + 1 : right]

        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while(cur1 != null || cur2 != null){
            if(cur1 == null){
                cur.next = cur2;
                break;
            }else if(cur2 == null){
                cur.next = cur1;
                break;
            }else{
                if(cur1.val <= cur2.val){
                    cur.next = cur1;
                    cur1 = cur1.next;
                }else{
                    cur.next = cur2;
                    cur2 = cur2.next;
                }
                cur = cur.next;
            }

        }

        return dummy.next;
    }
}

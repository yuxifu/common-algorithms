package com.f21a.algorithm.linkedlist;

/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz

Follow up: Could you do this in one pass?
 */
public class RemoveNthNodeFromEnd {

    /*
    A one pass solution can be done using pointers. Move one pointer fast --> n+1 places forward,
    to maintain a gap of n between the two pointers and then move both at the same speed.
    Finally, when the fast pointer reaches the end, the slow pointer will be n+1 places behind -
    just the right spot for it to be able to skip the next node.

    Since the question gives that n is valid, not too many checks have to be put in place.
    Otherwise, this would be necessary.
    */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        start.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
}

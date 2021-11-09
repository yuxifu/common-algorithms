package com.f21a.algorithm.tree;

/*
Given the root of a binary search tree, and an integer k, return the kth smallest
value (1-indexed) of all the values of the nodes in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

Constraints:
The number of nodes in the tree is n.
1 <= k <= n <= 10^4
0 <= Node.val <= 10^4

Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and
you need to find the kth smallest frequently, how would you optimize?
 */

import java.util.Stack;

public class BSTKthSmallest {
    public int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();

        while (root != null) {
            st.push(root);
            root = root.left;
        }

        while (k != 0) {
            TreeNode n = st.pop();
            k--;
            if (k == 0) return n.val;
            TreeNode right = n.right;
            while (right != null) {
                st.push(right);
                right = right.left;
            }
        }

        return -1; // never hit if k is valid
    }

    int count;
    int result;

    public int kthSmallest2(TreeNode root, int k) {
        count = 0;
        result = Integer.MIN_VALUE;
        traverse(root, k);
        return result;
    }

    public void traverse(TreeNode root, int k) {
        if (root == null) return;
        traverse(root.left, k);
        count++;
        if (count == k) result = root.val;
        traverse(root.right, k);
    }
}

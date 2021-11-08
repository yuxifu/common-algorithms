package com.f21a.algorithm.tree;

/*
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer
should be set to NULL.

Initially, all next pointers are set to NULL.

Example 1:
Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next
pointer to point to its next right node, just like in Figure B. The serialized output is in level order
as connected by the next pointers, with '#' signifying the end of each level.

Example 2:
Input: root = []
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 2^12 - 1].
-1000 <= Node.val <= 1000

Follow-up:
You may only use constant extra space.
The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.
 */

import java.util.ArrayList;
import java.util.List;

public class PopulatingNextRightPointersInEachNode extends BinaryTree {

    /**
     * Approach: Tree
     * Firstly, I think about levelOrder-Traversal, so I need use a queue to solve this problem like Binary
     * Tree Level Order Traversal, but it's too complicated for this question when I start to write this code.
     * There no need for me to use queue for this question apparently.
     * And when I draw the tree, I find that it question is very easy to solve, due to the relationship between
     * each node. So, if you want to solve this problem quickly and easily, plz draw it!
     * You will find we only need a node levelStart to track the head position of each level
     * and a node curr to track the current node when we traverse the level.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public void connect(TreeNode root) {
        TreeNode levelStart = root;
        while (levelStart != null) {
            TreeNode curr = levelStart;
            while (curr != null) {
                if (curr.left != null) {
                    curr.left.next = curr.right;
                }
                if (curr.right != null && curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                // move the current node to the next position
                curr = curr.next;
            }
            // move the levelStart node the next level's head position
            levelStart = levelStart.left;
        }
    }

    /* Use recursion */
    public TreeNode connect2(TreeNode root) {
        if (root != null) {
            connectHelper(root.left, root.right);
        }
        return root;
    }

    private void connectHelper(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null || treeNode2 == null) {
            return;
        }
        treeNode1.next = treeNode2;
        connectHelper(treeNode1.left, treeNode1.right);
        connectHelper(treeNode1.right, treeNode2.left);
        connectHelper(treeNode2.left, treeNode2.right);
    }

    public List<TreeNode> rightPointerTraversal(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        TreeNode levelStart = root;
        while (levelStart != null) {
            TreeNode curr = levelStart;
            while (curr != null) {
                result.add(curr);
                curr = curr.next;
            }
            // mark the end of the level
            result.add(null);
            // move the levelStart node the next level's head position
            levelStart = levelStart.left;
        }
        return result;
    }
}


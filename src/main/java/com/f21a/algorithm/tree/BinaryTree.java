package com.f21a.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
https://en.wikipedia.org/wiki/Binary_tree#Types_of_binary_trees

A full binary tree is a tree in which every node has either 0 or 2 children.

In a complete binary tree every level, except possibly the last, is completely filled,
and all nodes in the last level are as far left as possible.

A balanced binary tree is a binary tree structure in which the left and right subtrees
of every node differ in height by no more than 1.

A perfect binary tree is a tree with all leaves are at the same level, and every parent has two children.
 */
public class BinaryTree {

    // build a balanced complete tree
    public TreeNode buildTree(int[] nums) {
        int length = nums.length;
        TreeNode[] treeNodes = new TreeNode[length];
        for (int i = 0; i < nums.length; i++) {
            treeNodes[i] = new TreeNode(nums[i]);
        }
        for (int i = 0; i < length; i++) {
            TreeNode left = i * 2 + 1 < length ? treeNodes[i * 2 + 1] : null;
            TreeNode right = i * 2 + 2 < length ? treeNodes[i * 2 + 2] : null;
            treeNodes[i].left = left;
            treeNodes[i].right = right;
        }
        return treeNodes[0];
    }

    public List<TreeNode> preOrderTraversal(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        recursivePreOrderTraversal(root, result);
        return result;
    }

    private void recursivePreOrderTraversal(TreeNode root, List<TreeNode> result) {
        if (root != null) {
            result.add(root);
            recursivePreOrderTraversal(root.left, result);
            recursivePreOrderTraversal(root.right, result);
        }
    }

    public List<TreeNode> inOrderTraversal(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        recursiveInOrderTraversal(root, result);
        return result;
    }

    private void recursiveInOrderTraversal(TreeNode root, List<TreeNode> result) {
        if (root != null) {
            recursiveInOrderTraversal(root.left, result);
            result.add(root);
            recursiveInOrderTraversal(root.right, result);
        }
    }

    public List<TreeNode> postOrderTraversal(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        recursivePostOrderTraversal(root, result);
        return result;
    }

    private void recursivePostOrderTraversal(TreeNode root, List<TreeNode> result) {
        if (root != null) {
            recursivePostOrderTraversal(root.left, result);
            recursivePostOrderTraversal(root.right, result);
            result.add(root);
        }
    }

    public static String nodeListToString(List<TreeNode> nodes) {
        return nodes.stream()
                .map(i -> i == null ? "#" : String.valueOf(i.val))
                .collect(Collectors.joining(","));
    }
}

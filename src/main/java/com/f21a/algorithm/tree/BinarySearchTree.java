package com.f21a.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/*
Binary Search Tree is a node-based binary tree data structure which has the following properties:
1. The left subtree of a node contains only nodes with keys lesser than the node’s key.
2. The right subtree of a node contains only nodes with keys greater than the node’s key.
3. The left and right subtree each must also be a binary search tree.
4. There must be no duplicate nodes.
 */
public class BinarySearchTree {

    // root of BST
    public TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    // insert
    public void insert(int key) {
        root = insertRec(root, key);
    }

    /* recursively insert a new key in BST */
    private TreeNode insertRec(TreeNode root, int key) {
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.val)
            root.left = insertRec(root.left, key);
        else if (key > root.val)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    public List<Integer> inOrderRec() {
        List<Integer> result = new ArrayList<>();
        inOrderRec(root, result);
        return result;
    }

    private void inOrderRec(TreeNode root, List<Integer> result) {
        if (root != null) {
            inOrderRec(root.left, result);
            result.add(root.val);
            inOrderRec(root.right, result);
        }
    }

    // test
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // print inorder traversal of the BST
        System.out.println(tree.inOrderRec());
    }
}

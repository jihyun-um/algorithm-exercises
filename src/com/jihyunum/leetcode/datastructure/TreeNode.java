package com.jihyunum.leetcode.datastructure;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public void printPreOrder(TreeNode node) {
        System.out.println(node.val);
        if (node.left != null) {
            printPreOrder(node.left);
        }
        if (node.right != null) {
            printPreOrder(node.right);
        }
    }

    public void printInOrder(TreeNode node) {
        if (node.left != null) {
            printInOrder(node.left);
        }
        System.out.println(node.val);
        if (node.right != null) {
            printInOrder(node.right);
        }
    }

    public void printPostOrder(TreeNode node) {
        if (node.left != null) {
            printPostOrder(node.left);
        }
        if (node.right != null) {
            printPostOrder(node.right);
        }
        System.out.println(node.val);
    }
}

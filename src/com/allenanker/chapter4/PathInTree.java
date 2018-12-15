package com.allenanker.chapter4;

import java.util.Iterator;
import java.util.Stack;

public class PathInTree {
    /**
     * Print paths in binary tree, whose node values sum is equal to sum.
     * The paths must start from the root of the binary tree, end at the leafs.
     *
     * @param head
     * @param expectedSum
     */
    public static void printPath(TreeNode<Integer> head, int expectedSum) {
        if (head == null) {
            throw new IllegalArgumentException("Invalid parameter head");
        }

        printPath(head, expectedSum, new Stack<>(), 0);
    }

    private static void printPath(TreeNode<Integer> currNode, int expectedSum, Stack<TreeNode<Integer>> path,
                                  int currSum) {
        boolean isLeaf = currNode.left == null && currNode.right == null;
        currSum += currNode.val;
        path.push(currNode);
        if (!isLeaf) {
            if (currNode.left != null) {
                printPath(currNode.left, expectedSum, path, currSum);
            }
            if (currNode.right != null) {
                printPath(currNode.right, expectedSum, path, currSum);
            }
        } else {
            if (currSum == expectedSum) {
                printPathString(path);
            }
        }
        path.pop();
    }

    private static void printPathString(Stack<TreeNode<Integer>> path) {
        for (TreeNode<Integer> integerTreeNode : path) {
            System.out.print(integerTreeNode.val + "->");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode<Integer> head = new TreeNode<>(10);
        head.left = new TreeNode<>(5);
        head.right = new TreeNode<>(12);
        head.left.left = new TreeNode<>(4);
        head.left.right = new TreeNode<>(7);
        printPath(head, 22);
    }
}

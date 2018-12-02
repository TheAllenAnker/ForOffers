package com.allenanker.niuke_advanced_lesson;

import javax.xml.soap.Node;

public class LargestBST {
    /**
     * Return the max size of BST in the given binary tree.
     *
     * @param head the binary tree's head node
     * @return the max size of BST
     */
    public static int maxBSTSize(TreeNode head) {
        if (head == null) {
            return 0;
        }

        return process(head).size;
    }

    private static ReturnInfo process(TreeNode node) {
        if (node == null) {
            return new ReturnInfo(0, null, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        TreeNode left = node.left;
        TreeNode right = node.right;
        ReturnInfo leftInfo = process(left);
        ReturnInfo rightInfo = process(right);
        if (leftInfo.head == left && rightInfo.head == right
                && leftInfo.max < node.val && rightInfo.min > node.val) {
            return new ReturnInfo(leftInfo.size + rightInfo.size + 1, node, rightInfo.max, leftInfo.min);
        } else {
            // see which sub-tree will be returned and build the new return info
            TreeNode maxHead = leftInfo.size > rightInfo.size ? leftInfo.head : rightInfo.head;
            ReturnInfo returnInfo = leftInfo.size > rightInfo.size ? leftInfo : rightInfo;
            return new ReturnInfo(Math.max(leftInfo.size, rightInfo.size), maxHead, returnInfo.max, returnInfo.min);
        }
    }
}

class ReturnInfo {
    int size;
    TreeNode head;
    int max;
    int min;

    public ReturnInfo(int size, TreeNode head, int max, int min) {
        this.size = size;
        this.head = head;
        this.max = max;
        this.min = min;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

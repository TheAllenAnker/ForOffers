package com.allenanker.chapter6;

import com.allenanker.chapter4.TreeUtil;

public class KthNodeInBST {
    private int k;
    /**
     * Find the kth smallest node in a given binary search tree.
     *
     * @param root
     * @param k
     * @return
     */
    public TreeNode getKthNodeInBST(TreeNode root, int k) {
        this.k = k;
        if (root == null || k < 1) {
            throw new IllegalArgumentException("Invalid argument(s)");
        }

       return getKthNodeCore(root);
    }

    private TreeNode getKthNodeCore(TreeNode root) {
        TreeNode target = null;
        if (root.left != null) {
            target = getKthNodeCore(root.left);
        }
        if (target == null) {
            if (k == 1) {
                target = root;
            }
            k--;
        }
        if (target == null && root.right != null) {
            target = getKthNodeCore(root.right);
        }

        return target;
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("Invalid parameter");
        }

        if (root.left != null) {
            inOrderTraversal(root.left);
        }
        System.out.print(root.val + "->");
        if (root.right != null) {
            inOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.getSimpleBinaryTree();
        System.out.println(new KthNodeInBST().getKthNodeInBST(root, 4).val);
        new KthNodeInBST().inOrderTraversal(root);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

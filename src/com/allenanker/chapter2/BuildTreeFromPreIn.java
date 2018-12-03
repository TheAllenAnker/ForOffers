package com.allenanker.chapter2;

public class BuildTreeFromPreIn {
    /**
     * Given a tree's pre-order and in-order traversal, return the tree.
     *
     * @param preStr the string in pre-order
     * @param inStr  the string in in-order
     * @return the original tree structure's head
     */
    public static TreeNode buildTree(String preStr, String inStr) {
        if (preStr == null || inStr == null || preStr.length() == 0 || inStr.length() == 0) {
            return null;
        }

        return buildHelper(preStr.toCharArray(), 0, preStr.length() - 1,
                inStr.toCharArray(), 0, inStr.length() - 1);
    }

    private static TreeNode buildHelper(char[] preStr, int preStart, int preEnd, char[] inStr, int inStart, int inEnd) {
        int rootValue = Integer.parseInt(preStr[preStart] + "");
        TreeNode root = new TreeNode(rootValue);
        // if it reaches the end
        if (preStart == preEnd) {
            return root;
        }

        int inPos = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (rootValue == Integer.parseInt(inStr[i] + "")) {
                inPos = i;
                break;
            }
        }

        int leftLength = inPos - inStart;
        int nextPreEnd = preStart + leftLength;
        if (leftLength > 0) {
            root.left = buildHelper(preStr, preStart + 1, nextPreEnd,
                    inStr, inStart, inPos - 1);
        }
        if (leftLength < preEnd - preStart) {
            root.right = buildHelper(preStr, nextPreEnd + 1, preEnd,
                    inStr, inPos + 1, inEnd);
        }

        return root;
    }

    public static void main(String[] args) {
        String preStr = "12473568";
        String inStr = "47215386";
        TreeNode head = buildTree(preStr, inStr);
        System.out.println();
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

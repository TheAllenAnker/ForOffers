package com.allenanker.niuke_advanced_lesson;

public class MaxXORGroup {
    /**
     * Does the same as the blow one, but with O(n) time complexity.
     * Use Trie data structure
     *
     * @param arr
     * @return
     */
    public static int maxXORInArrBetter(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }

        int max = Integer.MIN_VALUE;
        int xor = 0;
        Trie trie = new Trie();
        trie.add(0);
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
            max = Math.max(trie.maxXor(xor), max);
            trie.add(xor);
        }

        return max;
    }

    /**
     * Return the max xor sum in arr's sub-arrays.
     * With O(n^2) time complexity
     *
     * @param arr
     * @return
     */
    public static int maxXORInArr(int[] arr) {
        int max = Integer.MIN_VALUE;
        int xor = 0;
        // dp array stores the previous xor sum
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            // xor is xor sum from 0 to i
            xor ^= arr[i];
            max = Math.max(xor, max);
            for (int j = 1; j <= i; j++) {
                // jToIXor is the xor sum from j to i
                int jToIXor = xor ^ dp[j - 1];
                max = Math.max(jToIXor, max);
            }
            dp[i] = xor;
        }

        return max;
    }

    public static void main(String[] args) {

    }
}

class TrieNode {
    TrieNode[] nexts = new TrieNode[2];
}

class Trie {
    TrieNode head = new TrieNode();

    // add the given number(in binary) into the trie
    public void add(int num) {
        TrieNode curr = head;
        for (int steps = 31; steps >= 0; steps--) {
            int path = (num >> steps) & 1;
            if (curr.nexts[path] == null) {
                curr.nexts[path] = new TrieNode();
            }
            curr = curr.nexts[path];
        }
    }

    /**
     * Return the max xor sum ends with num, num is the last number in the sequence used for xor sum calculation
     *
     * @param num
     * @return
     */
    public int maxXor(int num) {
        int res = 0;
        TrieNode curr = head;
        for (int steps = 31; steps >= 0; steps--) {
            int currBit = (num >> steps) & 1;
            // the result is the biggest if the sign bit is 0 and the other bits are 1
            int bestFit = steps == 31 ? currBit : currBit ^ 1;
            // but the trie may not have the best fit bit, if so, we choose the other bit
            int actualFit = curr.nexts[bestFit] == null ? bestFit ^ 1 : bestFit;
            res |= (currBit ^ actualFit) << steps;
            curr = curr.nexts[actualFit];
        }

        return res;
    }
}

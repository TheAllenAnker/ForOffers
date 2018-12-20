package com.allenanker.chapter4;

import java.util.Arrays;

import static com.allenanker.chapter4.ArraysUtil.partition;

public class KSmallestNumber {
    public static int[] getKSmallest(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            throw new IllegalArgumentException("Invalid parameter(s)");
        }

        int start = 0, end = nums.length - 1;
        int i = partition(nums, start, end);
        while (i != k) {
            if (i < k) {
                start = i + 1;
                i = partition(nums, start, end);
            } else {
                end = i - 1;
                i = partition(nums, start, end);
            }
        }

        int[] result = new int[k];
        System.arraycopy(nums, 0, result, 0, k);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(Arrays.toString(getKSmallest(nums, 4)));
    }
}

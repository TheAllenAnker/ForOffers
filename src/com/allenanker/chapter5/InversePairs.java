package com.allenanker.chapter5;

import java.util.Arrays;

public class InversePairs {
    public static int getInversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid parameter");
        }

        int[] copy = Arrays.copyOf(nums, nums.length);
        int res = inversePairsCore(nums, copy, 0, nums.length - 1);
        // copy will be the sorted array
        System.out.println(Arrays.toString(copy));

        return res;
    }

    private static int inversePairsCore(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }

        int length = (end - start) / 2;
        int left = inversePairsCore(copy, data, start, start + length);
        int right = inversePairsCore(copy, data, start + length + 1, end);

        int count = 0;
        int i = start + length, j = end;
        int copyIndex = end;
        while (i >= start && j >= start + length + 1) {
            if (data[i] > data[j]) {
                copy[copyIndex--] = data[i--];
                count += j - start - length;
            } else {
                copy[copyIndex--] = data[j--];
            }
        }
        while (i >= start) {
            copy[copyIndex--] = data[i--];
        }
        while (j >= start + length + 1) {
            copy[copyIndex--] = data[j--];
        }

        return left + right + count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 5, 6, 4};
        System.out.println(getInversePairs(nums));
    }
}

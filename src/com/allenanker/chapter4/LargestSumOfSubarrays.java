package com.allenanker.chapter4;

public class LargestSumOfSubarrays {
    public static int largestSumOfSubarrays(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid parameter arr");
        }
        int res = arr[0];
        int max = res;
        for (int i = 1; i < arr.length; i++) {
            if (res <= 0) {
                res = arr[i];
            } else {
                res += arr[i];
            }
            max = Math.max(max, res);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(largestSumOfSubarrays(arr));
    }
}

package com.allenanker.chapter6;

import java.util.Arrays;

public class ConstructArray {
    public int[] getProductArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        int length = arr.length;
        int[] res = new int[length];
        int[] helperArr = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = 1;
            helperArr[i] = 1;
        }
        for (int i = 1; i < length; i++) {
            res[i] *= res[i - 1] * arr[i - 1];
        }
        for (int i = length - 2; i >= 0; i--) {
            helperArr[i] *= helperArr[i + 1] * arr[i + 1];
        }
        for (int i = 0; i < length; i++) {
            res[i] *= helperArr[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(new ConstructArray().getProductArray(nums)));
    }
}

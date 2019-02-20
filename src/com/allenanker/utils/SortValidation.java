package com.allenanker.utils;

import java.util.Arrays;

public class SortValidation {
    public static int[] generateRandomArray(int size, int value) {
        if (size < 1) {
            return null;
        }

        int[] res = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < res.length; i++) {
            res[i] = (int) ((value + 1) * Math.random()) - (int) ((size + 1) * Math.random());
        }

        return res;
    }

    public static boolean isTwoArrsEquivalent(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1 == null || arr2 == null) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateRandomArray(9, 10)));
    }
}

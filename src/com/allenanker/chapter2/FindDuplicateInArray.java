package com.allenanker.chapter2;

public class FindDuplicateInArray {
    /**
     * Find one of the duplicates in the arr if it exists, or return Integer.MAX_VALUE.
     * The array has length n, and values in the array are between 0 and n-1.
     *
     * @param arr the given array
     * @return the duplicate if exists, or return Integer.MAX when there are no duplicate or the input is wrong.
     */
    public static int findDuplicate(int[] arr) {
        if (arr == null || arr.length == 1) {
            return Integer.MAX_VALUE;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] > arr.length - 1) {
                return Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            while (curr != i) {
                if (arr[curr] == curr) {
                    return curr;
                }
                arr[i] = arr[curr];
                arr[curr] = curr;
                curr = arr[i];
            }
        }

        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findDuplicate(arr));
    }
}

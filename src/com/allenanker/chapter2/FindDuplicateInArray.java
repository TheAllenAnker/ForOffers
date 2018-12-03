package com.allenanker.chapter2;

public class FindDuplicateInArray {
    /**
     * The same as the below problem, only that the array can't be modified.
     * The array may not have duplicates.
     *
     * @param arr the given array
     */
    public static int findDuplicate2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        // the arr values vary from 1 to arr.length
        int start = 1, end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            int count = countRange(arr, start, mid);
            if (start == end) {
                // if the count is not bigger than 1, the the array has no duplicate
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            // if the number smaller or equal to mid is too big
            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    private static int countRange(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= end && arr[i] >= start) {
                count++;
            }
        }

        return count;
    }

    /**
     * Find one of the duplicates in the arr if it exists, or return Integer.MAX_VALUE.
     * The array has length n, and values in the array are between 0 and n-1.
     * (The array can be modified.)
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
//        int[] arr = new int[]{2, 3, 1, 0, 2, 5, 3};
//        System.out.println(findDuplicate(arr));
        int[] arr1 = new int[]{1, 2, 3, 4, 4, 5};
        System.out.println(findDuplicate2(arr1));
    }
}

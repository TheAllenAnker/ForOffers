package com.allenanker.chapter2;

public class SmallestInRotatedArr {
    /**
     * Given a rotated version of a sorted array, find the smallest number in array.
     * The original array is sorted in ascending order.
     *
     * @return
     */
    public static int findSmallest(int[] rotatedSortedArr) {
        if (rotatedSortedArr == null || rotatedSortedArr.length == 0) {
            throw new IllegalArgumentException("Invalid parameters");
        }

        int start = 0;
        int end = rotatedSortedArr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid == start) {
                break;
            }
            if (rotatedSortedArr[mid] >= rotatedSortedArr[start]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return rotatedSortedArr[end];
    }

    public static void main(String[] args) {
        int[] rotatedArr = new int[]{2, 1, 1, 1, 1, 2, 2};
        System.out.println(findSmallest(rotatedArr));
    }
}

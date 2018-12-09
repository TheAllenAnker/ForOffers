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
        if (rotatedSortedArr[start] < rotatedSortedArr[end]) {
            return rotatedSortedArr[start];
        }
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid == start) {
                break;
            }
            if (rotatedSortedArr[mid] >= rotatedSortedArr[start] && rotatedSortedArr[mid] != rotatedSortedArr[end]) {
                start = mid;
            } else if (rotatedSortedArr[mid] <= rotatedSortedArr[end] && rotatedSortedArr[mid] != rotatedSortedArr[start]) {
                end = mid;
            } else {
                // when the three numbers are equal, just find the smallest in order
                int min = Integer.MAX_VALUE;
                for (int i = start; i <= end; i++) {
                    min = Math.min(rotatedSortedArr[i], min);
                }
                return min;
            }
        }

        return rotatedSortedArr[end];
    }

    public static void main(String[] args) {
        int[] rotatedArr = new int[]{2, 1, 1, 1, 1, 2, 2};
        System.out.println(findSmallest(rotatedArr));
        System.out.println(findSmallest(new int[]{1, 1, 1, 2}));
        System.out.println(findSmallest(new int[]{1, 0, 1, 1, 1}));
        System.out.println(findSmallest(new int[]{1, 1, 1, 0, 1}));
    }
}

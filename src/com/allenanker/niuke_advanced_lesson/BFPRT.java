package com.allenanker.niuke_advanced_lesson;

import java.util.Arrays;

public class BFPRT {
    /**
     * Return the kth smallest number in arr.
     *
     * @param arr
     * @param k   1 <= k < arr
     * @return
     */
    public static int getKthSmallest(int[] arr, int l, int r, int k) {
        if (arr == null || k <= 0 || k > arr.length) {
            throw new IllegalArgumentException("Param range wrong");
        }
        // get the pivot that will give O(n) time complexity to this algorithm
        int pivot = bfprt(arr);
        int m = partition(arr, l, r, pivot);
        int curr = m - l + 1;
        if (curr == k) {
            return arr[m];
        } else if (curr > k) {
            return getKthSmallest(arr, l, m - 1, k);
        } else {
            return getKthSmallest(arr, m + 1, r, k - curr);
        }
    }

    private static int bfprt(int[] arr) {
        // divide the arr into groups, five numbers each, and sort then in groups
        if (arr.length <= 5) {
            Arrays.sort(arr);
            return arr[arr.length / 2];
        }

        int l = 0;
        int r = l + 5;
        for (; r < arr.length; l += 5, r += 5) {
            Arrays.sort(arr, l, r);
        }
        Arrays.sort(arr, l, arr.length);

        int groups = arr.length % 5 == 0 ? arr.length / 5 : (arr.length / 5) + 1;
        int[] mids = new int[groups];
        int midPos = groups > 1 ? 2 : arr.length / 2;
        for (int i = 0; i < mids.length; i++) {
            mids[i] = arr[midPos];
            midPos = i != mids.length - 2 || arr.length % 5 == 0 ? midPos + 5 :
                    5 * (groups - 1) + ((arr.length % 5) / 2);
        }

        return bfprt(mids);
    }

    private static int partition(int[] arr, int l, int r, int pivot) {
        int smaller = l - 1, larger = r + 1;
        int i = l;
        while (i < larger) {
            if (arr[i] > pivot) {
                swap(arr, i, --larger);
            } else {
                i++;
                smaller++;
            }
        }

        return arr[smaller + 1] > pivot ? smaller : smaller + 1;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 0, -1, -2, -2};
        System.out.println(getKthSmallest(arr, 0, arr.length - 1, 3));
    }
}

package com.allenanker.niuke_advanced_lesson;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BFPRT_II {
    public static int getMinKthByBFPRT(int[] arr, int k) {
        int[] copyArr = Arrays.copyOf(arr, arr.length);
        return bfprt(copyArr, 0, arr.length - 1, k - 1);
    }

    private static int bfprt(int[] arr, int begin, int end, int i) {
        if (begin == end) {
            return arr[begin];
        }
        // choose a pivot, which would lower the problem scale
        int pivot = medianOfMedians(arr, begin, end);
        int[] pivotRange = partition(arr, begin, end, pivot);
        if (i >= pivotRange[0] && i <= pivotRange[1]) {
            return arr[i];
        } else if (i < pivotRange[0]) {
            return bfprt(arr, begin, pivotRange[0] - 1, i);
        } else {
            return bfprt(arr, pivotRange[1] + 1, end, i);
        }
    }

    private static int medianOfMedians(int[] arr, int begin, int end) {
        int length = end - begin + 1;
        int groups = length % 5 == 0 ? length / 5 : (length / 5) + 1;
        int[] mids = new int[groups];
        for (int i = 0; i < mids.length; i++) {
            int gBegin = begin + 5 * i;
            int gEnd = Math.min(gBegin + 4, end);
            mids[i] = getMedian(arr, gBegin, gEnd);
        }

        return bfprt(mids, 0, mids.length - 1, mids.length / 2);
    }

    private static int[] partition(int[] arr, int begin, int end, int pivot) {
        int smaller = begin - 1, curr = begin, larger = end + 1;
        while (curr != larger) {
            if (arr[curr] < pivot) {
                swap(arr, ++smaller, curr++);
            } else if (arr[curr] > pivot) {
                swap(arr, --larger, curr);
            } else {
                curr++;
            }
        }

        return new int[]{smaller + 1, larger - 1};
    }

    private static int getMedian(int[] arr, int start, int end) {
        insertionSort(arr, start, end);
        int sum = start + end;
        int index = sum / 2 + sum % 2;

        return arr[index];
    }

    private static void insertionSort(int[] arr, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int curr = arr[i];
            while (i > start && curr < arr[i - 1]) {
                arr[i] = arr[i - 1];
                i--;
            }
            arr[i] = curr;
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 0, -1, -2, -2};
        System.out.println(getMinKthByBFPRT(arr, 2));
    }
}

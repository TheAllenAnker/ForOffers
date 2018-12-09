package com.allenanker.chapter2;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void quickSort(int[] arr, int length, int start, int end) {
        if (start == end) {
            return;
        }

        int index = partition(arr, length, start, end);
        if (index > start) {
            quickSort(arr, length, start, index - 1);
        }
        if (index < end) {
            quickSort(arr, length, index + 1, end);
        }
    }

    private static int partition(int[] arr, int length, int start, int end) {
        if (arr == null || length <= 0 || start < 0 || end <= start) {
            throw new IllegalArgumentException("Invalid parameters");
        }

        // find a pivot randomly
        int index = start + new Random().nextInt(end - start);
        swap(arr, index, end);
        int small = start - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[end]) {
                small++;
                // swap if necessary
                if (small != i) {
                    swap(arr, small, i);
                }
            }
        }
        small++;
        swap(arr, small, end);

        return small;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 5, 2, 4, 2};
        quickSort(arr, arr.length, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}

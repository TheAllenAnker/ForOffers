package com.allenanker.basics;

import com.allenanker.utils.SortValidation;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        quickSortCore(arr, 0, arr.length - 1);
    }

    private static void quickSortCore(int[] arr, int start, int end) {
        if (start < end && start >= 0 && end < arr.length) {
            // choose a pivot randomly
            swap(arr, end, start + (int) ((end - start + 1) * Math.random()));
            int[] pos = partition(arr, start, end);
            quickSortCore(arr, start, pos[0] - 1);
            quickSortCore(arr, pos[1] + 1, end);
        }


    }

    private static int[] partition(int[] arr, int start, int end) {
        // return two boundaries of the equal part
        int smaller = start - 1;
        int bigger = end;
        while (start < bigger) {
            if (arr[start] < arr[end]) {
                swap(arr, ++smaller, start++);
            } else if (arr[start] > arr[end]) {
                swap(arr, --bigger, start);
            } else {
                start++;
            }
        }
        swap(arr, bigger, end);

        return new int[]{smaller + 1, bigger};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        boolean right = true;
        for (int i = 0; i < 500000; i++) {
            int[] arr = SortValidation.generateRandomArray(9, 10);
            int[] arr1 = Arrays.copyOf(arr, arr.length);
            int[] arr2 = Arrays.copyOf(arr, arr.length);
            quickSort(arr1);
            Arrays.sort(arr2);
            if (!SortValidation.isTwoArrsEquivalent(arr1, arr2)) {
                right = false;
                break;
            }
        }
        if (right) {
            System.out.println("The solution is correct!!!");
        } else {
            System.out.println("The solution is wrong!!!");
        }
    }
}

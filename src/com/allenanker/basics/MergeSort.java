package com.allenanker.basics;

import com.allenanker.utils.SortValidation;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        mergeSortProcess(arr, 0, arr.length - 1);
    }

    private static void mergeSortProcess(int[] arr, int start, int end) {
        if (start == end) {
            return;
        }

        int mid = start + ((end - start) >> 1);
        mergeSortProcess(arr, start, mid);
        mergeSortProcess(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] helper = new int[end - start + 1];
        int i = 0;
        int pos1= start;
        int pos2 = mid + 1;
        while (pos1 <= mid && pos2 <= end) {
            helper[i++] = arr[pos1] < arr[pos2] ? arr[pos1++] : arr[pos2++];
        }
        while (pos1 <= mid) {
            helper[i++] = arr[pos1++];
        }
        while (pos2 <= end) {
            helper[i++] = arr[pos2++];
        }
        System.arraycopy(helper, 0, arr, start, helper.length);
    }

    public static void main(String[] args) {
        boolean right = true;
        for (int i = 0; i < 500000; i++) {
            int[] arr = SortValidation.generateRandomArray(9, 10);
            int[] arr1 = Arrays.copyOf(arr, arr.length);
            int[] arr2 = Arrays.copyOf(arr, arr.length);
            mergeSort(arr1);
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

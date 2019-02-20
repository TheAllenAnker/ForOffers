package com.allenanker.basics;

import com.allenanker.utils.SortValidation;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        boolean right = true;
        for (int i = 0; i < 500000; i++) {
            int[] arr = SortValidation.generateRandomArray(9, 10);
            int[] arr1 = Arrays.copyOf(arr, arr.length);
            int[] arr2 = Arrays.copyOf(arr, arr.length);
            insertionSort(arr1);
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

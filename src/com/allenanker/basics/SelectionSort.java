package com.allenanker.basics;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int index = arr.length - 1;
        while (index >= 0) {
            int maxIndex = index;
            for (int i = 0; i < index; i++) {
                maxIndex = arr[i] > arr[maxIndex] ? i : maxIndex;
            }
            swap(arr, maxIndex, index--);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 1, 7, 6};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

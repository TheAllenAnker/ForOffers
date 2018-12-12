package com.allenanker.chapter3;

import java.util.Arrays;

public class ReorderArray {
    /**
     * Reorder the given array, odd numbers at the front part, even numbers at the back part.
     *
     * @param array the given array
     */
    public static void reorderArray(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int oddI = 0;
        int evenI = array.length - 1;
        while (oddI < evenI) {
            while (oddI < array.length && array[oddI] % 2 != 0) oddI++;
            while (evenI >= 0 && array[evenI] % 2 == 0) evenI--;
            if (oddI < evenI) {
                swap(array, oddI, evenI);
            }
        }
    }

    private static void swap(int[] arr, int aI, int bI) {
        int temp = arr[aI];
        arr[aI] = arr[bI];
        arr[bI] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        reorderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}

package com.allenanker.chapter4;

import java.util.Random;

public class ArraysUtil {
    public static int partition(int[] num, int start, int end) {
        int index = start + new Random().nextInt(end - start + 1);
        swap(num, index, end);
        int smaller = start - 1;
        for (index = start; index < end; index++) {
            if (num[index] < num[end]) {
                smaller++;
                if (smaller != index) {
                    swap(num, index, smaller);
                }
            }
        }
        ++smaller;
        swap(num, smaller, end);

        return smaller;
    }

    public static void swap(int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
}

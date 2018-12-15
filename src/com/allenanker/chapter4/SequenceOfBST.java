package com.allenanker.chapter4;

import java.util.Arrays;

public class SequenceOfBST {
    public static <T extends Comparable> boolean isSequenceOfBST(T[] values, int start, int end) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Invalid parameters");
        }
        if (start == end) {
            return true;
        }

        T pivot = values[end];
        int mid = 0;
        for (int i = end - 1; i >= start; i--) {
            if (values[i].compareTo(pivot) < 0) {
                mid = i;
                break;
            }
        }
        for (int i = mid; i >= start; i--) {
            if (values[i].compareTo(pivot) > 0) {
                return false;
            }
        }

        return isSequenceOfBST(values, 0, mid) && isSequenceOfBST(values, mid + 1, end - 1);
    }

    public static void main(String[] args) {
        Integer[] values = new Integer[]{5, 7, 6, 9, 11, 10, 8};
        System.out.println(isSequenceOfBST(values, 0, values.length - 1));
        Integer[] values2 = new Integer[]{7, 4, 6, 5};
        System.out.println(isSequenceOfBST(values2, 0, values2.length - 1));
    }
}

package com.allenanker.chapter5;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayForMinNum {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 32, 321};
        Integer[] nums = new Integer[arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
        Arrays.sort(nums, new MyComparator());
        System.out.println(Arrays.toString(nums));
    }
}

class MyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer num1, Integer num2) {
        String numStr1 = Integer.toString(num1);
        String numStr2 = Integer.toString(num2);
        String str1 = numStr1 + numStr2;
        String str2 = numStr2 + numStr1;

        if (str1.equals(str2)) {
            return 0;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) > str2.charAt(i)) {
                return 1;
            }
            if (str1.charAt(i) < str2.charAt(i)) {
                return -1;
            }
        }

        return -1;
    }
}

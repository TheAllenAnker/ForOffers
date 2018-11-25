package com.allenanker.niuke_advanced_lesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class ClosestBigger {
    public static int[][] getClosestBigger(int[] arr) {
        int[] cloestBiggerLeft = new int[arr.length];
        int[] cloestBiggerRight = new int[arr.length];
        HashMap<Integer, ArrayList<Integer>> valueMap = new HashMap<>();
        Stack<Integer> values = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int currNum = arr[i];
            if (!valueMap.containsKey(currNum) || (valueMap.containsKey(currNum) && !values.contains(currNum))) {
                ArrayList<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                valueMap.put(currNum, indexes);
            } else {
                ArrayList<Integer> indexes = valueMap.get(currNum);
                indexes.add(i);
                valueMap.put(currNum, indexes);
            }

            while (!values.isEmpty() && values.peek() < currNum) {
                int curr = values.pop();
                for (int index : valueMap.get(curr)) {
                    cloestBiggerRight[index] = currNum;
                    if (!values.isEmpty()) {
                        cloestBiggerLeft[index] = values.peek();
                    } else {
                        cloestBiggerLeft[index] = Integer.MIN_VALUE;
                    }
                }
                if (!values.isEmpty() && values.peek() != curr) {
                    valueMap.remove(curr);
                }
            }
            values.push(currNum);
        }

        int prev = Integer.MIN_VALUE;
        while (!values.isEmpty()) {
            int curr = values.pop();
            for (int index : valueMap.get(curr)) {
                cloestBiggerRight[index] = prev > arr[index] ? prev : Integer.MIN_VALUE;
                if (!values.isEmpty()) {
                    cloestBiggerLeft[index] = values.peek();
                } else {
                    cloestBiggerLeft[index] = Integer.MIN_VALUE;
                }
            }
            prev = curr;
        }

        return new int[][]{cloestBiggerLeft, cloestBiggerRight};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 4, 3, 7, 3, 3, 4, 4, 7};
        int[][] res = getClosestBigger(arr);
        System.out.println(Arrays.toString(res[0]));
        System.out.println(Arrays.toString(res[1]));
    }
}

package com.allenanker.chapter6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class MaxInSlidingWindows {
    public int[] getMaxInSlidingWindows(int[] nums, int windowSize) {
        if (nums == null || nums.length == 0 || windowSize > nums.length) {
            throw new IllegalArgumentException("Invalid parameters");
        }

        int length = nums.length;
        int[] res = new int[length - windowSize + 1];
        int index = 0;
        LinkedList<Integer> maxes = new LinkedList<>();
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        int start = 0;
        maxes.offer(nums[0]);
        for (int i = 1; i < length; i++) {
            while (!maxes.isEmpty() && nums[i] >= maxes.peekLast()) {
                maxes.pollLast();
            }
            maxes.offer(nums[i]);
            indexMap.put(nums[i], i);

            if (i - start + 1 == windowSize) {
                res[index++] = maxes.peekFirst();
                start++;
                if (indexMap.get(maxes.peekFirst()) < start) {
                    maxes.pollFirst();
                }
                if (indexMap.containsKey(nums[start - 1]) && indexMap.get(nums[start - 1]) < start) {
                    indexMap.remove(nums[start]);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4 ,2, 6, 2, 5, 1, 6, 7, 8};
        MaxInSlidingWindows misw = new MaxInSlidingWindows();
        System.out.println(Arrays.toString(misw.getMaxInSlidingWindows(nums, 3)));
    }
}

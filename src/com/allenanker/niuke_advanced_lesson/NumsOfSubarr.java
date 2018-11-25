package com.allenanker.niuke_advanced_lesson;

public class NumsOfSubarr {
    /**
     * Return the number of sub-arrays in arr, the sub-array must satisfy:
     * max(sub-array) - min(sub-array) <= num.
     *
     * @param arr
     * @param num
     * @return
     */
    public static int numbersOfSubArray(int[] arr, int num) {
        SlidingWindow slidingWindow = new SlidingWindow(arr);
        int res = 0;
        // the L and R pointer in SlidingWindow class start from -1, so the boundary is arr.length - 1
        while (slidingWindow.getL() < arr.length - 1) {
            while (slidingWindow.getR() < arr.length - 1) {
                slidingWindow.moveRight(1);
                if (slidingWindow.getMaxInWindow() - slidingWindow.getMinInWindow() > num) {
                    break;
                }
            }
            // all the permutations start from the L pointer satisfy the condition
            res += slidingWindow.getR() - slidingWindow.getL();
            slidingWindow.moveLeft(1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1};
        System.out.println(numbersOfSubArray(arr, 2));
    }
}

package com.allenanker.niuke_advanced_lesson;

import java.util.Stack;

public class MaxRec {
    /**
     * Calculate the max rectangle's area in the matrix.
     *
     * @param matrix the matrix contains only 0 and 1
     * @return
     */
    public static int maxRecInMatrix(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0) {
            return 0;
        }

        int cols = matrix[0].length;
        int[] currHeights = matrix[0];
        int max = maxRecFromBottom(currHeights);
        int i = 1;
        while (i < matrix.length) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    currHeights[j] += 1;
                } else {
                    currHeights[j] = 0;
                }
            }
            max = Math.max(max, maxRecFromBottom(currHeights));
            i++;
        }

        return max;
    }

    /**
     * Calculate the max rectangle's area in the histogram.
     *
     * @param heights forms the histogram
     * @return
     */
    public static int maxRecFromBottom(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                // k is the last height
                int k = stack.pop();
                // j is the index before the rectangle with the last height as an edge starts
                int j = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, heights[k] * (i - j - 1));
            }
            stack.push(i);
        }
        // the remaining values in stack must be in ascending order
        // so the rectangles with each height as an edge will extend until heights.length
        while (!stack.isEmpty()) {
            int k = stack.pop();
            int j = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, heights[k] * (heights.length - j - 1));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{4, 3, 2, 5, 6};
        System.out.println(maxRecFromBottom(heights));
        int[][] matrix = {{1, 0, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 0}, {0, 0, 1, 0}};
        System.out.println(maxRecInMatrix(matrix));
    }
}

package com.allenanker.niuke_advanced_lesson;

import java.util.Stack;

public class VisibleTowerPairs {
    public static int visibleTowerPairs(int[] heights) {
        if (heights == null || heights.length < 2) {
            return 0;
        }

        int maxIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            maxIndex = heights[i] > heights[maxIndex] ? i : maxIndex;
        }

        Stack<Tower> stack = new Stack<>();
        stack.push(new Tower(heights[maxIndex]));
        int index = nextIndex(heights.length, maxIndex);
        int res = 0;
        while (index != maxIndex) {
            while (!stack.isEmpty() && heights[index] > stack.peek().height) {
                int k = stack.pop().size;
                res += getInternalPairs(k) + 2 * k;
            }
            // if there are remaining elements in stack and the current value is equal to one at the top of the stack
            if (!stack.isEmpty() && stack.peek().height == heights[index]) {
                stack.peek().height++;
            } else {
                stack.push(new Tower(heights[index]));
            }
            index = nextIndex(heights.length, index);
        }
        // the remained elements in stack are not processed yet
        while (!stack.isEmpty()) {
            int k = stack.pop().size;
            // if the current one is the last one in stack
            if (stack.isEmpty()) {
                res += getInternalPairs(k);
            } else if (stack.size() == 1) {
                // the one before the last one
                int bottomK = stack.peek().size;
                res += getInternalPairs(k) + bottomK * k;
            } else {
                // others
                res += getInternalPairs(k) + 2 * k;
            }
        }

        return res;
    }

    private static int getInternalPairs(int k) {
        if (k < 2) {
            return 0;
        }

        return factorialOfNum(k) / 2;
    }

    private static int factorialOfNum(int num) {
        if (num == 1) {
            return 1;
        }

        return num * factorialOfNum(num - 1);
    }

    private static int nextIndex(int length, int curr) {
        return curr == length - 1 ? 0 : curr + 1;
    }

    public static void main(String[] args) {
        int[] towerHeights = new int[]{1, 2, 4, 5, 3};
        System.out.println(visibleTowerPairs(towerHeights));
    }
}

class Tower {
    int height;
    int size;

    public Tower(int height) {
        this.height = height;
        this.size = 1;
    }
}

package com.allenanker.chapter4;

import java.util.Stack;

public class StackPushPopOrder {
    public static boolean isValidPushPopOrder(int[] pushOrder, int[] popOrder) {
        if (pushOrder == null || popOrder == null ||
                popOrder.length == 0 || pushOrder.length != popOrder.length) {
            throw new IllegalArgumentException("Invalid parameters");
        }

        Stack<Integer> helperStack = new Stack<>();
        int i = 0, j = 0;
        while (i < pushOrder.length) {
            helperStack.push(pushOrder[i]);
            while (!helperStack.isEmpty() && popOrder[j] == helperStack.peek()) {
                helperStack.pop();
                j++;
            }
            i++;
        }

        return helperStack.isEmpty();
    }

    public static void main(String[] args) {
        int[] push = new int[]{1, 2, 3, 4, 5};
        int[] pop = new int[]{5, 4, 3, 1, 2};
        System.out.println(isValidPushPopOrder(push, pop));
        System.out.println(isValidPushPopOrder(new int[]{1}, new int[]{1}));
        System.out.println(isValidPushPopOrder(null, null)); // an exception will be thrown
    }
}

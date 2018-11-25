package com.allenanker.niuke_advanced_lesson;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindow {
    private int[] arr;
    private int L;
    private int R;
    private Deque<Integer> deque;

    public SlidingWindow(int[] arr) {
        this.arr = arr;
        L = -1;
        R = -1;
        deque = new ArrayDeque<>();
    }

    public void moveRight(int steps) {
        if (steps < 0) {
            throw new IllegalArgumentException("Steps must be bigger than zero");
        }
        if (R + steps > arr.length - 1) {
            throw new IllegalArgumentException("Window's right pointer moves exceed the boundary of the arr");
        }

        for (int i = 0; i < steps; i++) {
            int curr = arr[++R];
            while (!deque.isEmpty() && curr >= arr[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.add(R);
        }
    }

    public void moveLeft(int steps) {
        if (steps < 0) {
            throw new IllegalArgumentException("Steps must be bigger than zero");
        }
        if (L + steps > R) {
            throw new IllegalArgumentException("Window's left pointer moves exceed the right pointer");
        }

        for (int i = 0; i < steps; i++) {
            deque.pollFirst();
            L++;
        }
    }

    public int getMaxInWindow() {
        if (deque.isEmpty()) {
            throw new IllegalStateException("No Elements in Window");
        }

        return arr[deque.peekFirst()];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 1, 3, 6};
        SlidingWindow slidingWindow = new SlidingWindow(arr);
        slidingWindow.moveRight(5);
//        slidingWindow.moveLeft(2);
        System.out.println(slidingWindow.getMaxInWindow());
    }
}

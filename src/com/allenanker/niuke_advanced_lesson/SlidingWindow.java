package com.allenanker.niuke_advanced_lesson;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindow {
    private int[] arr;
    private int L;
    private int R;
    private Deque<Integer> maxDeque;
    private Deque<Integer> minDeque;

    public SlidingWindow(int[] arr) {
        this.arr = arr;
        L = -1;
        R = -1;
        maxDeque = new ArrayDeque<>();
        minDeque = new ArrayDeque<>();
    }

    public int getL() {
        return L;
    }

    public int getR() {
        return R;
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
            while (!maxDeque.isEmpty() && curr >= arr[maxDeque.peekLast()]) {
                maxDeque.pollLast();
            }
            maxDeque.add(R);
            while (!minDeque.isEmpty() && curr <= arr[minDeque.peekLast()]) {
                minDeque.pollLast();
            }
            minDeque.add(R);
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
            L++;
            if (L == maxDeque.peekFirst()) {
                maxDeque.pollFirst();
            }
            if (L == minDeque.peekFirst()) {
                minDeque.pollFirst();
            }
        }
    }

    public int getMaxInWindow() {
        if (maxDeque.isEmpty()) {
            throw new IllegalStateException("No Elements in Window");
        }

        return arr[maxDeque.peekFirst()];
    }

    public int getMinInWindow() {
        if (minDeque.isEmpty()) {
            throw new IllegalStateException("No Elements in Window");
        }

        return arr[minDeque.peekFirst()];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 1, 3, 6};
        SlidingWindow slidingWindow = new SlidingWindow(arr);
        slidingWindow.moveRight(3);
        slidingWindow.moveLeft(1);
        System.out.println(slidingWindow.getMaxInWindow());
        System.out.println(slidingWindow.getMinInWindow());
    }
}

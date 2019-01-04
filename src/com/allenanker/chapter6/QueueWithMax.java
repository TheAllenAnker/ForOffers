package com.allenanker.chapter6;

import java.util.LinkedList;
import java.util.Queue;

public class QueueWithMax {
    private Queue<Integer> data;
    private LinkedList<Integer> maxes;

    public QueueWithMax() {
        data = new LinkedList<>();
        maxes = new LinkedList<>();
    }

    public void push(int num) {
        data.offer(num);
        while (!maxes.isEmpty() && num > maxes.peekLast()) {
            maxes.pollLast();
        }
        maxes.offer(num);
    }

    public int pop() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        maxes.pollFirst();

        return data.poll();
    }

    public int getMax() {
        return maxes.peekFirst();
    }

    public void clearQueue() {
        data.clear();
        maxes.clear();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4, 5, 1};
        QueueWithMax queueWithMax = new QueueWithMax();
        for (int i = 0; i < nums.length; i++) {
            queueWithMax.push(nums[i]);
            System.out.println(queueWithMax.getMax());
        }
        queueWithMax.clearQueue();
        queueWithMax.push(nums[0]);
        queueWithMax.push(nums[1]);
        queueWithMax.pop();
        System.out.println(queueWithMax.getMax());
    }
}

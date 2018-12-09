package com.allenanker.chapter2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a stack with two queues.
 */
public class CStack<T> {
    private Queue<T> dataQueue;
    private Queue<T> helperQueue;

    public CStack() {
        dataQueue = new LinkedList<>();
        helperQueue = new LinkedList<>();
    }

    public void push(T node) {
        dataQueue.add(node);
    }

    public T pop() {
        while (dataQueue.size() > 1) {
            helperQueue.add(dataQueue.poll());
        }
        T res = !dataQueue.isEmpty() ? dataQueue.poll() : null;
        swapTwoQueues();
        return res;
    }

    private void swapTwoQueues() {
        Queue<T> temp;
        temp = dataQueue;
        dataQueue = helperQueue;
        helperQueue = temp;
    }

    public static void main(String[] args) {
        CStack<Integer> stack = new CStack<>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

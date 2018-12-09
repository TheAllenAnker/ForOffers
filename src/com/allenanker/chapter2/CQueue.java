package com.allenanker.chapter2;

import java.util.Stack;

/**
 * Implement a queue using two stacks.
 */
public class CQueue<T> {
    private Stack<T> dataStack;
    private Stack<T> helperStack;

    public CQueue() {
        this.dataStack = new Stack<>();
        this.helperStack = new Stack<>();
    }

    public void appendTail(T node) {
        dataStack.push(node);
    }

    public T deleteHead() {
        if (!helperStack.isEmpty()) {
            return helperStack.pop();
        } else {
            while (!dataStack.isEmpty()) {
                helperStack.push(dataStack.pop());
            }
            return !helperStack.isEmpty() ? helperStack.pop() : null;
        }
    }

    public static void main(String[] args) {
        CQueue<Integer> queue = new CQueue<>();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        Integer curr;
        while ((curr = queue.deleteHead()) != null) {
            System.out.println(curr);
        }
    }
}

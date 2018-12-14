package com.allenanker.chapter4;

import java.util.Stack;

public class MinInStack<T extends Comparable> {
    private Stack<T> dataStack;
    private Stack<T> minStack;

    public MinInStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(T element) {
        dataStack.push(element);
        if (minStack.isEmpty() || element.compareTo(minStack.peek()) < 0) {
            minStack.push(element);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public T pop() {
        minStack.pop();
        return dataStack.pop();
    }

    public T min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinInStack<Integer> integerMinInStack = new MinInStack<>();
        integerMinInStack.push(3);
        integerMinInStack.push(4);
        integerMinInStack.push(2);
        integerMinInStack.push(1);
        integerMinInStack.pop();
        integerMinInStack.pop();
        integerMinInStack.push(0);
        System.out.println();
    }
}
